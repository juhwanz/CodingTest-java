package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bak_7785 {
    // 7785번
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = new String[2];
        HashSet<String> hs = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N;i++){
            a = br.readLine().split(" ");
            if(a[1].equals("enter")){
                hs.add(a[0]);
            }
            else if(a[1].equals("leave")){
                hs.remove(a[0]);
            }
        }

        // Set -> list 변환법 *****
        ArrayList<String> list = new ArrayList<>(hs);

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
