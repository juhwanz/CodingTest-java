package baekjoon;

import java.io.*;
import java.util.*;

public class bak_2667 {
    static List<Integer> list = new ArrayList<>();
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int[][] Map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<N; j++){
                Map[i][j]=str.charAt(j) - '0';
            }
        }

        for(int i = 0 ;i<N; i++){
            for(int j = 0; j<N; j++){
                if(Map[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());


        for(int i = 0 ; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }

    static void bfs(int startX, int startY){
        Queue<Point> q = new LinkedList<>();
        int num = 1;
        q.offer(new Point(startX, startY));
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i = 0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx>=0 && ny >= 0 && nx <N && ny <N && Map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Point(nx,ny));
                    num++;
                }
            }
        }

        list.add(num);
    }
}
