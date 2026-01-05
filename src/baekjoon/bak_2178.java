package baekjoon;

import java.io.*;
import java.util.*;

public class bak_2178 {
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M;
    static int[][] Map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<M; j++){
                Map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(Map[N-1][M-1]);
    }

    static void bfs(int startX, int startY){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY));
        visited[startX][startY] = true; // 시작점 방문 처리

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(Map[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                Map[nx][ny] = Map[now.x][now.y] + 1; // 거리 갱신
                q.offer(new Point(nx, ny));
            }
        }
    }
}
