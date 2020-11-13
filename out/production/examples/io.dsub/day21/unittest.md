# Unit Test

- 단위 테스트라고도 부르며, 최소 단위의 테스트를 말한다.
- 최소 단위: 메소드 단위 (객체 단위)
  - 메소드는 객체의 속성을 변화시키는 '부작용(Side-effect)'을 가지고 있기 때문이다.
    - 여기서 말하는 부작용은 디자인에서의 단점 등을 이야기 하는 것 이 아니다
    - Pure function 에 해당해야만 메서드인 것 은 아니기 때문이다.
  - 환경 셋업, 환경 정리를 같이 해 주어야 한다.

- 통합 테스트 (Integration test)
  - 전체 시스템을 테스트하는 것 으로 근본적으로 여러 단위 테스트들이 모인 집합의 개념이다.
  - 이번 lecture 에서는 자세히 다루지 않을 예정이다.

```java
class ScoreCollection {
    public static void main(String[] args) {
        ScoreCollection collection = new ScoreCollection();
        
        // may name it as shouldReturnProperArithmeticMean(){...}
        collection.add(() -> 5);
        collection.add(() -> 7);
        System.out.println(collection.arithmeticMean());
        
        // test 1, 2의 과정을 prune 하지 않았으므로 문제가 생길 수 있다.
        // collection = new ScoreCollection();
        // 이렇게 초기화 하는 것 도 좋지만, 더 시스템적으로 정돈된 방식을 쓸 필요가 있다.
        
        // may name it as shouldReturnProperArithmeticMeanTwo(){...}
        collection.add(() -> 10);
        collection.add(() -> 20);
        System.out.println(collection.arithmeticMean());
    }
}
```

###  기존의 임시방편적 테스트

- 문제점? - 여러가지를 테스트할 때 Side-effect 를 피할 수 없다.
  - 안정적인 테스트가 불가능하다 (순서를 탄다)
  - 성공적인지에 대한 정확한 결과 분석 및 정리가 어렵다 (hard to track)
  - Production code, Test code 가 섞이게 된다.
  - Production code 패키지에 Test code 가 같이 들어가버린다.

### AAA (Triple - A)

| title   | mean                         | such as                       |
|:--------|:-----------------------------|:------------------------------|
| Arrange | 시스템이 적절한 상태에 있는지 확인한다. | 객체 생성, 객체와의 소통, API 호출 등 |
| Act     | 실제 테스트 코드를 실행             | 테스트하고자 하는 코드의 실질적인 실행  |
| Assert  | 테스트의 결과가 올바른지를 확인한다.   | assertThat(...)               |
| After   | 테스트에 의해 일어난 부작용을 처리     | clean up code...              |


### F.I.R.S.T
- Fast
  - 전형적인 Java 시스템의 테스트 케이스는 수천 단위
  - 평균 200ms가 걸리는 경우 5000개를 수행하는 데에 16분 소요
    - 우리가 코드를 1번 수정할 대 마다 16분의 테스트를 수행해야 함
    - 메서드에 테스트용 우회 코드를 넣거나 Stub 객체를 활용한다.
- Isolated
  - 테스트는 순서와 시간에 영향을 받지 않아야 함
  - 고립되지 않은 테스트는 실패 원인을 찾기 어렵게 만든다.
  - 다른 테스트로부터의 독립성에 대해서 이야기한다.
- Repeatable
  - 테스트를 반복하면 결과가 같아야 한다.
  - 테스트 코드 자체만으로 그 내용을 설명할 수 있어야 한다
    - 외부 환경으로부터 독립되어야 한다.
    - 코드 로직에 의해 결정되는 부분들이 지정된 조건에서 반복적으로 같은 결과를 도출해야 한다.
- Self-validating
  - 테스트는 반드시 기대하는 바를 단언해야 한다.
    - main 메서드를 통한 테스트 등은 최악의 테스트
  - 테스트는 스스로 검증하며, 테스트를 준비하는 것도 스스로 한다 (Arrange, Assert)
  - Continuous Integration (CI) 도구를 활용하기 위해 이것이 꼭 이루어져야 함
    - 코드가 통합될 때 마다 자동으로 모든 테스트를 수행하고 상태를 점검하는 프레임워크
- Timely
  - 변화하는 코드는 테스트 코드를 항상, 꾸준히 작성해야 한다.
  - 리뷰 시스템을 통해서, 혹은 CI 를 활용해서 테스트 코드 작성을 강제하기도 한다.
    - Peer Pressure
  - 큰 결함 없이 기존의 잘 동작하는(변경 예정이 없는) 코드 보다는, 말썽을 일으키고, 계속해서
    변하고 있는 동적인 코드에 대한 테스트를 먼저 작성한다.

#### Example

##### Class Example
```java
public class WebParser {
    private Http http;

    // Dependency injection
    // 테스트에 의해 수정했으나, 이로 인해 더 좋은 코드가 되었다고 볼 수 있다.
    public WebParser(Http http) {
        this.http = http;
    }

    public int countImageFromWebPage(String stringUrl) throws IOException {
        String text = this.http.get(stringUrl);

        Pattern pattern = Pattern.compile("(\\w+.(png|jpg|gif))");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
```

##### Test example
```java
public class WebParserTest {

    private WebParser webParser;

    // 아래와 같은 테스트의 문제점
    // @Test
    // public void countImageFromGoogleDotCom() throws IOException {
    //     int actualResult = webParser.countImageFromWebPage("https://www.google.com");
    //     assertThat(actualResult, equalTo(5));
    // }
    // 1. Fast에 대응하지 않는다. 느리다. 인터넷 연결이 순간 안될수도 있다.
    // 2. 웹페이지 내용이 변할 수 있다.

    @Before
    public void setUpUsingPageWithThreeImages() {

        // DI 를 이용해 Http 객체의 Stub 을 구현하여 넣어준다.
        // 기존에는 WebParser 가 내부적으로 Http 객체를 가지고 있었다.
        // 하지만 이제는 외부적으로 주입하기 때문에 더 좋은 코드가 된다.
        webParser = new WebParser((targetUrl) -> "<html><meta content=a.png> <meta content=b.gif> <meta content=alo.jpg</html>");
    }

    @Test
    public void countImageFromThreeImagesPageStcu() throws IOException {
        int actualResult = webParser.countImageFromWebPage("https://google.com");
        assertThat(actualResult, is(equalTo(3)));
    }
}
```

### TDD

- TDD, 테스트 주도 개발 (Test-Driven Development)
  - '실패하는' 테스트 케이스를 먼저 작성하고 그것을 통과시키는 방향으로 코드를 구현하는 방식
  - 테스트 케이스 작성 -> 코드 구현 -> (Commit) -> (Refactoring) -> 테스트 케이스 작성.. 을 빠르게 반복한다.
    - 1~2분 간격으로 매우 빠른 호흡으로 진행
    - 테스트 케이스 위주의 작성으로 코드의 질에 대해서 반드시 보장하지는 않는다.
  - 도메인 지식이 없어도 테스트 작성이 가능하다는 점을 부각한 방법론
