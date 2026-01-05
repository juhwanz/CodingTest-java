package baekjoon;

import java.util.*;
import java.io.*;

public class bak_1012 {
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M,P;
    static int[][] Map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t< T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            Map = new int[N][M];
            visited = new boolean[N][M];

            for(int p = 0; p<P; p++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                Map[y][x] = 1;
            }

            int count = 0;
            for(int i = 0; i<N;i++){
                for(int j = 0; j<M; j++){
                    if(Map[i][j] == 1 && !visited[i][j]){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y]=true;

        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M && Map[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Point(nx,ny));
                }
            }
        }

    }
}
