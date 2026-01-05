package baekjoon;

import java.io.*;
import java.util.*;

public class bak_1697 {
    static int N,K;
    static int[] dist = new int[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N==K){
            System.out.println(0);
            return;
        }

        bfs(N);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 1;
        while( !q.isEmpty()){
            int now = q.poll();

            int[] nexts = {now -1, now +1, now * 2};

            for(int next : nexts){
                if(next>=0 && next<= 100000){
                    if(next == K){
                        System.out.println(dist[now]);
                        return;
                    }

                    if(dist[next] == 0){
                        dist[next] = dist[now] + 1;
                        q.offer(next);
                    }
                }
            }
        }
    }
}
