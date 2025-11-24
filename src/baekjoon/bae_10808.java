package baekjoon;

import java.util.*;
import java.io.*;

public class bae_10808 {
    // 알파벳 개수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int[] ans = new int[26];

        for(int i = 0; i<ch.length;i++){
            char c = ch[i];
            ans[c-'a']++;
        }

        // 시간 초과 가능성
        for(int i =0;i<ans.length;i++){
            System.out.print(ans[i] + " ");
        }
        /* 출력 최적화
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<ans.length; i++) sb.append(" ");
        System.out.println(sb);*/
    }
}
