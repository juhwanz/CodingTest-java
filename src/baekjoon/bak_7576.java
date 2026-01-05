package baekjoon;

import java.util.*;
import java.io.*;

public class bak_7576 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;

    // BFS 큐를 전역으로 선언 (모든 익은 토마토를 담기 위해)
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토 발견시 즉시 큐에 삽입. - 동시에 퍼져나감.
                if (map[i][j] == 1) q.offer(new Point(i, j));
            }
        }

        // 한 번만 실행
        bfs();

        int maxDay = 0;

        for(int i = 0; i< N; i++){
            for(int j = 0; j<M;j++){
                // 만약 안 익은 토마토 존재? -> -1
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                maxDay = Math.max(maxDay, map[i][j]);
            }
        }

        System.out.println(maxDay -1);
    }

    static void bfs(){
        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && ny >=0 && nx < N && ny<M && map[nx][ny] == 0){
                    map[nx][ny] = map[now.x][now.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

}
