package pratice;

import java.util.*;
import java.util.stream.Collectors;

class Node implements Comparable<Node>{
    int id;
    int cost;
    public Node(int id, int cost){
        this.id = id;
        this.cost = cost;
    }

    // 1. Comparable : 객체 자체 기본 정렬 기준( 비용 오름순위)
    @Override
    public int compareTo(Node other){
        return Integer.compare(this.cost, other.cost);
    }
    @Override
    public String toString() { return "Node(" + id + ", " + cost + ")"; }
}
public class Advanced {
    public static void main(String[] args) {
        // ==========================================
        // 8. Custom Sorting (Comparable vs Comparator)
        // ==========================================
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(1, 30));
        nodes.add(new Node(2, 10));
        nodes.add(new Node(3, 20));

        // Comparable 사용 (클래스 내부 compareTo)
        Collections.sort(nodes);

        // Comparator 사용 (람다식, 커스텀), 내림차순
        nodes.sort((n1,n2) -> Integer.compare(n2.cost, n1.cost));

        // ==========================================
        // 9. Stream API (데이터 가공) - 실무 필수
        // ==========================================
        List<String> rawData = Arrays.asList("apple", "banana", "avocado", "cherry");

        // 필터링 -> 변환 -> 리스트 ㅂ변환
        List<String> result = rawData.stream()
                .filter(s -> s.startsWith("a")) // a로 지삭ㅈ하는 것만
                .map(String::toUpperCase)       // 대문자 변환
                .sorted()                       // 정렬
                .collect(Collectors.toList());  // 리스트로 변환


        // ==========================================
        // 11. Graph Representation (인접 리스트)
        // ==========================================
        System.out.println("\n--- 11. Graph (Adjacency List) ---");
        // 정점 개수 N=3 (0, 1, 2)
        int N = 3;
        List<List<Integer>> graph = new ArrayList<>();

        // 초기화
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 연결 (양방향) 0 <-> 1
        graph.get(0).add(1);
        graph.get(1).add(0);

        // 1 <-> 2
        graph.get(1).add(2);
        graph.get(2).add(1);

        System.out.println("Node 1 is connected to: " + graph.get(1));


        // ==========================================
        // 12. Iterator (안전한 순회 삭제)
        // ==========================================
        System.out.println("\n--- 12. Iterator ---");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Iterator<Integer> it = list.iterator();

        while(it.hasNext()) {
            int val = it.next();
            if (val == 2) {
                it.remove(); // for-each 문에서 remove 시 예외 발생하므로 Iterator 사용
            }
        }
        System.out.println("After Iterator remove: " + list);
    }
}
