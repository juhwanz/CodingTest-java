package retry;

import java.io.*;
import java.util.*;

public class bak_1406 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        Deque<Character> stackL = new ArrayDeque<>();
        Deque<Character> stackR = new ArrayDeque<>();
        for(char s : str){
            stackL.push(s);
        }

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            char c = s.charAt(0);
            if(c == 'P'){
                char[] sq = s.toCharArray();
                stackL.push(sq[2]);
                //stackL.push(s.charAt(2));
            }
            else if(c == 'L' && !stackL.isEmpty()){
                stackR.push(stackL.pop());
            }
            else if(c=='D' && !stackR.isEmpty()){
                stackL.push(stackR.pop());
            }
            else if(c == 'B' && !stackL.isEmpty()){
                stackL.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stackL.isEmpty()){
            sb.append(stackL.pop());
        }
        sb.reverse();

        while(!stackR.isEmpty()){
            sb.append(stackR.pop());
        }

        System.out.println(sb.toString());
    }
}
