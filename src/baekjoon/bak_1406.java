package baekjoon;

import java.io.*;
import java.util.*;

public class bak_1406 {
    //에디터
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            s1.push(str.charAt(i));
        }

        for(int i = 0; i < M; i++){
            String commandLine = br.readLine();
            char command = commandLine.charAt(0); // StringTokenizer보다 charAt이 더 가볍고 빠름

            switch(command) {
                case 'L':
                    if(!s1.isEmpty()) s2.push(s1.pop());
                    break;
                case 'D':
                    if(!s2.isEmpty()) s1.push(s2.pop());
                    break;
                case 'B':
                    if(!s1.isEmpty()) s1.pop();
                    break;
                case 'P':
                    char t = commandLine.charAt(2); // "P x" 형식이므로 인덱스 2가 문자
                    s1.push(t);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        while(!s2.isEmpty()){
            sb.append(s2.pop());
        }

        System.out.println(sb);
    }
}
