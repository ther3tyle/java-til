package main.io.dsub.day16;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

    private static final String[] array = {"Collection", "Framework", "is", "so", "cool"};

    private static Stream<String> getStream() {
        return Arrays.stream(array);
    }

    public static void main(String[] args) {

        Stream<String> stream;

        // collect() Method
        // Stream API 는 JCF -> Stream -> 처리 -> 결과(출력, 값, Collection)

        // Collectors 클래스의 정적 메소드를 이용하는 방법
        // toList() 메소드를 쓸 경우, ArrayList로 collect하는 Collector 반환

        // ArrayList로 반환
        stream = getStream();
        List<String> list = stream
                .collect(Collectors.toList());
        System.out.println(list.toString());

        // LinkedList로 반환
        stream = getStream();
        list = stream
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(list.toString());

        // toSet() 메소드를 사용할 경우 HashSet으로 collect 하는 Collector 반환
        stream = getStream();
        Set<String> set = stream
                .collect(Collectors.toSet());
        System.out.println(set.toString());

        // TreeSet과 같이 Set interface를 상속한 클래스의 객체로 전달 가능하다.
        stream = getStream();
        set = stream
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set.toString());

        // Map<K, V> Map.Entry<K, V>
        stream = getStream();
        Map<String, Integer> map = stream
                .collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map.toString());

        // 그룹화, 분리 - groupingBy, partitioningBy

        // Grouping: by criteria
        String[] mapStrings = {"Python", "is", "awful", "lame", "not", "good"};
        Map<Integer, List<String>> groupMap = Arrays.stream(mapStrings)
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupMap);

        // Partitioning: by true or false
        mapStrings = new String[]{"Python", "is", "awful", "lame", "not", "good"};
        Map<Boolean, List<String>> partitionMap = Arrays.stream(mapStrings)
                .collect(Collectors.partitioningBy(s -> s.length() < 3));
        System.out.println(partitionMap);

        // Grouping + Downstream collector
        // terminal 메소드에 있던 count(), min()... 등과 유사한
        // Collectors 중에서도 Counting(), minBy(), maxBy() ... 등이 있다.
        mapStrings = new String[]{"Python", "is", "awful", "lame", "not", "good"};
        Map<Integer, Long> longMap = Arrays.stream(mapStrings)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(longMap);

        // 병렬 스트림
        mapStrings = new String[]{"Python", "is", "awful", "lame", "not", "good"};
        long res = Arrays.stream(mapStrings)
                .parallel()
                .map(String::length)
                .count();
        System.out.println(res);

        Stream<String> parallelStream = list.parallelStream();
        parallelStream.map(String::length)
                .peek(s -> System.out.println("A:" + s))
                .filter(v -> v > 3)
                .peek(s -> System.out.println("B: " + s))
                .forEach(System.out::println);
    }
}
