package io.dsub.day21;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
    private final List<Scorable> scoreList = new ArrayList<>();

    public void add(Scorable item) {
        scoreList.add(item);
    }

    public int arithmeticMean() {
        int total = scoreList.stream()
                .mapToInt(Scorable::getScore)
                .sum();
        return total / scoreList.size();
    }

    /**
     * 기존의 임시방편적 테스트
     *
     * - 문제점?
     *  - 여러가지를 테스트할 때 Side-effect 를 피할 수 없다.
     *  - 안정적인 테스트가 불가능하다 (순서를 탄다)
     *  - 성공적인지에 대한 정확한 결과 분석 및 정리가 어렵다 (hard to track)
     *  - Production code, Test code 가 섞이게 된다.
     *  - Production code 패키지에 Test code 가 같이 들어가버린다.
     */

    public static void main(String[] args) {
        ScoreCollection collection = new ScoreCollection();

        // shouldReturnProperArithmeticMean()
        collection.add(() -> 5);
        collection.add(() -> 7);
        System.out.println(collection.arithmeticMean());

        // test 1, 2의 과정을 prune 하지 않았으므로 문제가 생길 수 있다.
        // collection = new ScoreCollection();
        // 이렇게 초기화 하는 것 도 좋지만, 더 시스템적으로 정돈된 방식을 쓸 필요가 있다.

        // shouldReturnProperArithmeticMeanTwo()
        collection.add(() -> 10);
        collection.add(() -> 20);
        System.out.println(collection.arithmeticMean());
    }
}
