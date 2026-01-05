package retry;

import java.io.*;
import java.util.*;

public class bak_15649 {
    static int N,R;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[R];
        visited = new boolean[N];

        bt(0);

        System.out.println(sb);
    }
    static void bt(int depth){

        if(depth == R){
            for(int n : arr){
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 0 ; i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                arr[depth] = i+1;
                bt(depth+1);
                visited[i]=false;
            }
        }
    }
}
