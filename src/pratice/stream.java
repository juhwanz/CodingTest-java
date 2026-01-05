package pratice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class stream {
    // 생성 -> 가공 -> 결과
    // Source -> Intermediate -> Terminal
    // 생성 : 컬렉션, 배열 등에서 스트림 열기
    // 중간 연상 : 데이터 가공. (필터링, 변환, 정렬등 ) 체이닝 가능
    // 최종 연산 : 결과 도출

    // 기본 패턴 ( Filter & Map)
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Kim", "Lee", "Park", "Choi", "Kang");

        List<String> result = names.stream()    //생성
                .filter(name-> name.startsWith("K")) // 가공
                .map(String::toUpperCase)       //가공
                .sorted()                       //가공
                .collect(Collectors.toList());   //결과
        System.out.println(result);
    }

    // 통계 및 집계
    int[] scores = {50, 80, 70, 90, 60};

    //평균
    double avg = IntStream.of(scores)
            .average()
            .orElse(0.0);

    int sum = IntStream.of(scores).sum();

    

}
