package io.dsub.day21;

import java.io.IOException;
import java.net.MalformedURLException;

public interface Http {
    String get(String targetUrl) throws IOException;

}
