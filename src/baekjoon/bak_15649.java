package baekjoon;

import java.util.*;
import java.io.*;

public class bak_15649 {
    static int N,M;
    static int[] arr; // M개를 담을 배열 상자
    static boolean[] visited; // 1~N까지 사용 여부 체크
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[M];

        // 0 번째 칸부터 채우러 가자
        bT(0);

        System.out.println(sb);
    }
    static void bT(int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i<=N;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                bT(depth + 1);
                visited[i] = false;
            }
        }
    }
}
