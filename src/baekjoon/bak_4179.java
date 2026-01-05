package baekjoon;

import java.io.*;
import java.util.*;

public class bak_4179 {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R, C; // R: 행(세로), C: 열(가로)
    static char[][] Map;
    static int[][] FireTime;
    static int[][] EscapeTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Map = new char[R][C];
        FireTime = new int[R][C];
        EscapeTime = new int[R][C];

        Queue<Point> qFire = new LinkedList<>();
        Point jihunStart = null;

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                Map[i][j] = str.charAt(j);
                // 불의 도달 시간을 아주 큰 값으로 초기화 (불이 안 오는 곳은 안전해야 하니까)
                FireTime[i][j] = Integer.MAX_VALUE;

                if (Map[i][j] == 'F') {
                    qFire.offer(new Point(i, j));
                    FireTime[i][j] = 0;
                } else if (Map[i][j] == 'J') {
                    jihunStart = new Point(i, j);
                    EscapeTime[i][j] = 0;
                }
            }
        }

        // 1. 불 BFS 먼저 (모든 불 시작점을 미리 큐에 넣고 시작)
        bfsFire(qFire);

        // 2. 지훈 BFS (탈출 여부 판단)
        bfsEscape(jihunStart);
    }

    static void bfsFire(Queue<Point> q) {
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                // 범위 체크 및 벽/기존 방문 체크
                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (Map[nx][ny] != '#' && FireTime[nx][ny] == Integer.MAX_VALUE) {
                        FireTime[nx][ny] = FireTime[now.x][now.y] + 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    static void bfsEscape(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // ★ 핵심: 범위를 벗어난다는 것은 탈출에 성공했다는 뜻!
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    System.out.println(EscapeTime[now.x][now.y] + 1);
                    return;
                }

                // 이동 조건: 벽이 아니고, 방문하지 않았으며, 불보다 빨리 도착해야 함
                if (Map[nx][ny] == '.' && EscapeTime[nx][ny] == 0) {
                    if (EscapeTime[now.x][now.y] + 1 < FireTime[nx][ny]) {
                        EscapeTime[nx][ny] = EscapeTime[now.x][now.y] + 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}