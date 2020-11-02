package io.dsub.day18;

import java.util.*;

/**
 * Java Collections Framework(JCF)
 *
 * - java.util 에 속한 일련의 클래스, 자료구조를 담당
 *  - 자료구조: 자료의 집합, 또는 그 집합의 동작을 정의하는 수학적 모델
 * - 제네릭 클래스로 되어 있어, 다양한 객체를 요소(Element)로 담을 수 있다.
 *  - 자료구조를 구성하는 하나하나의 자료
 *
 *
 */
public class JCF {
    public static void main(String[] args) {
        // List Interface
        // 순서가 있는 데이터의 집합으로 데이터 중복 허용
        // 데이터의 순서(index)가 유일한 데이터의 구분자(identifier)로 사용
        List<String> stringList1 = new ArrayList<>(); // 가장 많이 쓰이는 배열 기반의 리스트
        List<String> stringList2 = new LinkedList<>(); // 노드를 기반으로 한 리스트
        List<String> stringList3 = new Vector<>(); // Synchronized 남발로 인해 사용을 자제하게 된다. (프로토타이핑에는 쓰임)
        List<String> stringList4 = new Stack<>(); // Stack 자료 구현 -> 자료 구조의 제한적인 인터페이스


        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            intList.add(i, i+1);
        }

        System.out.println(intList);
        System.out.println(intList.size());

        intList.add(2, 678493);
        System.out.println(intList);
        System.out.println(intList.size());

        List<Integer> intList2 = new LinkedList<>();
        for (int i = 5; i < 10; i++) {
            intList2.add(i);
        }

        // 입력된 컬렉션 내용 전체를 한번에 add 하는 메소드
        // index 를 입력받아 위치도 지정 가능하다.
        intList.addAll(0, intList2); // insert at front
        System.out.println(intList);
        System.out.println(intList.size());

        System.out.printf("index 3: %d\n", intList.get(3));
        System.out.printf("3 is in index of %d\n", intList.indexOf(3));

        intList.set(1, 100);
        System.out.println(intList);

        // inclusive, exclusive
        List<Integer> list3 = intList.subList(2, 5);
        System.out.println(list3);

        // iteration
        for (int i = 0; i < list3.size(); i++) {
            System.out.printf("%d ", list3.get(i));
        }
        System.out.println();

        // forEach
        for (int i : list3) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        // listIterator
        ListIterator<Integer> iter = list3.listIterator();
        while(iter.hasNext()) {
            System.out.printf("%d ", iter.next());
            if (!iter.hasNext()) {
                System.out.println();
            }
        }

        // Set Interface
        // - Collection Interface 상속
        // - 순서가 없는 데이터 {집합}을 다루는 인터페이스
        // - 중복되는 데이터를 효율적으로 제거하는데에 사용 가능
        // - 중복을 검사하는 수단 1.hashCode(), 2.equals()
        //  - hash 를 빠르게 계산해서 hash 만 비교
        //  - 그 다음에 판정이 안나면 equals()로 추가 비교
        Set<String> stringSet1 = new HashSet<>(); // 기본적인 집합
        class Foo {
            int x;
            int y;
            Foo(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return "Foo{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
            }
        }
        NavigableSet<Foo> fooSet = new TreeSet<>(Comparator.comparingInt(o -> o.x)); // 이진 탐색 트리
        fooSet.add(new Foo(1, 100));
        fooSet.add(new Foo(4, 50));
        fooSet.add(new Foo(0, 170));
        fooSet.add(new Foo(-2, 3300));

        System.out.println(fooSet.first());
        System.out.println(fooSet.last());
        System.out.println(fooSet.lower(new Foo(1, 500)));
        System.out.println(fooSet.floor(new Foo(1, 500)));
        System.out.println(fooSet.higher(new Foo(2, 500)));
        System.out.println(fooSet.ceiling(new Foo(1, 500)));

        System.out.println(fooSet.pollFirst());
        System.out.println(fooSet.pollFirst());
        System.out.println(fooSet.pollFirst());

        // Map 인터페이스
        // - Collection 인터페이스를 상속하지 않는다.
        // - Key, Value Pair
        // - Map.Entry<Key, Value>
        // - Key 는 중복될 수 없으며 Value 는 중복될 수 있다.
        // - Key 가 identifier 역할을 한다.

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new TreeMap<>();
        Map<String, Integer> map3 = new Hashtable<>(); // old impl. don't use it

        // Put 은 기존에 동일 키가 있었으면 기존 값을 반환, 없었으면 null
        System.out.println(map1.put("ABCDE", 5));
        System.out.println(map1.put("CDEF", 1023));
        System.out.println(map1.put("ABCDE", 1023)); // returns the original value

        System.out.println(map1.get("CDEF")); // query (질의)
        System.out.println(map1.getOrDefault("CDEFG", -1));

        // keySet & entrySet
        for (String key : map1.keySet()) {
            System.out.printf("%s ", key);
        }
        System.out.println();


        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }


        NavigableMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("a", 10);
        treeMap.put("g", 12);
        treeMap.put("z", 14);
        treeMap.put("z", 114);
        treeMap.put("c", 165);

        Properties prop = new Properties(); // extends Hashtable<String, String>
        prop = System.getProperties(); // System 의 properties 도 같은 데이터 구조에 해당한다.
    }
}
