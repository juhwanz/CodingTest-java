package pratice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("people", "사람");
        map.put("baseball", "야구");
        // key -> value
        System.out.println(map.get("people"));
        System.out.println(map.getOrDefault("java", "자바"));
        System.out.println(map.containsKey("people")); // true
        System.out.println(map.remove("people")); // 반환 후 삭제.
        System.out.println(map.keySet()); // -> set 자료형으로 반환
        ArrayList<String> keyList = new ArrayList<>(map.keySet());
    }
}
