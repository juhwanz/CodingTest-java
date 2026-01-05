package baekjoon;

import java.io.*;
import java.util.*;

public class backtrackingBasicTemp{
    static int N,M;
    static int[] arr;           //결과를 담을 상자
    static boolean[] visited;   // 방문 여부 체크장부
    static int answer = 0;      // 정답 개수 카운트(옵션)
    public static void main(String[] args) throws IOException{
        BT(0);
    }
    static void BT(int depth){
        /* 종료 조건 - 브레이크!*/
        // 목표 깊이 도달 or 더 이상 탐색 필요 없을 시
        if(depth == M) return;

        /*탐색 (Recursive) - Pruning */
        for(int i = 0; i<N; i++){
            /* 유망 판단 (Promising) - 가지치기 */
            if(!visited[i]){
                // 상태 변화
                visited[i] = true;
                arr[depth] = i + 1;
                // 다음 단계로
                BT(depth +1);
                // 원상 복구
                visited[i] = false;
            }
        }
    }
}
