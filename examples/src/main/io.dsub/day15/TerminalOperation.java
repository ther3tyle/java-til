package main.io.dsub.day15;

import java.util.stream.IntStream;
import java.util.stream.Stream;

// Terminal Operation
// 최종 처리 메소드 - 스트림을 반환하지는 않으나 void, 혹은 이외를 리턴할 수 있다.
public class TerminalOperation {

    public static void main(String[] args) {
        // Matching
        // allMatch(), anyMatch(), noneMatch()
        // Predicate 계열 람다식을 입력 받아,
        //  allMatch(Predicate<T> predicate): 모든 요소가 true 일 경우 true 를 리턴한다.
        //  anyMatch(Predicate<T> predicate): 하나라도 요소가 true 일 경우 true 를 리턴한다.
        //  noneMatch(Predicate<T> predicate): 요소중 하나라고 false 가 있으면 true 를 리턴한다.
        Stream<String> stream = Stream.of("abc", "cde", "efg");
        System.out.println(stream.allMatch(s -> s.equals("abc")));

        stream = Stream.of("abc", "cde", "efg");
        System.out.println(stream.anyMatch(s -> s.equals("abc")));

        stream = Stream.of("abc", "cde", "efg");
        System.out.println(stream.noneMatch(s -> s.equals("abce")));

        // 집계 (통계)
        // 기본형 스트림 (Int, Long, Double) - count(), sum(), average(), min(), max()
        // Stream<T> 타입 Stream - min, max 는 Comparator 구현 필요

        // Reduce - 사용자 정의 집계 메소드
        int res = IntStream.range(0, 10) // 0 ~ 9 fill
                .reduce(0, (acc, curr) -> acc + curr);
        System.out.println(res);

        res = IntStream.range(0, 10) // 0 ~ 9 fill
                .reduce(10, (acc, curr) -> acc > curr ? curr : acc);
        System.out.println(res);

        // 반복 - 소비
        // forEach() -> Consumer 계열의 람다식을 입력받아 각 요소를 소비
        // forEach()는 void 출력

        // 수집 - Collection 으로 변환하는 collect() 메소드
        // Stream API 는 JCF -> Stream -> Process -> Collect(Output, Value, Collection)

    }
}
