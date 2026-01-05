package retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bak_1926 {
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
    static int count;
    static int MaxV;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        visited = new boolean[N][M];
        count = 0;
        MaxV = 0;

        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<N;i++){
            for(int j = 0; j<M; j++){
                if(Map[i][j] == 1 && !visited[i][j]){
                    bfs(i,j);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(MaxV);

    }
    static void bfs(int x, int y){
        int c = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Point now = q.poll();

            for(int i = 0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny <M){
                    if(Map[nx][ny] == 1 && !visited[nx][ny]){
                        q.offer(new Point(nx,ny));
                        visited[nx][ny] = true;
                        c++;
                    }
                }
            }
        }

        MaxV = Math.max(MaxV,c);
    }
}
