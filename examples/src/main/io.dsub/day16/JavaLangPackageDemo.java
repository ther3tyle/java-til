package main.io.dsub.day16;

import java.util.Arrays;
import java.util.Scanner;

/**
 * java.lang pacakge
 * - Java 에서 가장 기본적이며 자주 사용되는 클래스를 모은 패키지
 * - 별도로 import 를 하지 않아도 사용이 가능한 기본중의 기본
 */
public class JavaLangPackageDemo {
    public static void main(String[] args) throws Exception {
        // Object 클래스
        // 모든 클래스의 조상 클래스로 클래스의 기본 기능을 제공한다.
        // 필요한 경우 Object 클래스에 구현된 메소드를 override 해서 사용한다 (i.e. equals)

        Object obj = new Object(); // class instance
        Class<?> objClass = obj.getClass();
        System.out.printf("class: %s name: %s\n", objClass.getTypeName(), objClass.getSimpleName());

        Object obj1 = new Object();
        System.out.println(obj.equals(obj1));

        String str1 = "ABC";
        String str2 = "CDF";
        String str3 = str1;
        String str4 = new String("ABC");

        // String 의 equals는 내용만 같아도 true를 반환한다.
        System.out.println("\nCompare by value(this.equals(String other))");
        for (String target : new String[]{str1, str2, str3, str4}) {
            System.out.printf("%s equals %s? %b\n", str1, target, str1.equals(target));
        }

        System.out.println("\nCompare by reference(==)");
        for (String target : new String[]{str1, str2, str3, str4}) {
            System.out.printf("%s equals %s? %b\n", str1, target, str1 == target);
        }

        // hashCode() Method
        // - 객체를 구분하기 위해서 사용하는 정수값(int)를 반환
        // - 각 객체마다 프로그램 내에서 유일하기 때문에 주소값처럼 사용 가능
        // - hashCode()는 native 이기 때문에 정의를 볼 수 없다.
        //      - native: C 혹은 C++ 등 외부 언어로 작성된 메소드
        // - hashCode()를 Override 할 때 제약사항
        //      - 한 객체의 hashCode()를 여러번 호출할 경우
        //        해당 객체의 equals()에서 사용하는 값이 변하지 않았다면
        //        hashCode()의 반환값은 동일해야 한다.
        //      - equals() 메소드가 같다고 판단한 두 객체의
        //        hashCode() 값은 항상 같아야 한다 (필수사항.)
        //      - equals() 메소드에서 다르다고 판단하는 두 객체는
        //        항상 hashCode() 값이 다를 필요는 없으나
        //        다르면 Hash 기반 자료구조의 성능이 향상된 (권고사항.)

        class Foo {
        }
        Foo foo = new Foo();
        System.out.println(foo.hashCode());
        // 일반적으로 Object 에 구현된 hashCode 를 그대로 쓰는 것이좋다 (JNI)

        // getClass() 클래스 정보를 담고 있는 Class 객체를 반환
        class Bar {
            public void methodA() {
                System.out.println("method A is called");
            }
        }

        // Class 클래스, Method 클래스의 활용.
        // Reflection API 를 이용한다.
        Bar bar = new Bar();
        Class<?> barClass = bar.getClass();
        System.out.println(barClass.getName());
        System.out.println(barClass.getDeclaredMethods().length);
        System.out.println(barClass.getDeclaredMethod("methodA").invoke(bar));

        // System 클래스
        // OS와 interact 하기 위한 클래스
        // 정적 변수, 메소드로만 구성된 클래스
        System.out.println(System.out); // PrintStream 객체
        System.out.println(System.err); // PrintStream 객체
        System.out.println(System.in); // InputStream 객체

        System.out.println("f"); // 표준 출력을 처리하기 위한 객체
        System.err.println("w"); // 오류를 (표준 출력 장치에) 출력하기 위한 객체
        Scanner scanner = new Scanner(System.in); // 표준 입력장치를 사용하기 위한 객체

        int[] ints = {1, 2, 3, 4};
        int[] ints1 = new int[10];
        System.arraycopy(ints, 0, ints1, 0, ints.length);
        System.out.println(Arrays.toString(ints));

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());

        // garbage collection
        System.gc();

        // print system env
        System.out.println(System.getenv());

        System.out.println(System.getProperties());
        System.out.println(System.getProperty("user.country")); // Locale Information
        System.out.println(System.getProperty("java.io.tmpdir")); // Locale Information
        System.out.println(System.getProperty("line.separator")); // Locale Information
        System.out.println(System.getProperty("user.home")); // Locale Information
        System.out.println(System.getProperty("file.separator")); // Locale Information
        
        // status 0 = normal
        // status 1 = something went wrong
        System.exit(0);
    }
}
