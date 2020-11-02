package io.dsub.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class HttpImpl implements Http {
    @Override
    public String get(String targetUrl) throws IOException {
        URL url = new URL(targetUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();
        System.out.println("RESPONSE CODE: " + responseCode);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            return in.lines().reduce((acc, curr) -> acc + curr).orElse("");
        }
    }
}
