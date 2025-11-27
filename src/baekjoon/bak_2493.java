package baekjoon;

import java.util.*;
import java.io.*;

public class bak_2493 {
    //탑
    static class Top{
        int height;
        int num;
        Top(int height, int num){
            this.height = height;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i =1; i<=N;i++){
            int c_h = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek().height >= c_h){
                    sb.append(stack.peek().num).append(" ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()) System.out.println("0 ");

            stack.push(new Top(c_h,i));
        }

        System.out.println(sb);
    }
}
