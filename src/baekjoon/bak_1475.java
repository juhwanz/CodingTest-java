package baekjoon;

import java.io.*;

public class bak_1475 {
    //방 번호
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int[] count = new int[9];
        for(int i = 0; i<ch.length;i++){
            if(ch[i] != '6' && ch[i] != '9') count[ch[i]-'0']++;
            else{
                count[6]++;
            }
        }

        if(count[6] %2 == 0) count[6] = count[6]/2;
        else count[6] = count[6]/2+1;
        /* 수학적 공식
        count[6] = (count[6]+1)/2;
         */

        int maxCount = 0;
        for(int t : count){
            maxCount = Math.max(t,maxCount);
        }

        System.out.println(maxCount);
        // O(N)
    }
}
