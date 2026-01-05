package pratice;

import java.util.*;

public class One{
    public static void main(String[] args) {
        // ==========================================
        // 1. List (리스트) - 순서 O, 중복 O
        // ==========================================

        // ArrayList: 조회 빠름 O(1), 삽입/삭제 느림 O(n)
        List<String> arrayList = new ArrayList<>();
        // LinkedList: 조회 느림 O(n), 삽입/삭제 빠름 O(1) (노드 위치 알 경우)
        List<String> linkedList = new LinkedList<>();

        // 추가
        arrayList.add("Java");
        arrayList.add("Spring");
        arrayList.add(1, "Python"); // 특정 인덱스 삽입

        // 조회 및 수정
        String item = arrayList.get(0); // 인덱스로 조회
        arrayList.set(0, "Java 21");  // 수정

        // 삭제
        arrayList.remove("Python"); // 객체로 삭제
        arrayList.remove(0);        // 인덱스로 삭제

        // 순회
        for (String s : arrayList) {
            System.out.println(s);
        }

        // ==========================================
        // 2. Set (집합) - 순서 X, 중복 X
        // ==========================================
        // HashSet: 가장 빠름, 순서 보장 안 함
        Set<Integer> hashSet = new HashSet<>();

        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(10); // 중복 무시됨

        // 포함 여부 확인 O(1)
        if (hashSet.contains(20)) {
            System.out.println("20 exists");
        }

        // 삭제
        hashSet.remove(10);

        // TreeSet: 오름차순 정렬됨 O(log n)
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 1, 3));
        System.out.println("TreeSet(Sorted): " + treeSet); // [1, 3, 5]

        // ==========================================
        // 3. Map (맵) - Key-Value 쌍, Key 중복 X
        // ==========================================
        // HashMap: 순서 보장 안 함, O(1)
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 추가 및 수정
        hashMap.put("Apple", 1000);
        hashMap.put("Banana", 2000);
        hashMap.put("Apple", 1500); // Key 중복 시 Value 덮어쓰기

        // 조회
        int price = hashMap.get("Banana");
        int defaultPrice = hashMap.getOrDefault("Melon", 0); // null 방지

        // Key/Value 존재 확인
        boolean hasKey = hashMap.containsKey("Apple");

        // LinkedHashMap: 입력 순서 보장
        // TreeMap: Key 기준 오름차순 정렬

        // ==========================================
        // 4. Stack (스택) - LIFO (Last In First Out)
        // ==========================================
        // java.util.Stack은 Vector를 상속받아 무거우므로 ArrayDeque 권장
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1); // 삽입
        stack.push(2);

        int top = stack.peek(); // 최상단 조회 (삭제 X)
        int popped = stack.pop(); // 최상단 꺼내기 (삭제 O)

        System.out.println("Popped: " + popped);

        // ==========================================
        // 5. Queue (큐) - FIFO (First In First Out)
        // ==========================================
        // Queue는 인터페이스이므로 LinkedList로 구현
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(100); // 삽입 (add는 예외 발생 가능성 있음)
        queue.offer(200);

        int first = queue.peek(); // 맨 앞 조회 (삭제 X)
        int polled = queue.poll(); // 맨 앞 꺼내기 (삭제 O)

        System.out.println("Polled: " + polled);


        // ==========================================
        // 6. PriorityQueue (우선순위 큐) - Heap
        // ==========================================

        // 기본: 최소 힙 (작은 숫자가 우선)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 최대 힙 (큰 숫자가 우선)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(20);

        while (!minHeap.isEmpty()) {
            // 10 -> 20 -> 30 순서로 출력
            System.out.println(minHeap.poll());
        }


        // ==========================================
        // 7. Array & Collections Utils (유틸리티)
        // ==========================================
        int[] arr = {5, 2, 9, 1};
        Arrays.sort(arr); // 배열 정렬
        System.out.println("Arrays.toString: " + Arrays.toString(arr));

        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 9, 1));
        Collections.sort(numbers); // 리스트 오름차순
        Collections.sort(numbers, Collections.reverseOrder()); // 리스트 내림차순

        System.out.println("Max: " + Collections.max(numbers));
    }
}
