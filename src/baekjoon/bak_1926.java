package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class bak_1926 {
    static int[] dx = {-1,1,0,0}; // 상하 좌우
    static int[] dy = {0,0,-1,1};
    static int[][] Map;
    static boolean[][] visited;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        Map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int maxArea = 0;

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(!visited[i][j] && Map[i][j] == 1){
                    count++;
                    maxArea = Math.max(maxArea, bfs(i,j));
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);

    }

    static int bfs(int startX, int startY){
        int NowArea = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX,startY));
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i = 0; i<4; i++){
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                if(nx>=0 && ny>=0 && nx<N && ny<M && Map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    NowArea++;
                    q.offer(new Point(nx,ny));
                }
            }
        }
        return NowArea;
    }
    // 번외 : dfs
    static int dfs(int x, int y){
        visited[x][y] = true;
        int area = 1;

        for(int i = 0; i< 4; i++){
            int nx = x + dx[i];
            int ny= y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny]) continue;
            if (Map[nx][ny] == 0) continue;

            area+= dfs(nx,ny);
        }
        return area;
    }

}
