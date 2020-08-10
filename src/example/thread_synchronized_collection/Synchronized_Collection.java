package example.thread_synchronized_collection;

import java.util.*;

public class Synchronized_Collection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Aa");
        list.add("Bb");
        list.add("Cc");
        list.add("Dd");
        list.add("Ee");
        System.out.println("Value " + list);
        Collection<String> c = Collections.synchronizedCollection(list);
        System.out.println("Synchronized collection : " + c);

        Collection<String> list1=Collections.synchronizedList(list);
        System.out.print("Synchronized list "+list1);

        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(12);
        set.add(13);
        set.add(14);
        set.add(15);
        Collection<Integer> set1=Collections.synchronizedSet(set);
        System.out.println();
        System.out.print("Synchronized set "+ set1);

        SortedSet<Integer> sortedSet=new TreeSet<>();
        sortedSet.add(51);
        sortedSet.add(152);
        sortedSet.add(13);
        sortedSet.add(114);
        sortedSet.add(15);
        Collection<Integer> sortedSet1=Collections.synchronizedSortedSet(sortedSet);
        System.out.println();
        System.out.println("Sorted set "+sortedSet1);

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "e");
        map.put("2", "p");
        map.put("3", "g");
        map.put("4", "y");
        Map<String, String> synchronizedMap = Collections.synchronizedMap(map);
        System.out.println("synchronizedMap contains : " + synchronizedMap);

        SortedMap<String,String > sortedMap=new TreeMap<>();
        sortedMap.put("3", "e");
        sortedMap.put("4", "p");
        sortedMap.put("1", "g");
        sortedMap.put("2", "y");
        SortedMap<String ,String> sortedMap1=Collections.synchronizedSortedMap(sortedMap);
        System.out.println("Sorted map : "+sortedMap1);
    }
}
