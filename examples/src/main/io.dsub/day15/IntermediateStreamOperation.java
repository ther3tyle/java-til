package io.dsub.day15;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

// Intermediate Operation
// 중간 처리 메소드
public class IntermediateStreamOperation {
    public static void main(String[] args) {
        Random rand = new Random();
        LongStream longStream = rand.longs(100);
        System.out.println(longStream.count() + "\n");

        Stream<String> stringStream = Stream.of("Java", "is", "fun");
        // distinct(): 중복된 요소를 삭제한다.
        stringStream.distinct().forEach(System.out::println);


        stringStream = Stream.of("Java", "is", "fun");
        System.out.println("\nfiltered");
        // filter(): Predicate 계열을 받아 true 인 요소만 남긴다.
        stringStream.filter(s -> s.length() >= 3)
                .forEach(System.out::println);

        stringStream = Stream.of("Java", "is", "fun");
        System.out.println("\nskipped");
        // skip(): 스트림의 최초 n 개를 생략한다.
        stringStream.skip(2).forEach(System.out::println);


        stringStream = Stream.of("Java", "is", "fun");
        System.out.println("\nlimited");
        // limit(): 스트림의 최대 요소 개수를 maxSize로 제한한다.
        stringStream.limit(2).forEach(System.out::println);

        stringStream = Stream.of("java", "is", "fun");
        // sorted(): ASCENDING ORDER
        // comparable 인터페이스의 compareTo 메소드로 정렬
        System.out.println("\nsorted");
        stringStream.sorted().forEach(System.out::println);

        stringStream = Stream.of("java", "is", "fun");
        System.out.println("\nsorted");
        // sort on the fly (-1, 0 ,1 as compareTo)
        stringStream.sorted((o1, o2) -> o1.length() - o2.length()).forEach(System.out::println);


        stringStream = Stream.of("java", "is", "fun");
        System.out.println("\nmapped with String::length");
        // Function 인터페이스를 사용해 스트림의 각 요소를 매핑한다.
        // 매핑 (Mapping)
        Stream<Integer> stream_ = stringStream.map(String::length);
        stream_.forEach(System.out::println);

        // PStream(P:primitive)에는 Function 과 같은 자료형 변환이 불가능하다.
        // 따라서, operator 계열의 람다만 사용 가능하다.
        IntStream intStream = IntStream.of(5, 2, 3, 1, 16, 4, 25, 53);
        IntStream intStream1 = intStream.map(value -> value * 10);
        System.out.println("\nPrimitive Stream");
        intStream1.forEach(System.out::println);


        // flatMap 계열 mapping
        // 말그대로 주어진 데이터를 flat 하게 다룬다.
        List<String> list = Arrays.asList("java", "backend", "best", "course\n");
        System.out.println("\nflatMapped");
        list.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .map(s -> s + " ")
                .forEach(System.out::print);

        // 조회 (Peek) - 중간 결과를 출력해볼 수 있음 (디버깅 가능)
        // peek() -> Consumer 계열을 람다식 입력으로 받아 입력 요소를 소비
        // peek()는 입력받은 스트림과 동일한 스트림을 다시 출력한다.
        list = Arrays.asList("java", "backend", "best", "course");
        long size = list.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .peek(s -> System.out.println("flatMap(): " + s))
                .distinct()
                .peek(s -> System.out.println("distinct(): " + s))
                .count();
        System.out.println(size);
    }
}
