package baekjoon;

import java.io.*;
import java.util.*;

public class bak_10866 {
    // 덱
    public static void main(String[] args) throws IOException {
        Deque<Integer> dq = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i< N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str){
                case "push_front":
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.pollFirst());
                    break;
                case "pop_back" :
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.pollLast());
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
