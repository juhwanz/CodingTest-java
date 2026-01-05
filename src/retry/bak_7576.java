package retry;

import java.util.*;
import java.io.*;

public class bak_7576 {
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<Point> q;
    static int[][] Map;

    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Map = new int[N][M];


        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
                if (Map[i][j] == 1) q.offer(new Point(i, j));
            }
        }

        bfs();

        int maxDay = 0;

        for(int i = 0; i<N;i++){
            for(int j = 0; j<M; j++){
                if(Map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                maxDay = Math.max(maxDay, Map[i][j]);
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
                if(nx>=0 && ny>=0 && nx < N && ny <M){
                    if(Map[nx][ny] == 0){
                        Map[nx][ny] = Map[now.x][now.y] + 1;
                        q.offer(new Point(nx,ny));
                    }
                }
            }
        }
    }
}
