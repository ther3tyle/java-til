package io.dsub.day21;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
