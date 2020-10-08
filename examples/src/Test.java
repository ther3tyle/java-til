import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test {
    String value = "default value";

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Alpha");
        stream.filter(a -> a.startsWith("A")).peek(a -> System.out.println(a)).count();
    }
}
