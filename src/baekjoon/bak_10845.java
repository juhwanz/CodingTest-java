package baekjoon;

import java.io.*;
import java.util.*;

public class bak_10845 {
    //큐
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<Integer> dq = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str){
                case "push":
                    dq.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.poll());
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if(dq.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.peekFirst());
                    break;
                case "back":
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.peekLast());
                    break;
            }
        }

    }
}
