package baekjoon;

import java.util.*;
import java.io.*;

public class bak_14503 {
    // 북, 동, 남, 서
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M;
    static int[][] Map;
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        // 0 북, 1동, 2 남, 3 서.
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(x,y,d);

        System.out.println(count);
    }

    // 현재 칸 청소 -> 청소되지 않은 칸 확인
    // 청소할 곳 존재 -> 반시계 방향으로 90되 회전
        //
    static void bfs(int x, int y, int d){

        while(true){
            // 현재 칸 청소
            if(Map[x][y] == 0){
                Map[x][y] = 2;
                count++;
            }

            boolean check = false;
            for(int i = 0; i< 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (Map[nx][ny] == 0) {
                        check = true;
                        break;
                    }
                }
            }

            // 경우의 수 나누기
            if(check){
                d = (d+3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx >=0 && ny >=0 && nx < N && ny <M){
                    if(Map[nx][ny] == 0){
                        x = nx;
                        y = ny;
                    }
                }
            } else{
                int bx = x - dx[d];
                int by = y - dy[d];

                if(bx<0 || by < 0 || bx >=N || by >= M || Map[bx][by] == 1) {
                    break;
                }else{
                    x = bx;
                    y = by;
                }
            }

        }
    }
}
