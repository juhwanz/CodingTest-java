package baekjoon;

import java.io.*;
import java.util.*;

public class bak_9663 {
    static int N;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = 0;

        // 인덱스가 행, 값이 열
        arr = new int[N];

        BT(0);

        System.out.println(count);
    }

    static void BT(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i = 0; i<N; i++){

            // 일단 depth, i에 퀸 놓기.
            arr[depth] = i;

            // 놓은 자리가 유망한지, 아닌지.
            if(possibility(depth)){
                BT(depth+1);
            }
        }
    }

    // 현재 행(col)에 놓은 퀸이 기존 퀸들에게 공격 받는지 확인
    static boolean possibility(int col){
        for(int i = 0; i<col; i++){
            if(arr[col] == arr[i]) return false;

            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }
}
