package JUC;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) throws NoSuchFieldException {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(6);
        arrayList.add(5);
        arrayList.set(0, 2);
        arrayList.set(1, 2);
        for (int i = 0; i < arrayList.size();i++) {
             System.out.println(arrayList.get(i));
        }
        arrayList.sort(Comparator.comparingInt(o -> o));
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "aa");
        treeMap.putIfAbsent(2, null);
        //treeMap.put(null, null);
        //System.out.println(null == treeMap.get(2));
        System.out.println(treeMap.get(1));
        TreeSet<Integer> hashSet = new TreeSet<>();
        hashSet.add(1);
        Class abl = hashSet.getClass();
        System.out.println(abl.getDeclaredField("PRESENT"));
    }
}
