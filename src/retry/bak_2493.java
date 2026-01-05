package retry;

import java.io.*;
import java.util.*;

public class bak_2493 {
    static class Point{
        int h;
        int idx;
        Point(int h, int idx){
            this.h = h;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Point> stack = new Stack<Point>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if (stack.peek().h >= height){
                    sb.append(stack.peek().idx + " ");
                    break;
                }

                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            }

            stack.push(new Point(height, i+1));
        }
        System.out.println(sb.toString());
    }
}
