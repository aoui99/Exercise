package HashMapIterator;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        /**
         * 迭代器 EntrySet
         */
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        /**
         * 迭代器 KeySet
         */
        Iterator<Integer> iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            Integer key = iterator2.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }

        /**
         * ForEach EntrySet
         */
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        /**
         * ForEach KeySet
         */
        for (Integer key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }

        /**
         * Lambda
         */
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });

        /**
         * Streams API 单线程
         */
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });

        /**
         * Streams API 多线程
         */
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
}
