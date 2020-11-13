package io.dsub.day21;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WebParserTest {

    private WebParser webParser;

    // 아래와 같은 테스트의 문제점
    // 1. Fast에 대응하지 않는다. 느리다. 인터넷 연결이 순간 안될수도 있다.
    // 2. 웹페이지 내용이 변할 수 있다.
//    @Test
//    public void countImageFromGoogleDotCom() throws IOException {
//        int actualResult = webParser.countImageFromWebPage("https://www.google.com");
//        assertThat(actualResult, equalTo(5));
//    }

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