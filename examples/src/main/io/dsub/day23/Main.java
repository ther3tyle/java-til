package io.dsub.day23;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

/**
 * nio (New Input / Output)
 * nonblocking-io (x)
 * <p>
 * io stream: 입력 노드/출력 노드가 구분
 * nio channel: 입/출력 모두 처리 가능
 * <p>
 * - 채널을 이용해서 입/출력 모두 처리(동시에는 안됨)
 * - 기본적으로 버퍼를 사용
 * - nio는 non-blocking을 지원 (비동기식)
 * - 읽기 / 쓰기를 시켜놓고 다른 작업 진행 가능 (멀티스레드)
 * <p>
 * direct buffer
 * - OS 에 요청해서 메모리를 받아 사용한다.
 * > 사용가능한 크기가 큼(JVM 제한 X), 생성 속도는 느림(OS 통신 필요), 입출력 성능이 좋다
 * > ByteBuffer 만 생성 가능하다. nio 와 상성이 좋다 (nio 도 ByteBuffer 를 사용한다)
 * <p>
 * non-direct buffer
 * - JVM 의 Heap 메모리를 사용한다.
 * > 사용 크기가 작음 (JVM Heap 메모리에 의해 제한됨), 생성 속도가 빠름, 입출력 성능이 direct buffer 에 비해 떨어짐
 */
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
//        Path path = Paths.get("1.txt");
//        Path path1 = Paths.get("Users", "bae", "1.txt"); // directory
//        Path path2 = Paths.get(new URI("file://Users/bae/1.txt"));

        // Paths -> get 정적 메소드
        // Files -> createFile, createDirectory, delete, copy...
        // Files.createDirectories(path2);

        // 버퍼에는 두가지 종류가 있다.
        // 1. direct buffer
        // OS에 직접 요청해서 메모리를 받아오는 버퍼
        // 2. non-direct buffer
        // JVM Heap 메모리를 그대로 사용한다.

        ByteBuffer direct = ByteBuffer.allocateDirect(1024); // direct buffer
        ByteBuffer nonDirect = ByteBuffer.allocate(1024); // non-direct buffer

        CharBuffer cBuf = CharBuffer.allocate(1024); // non-direct buffer. does not have allocateDirect static method
        IntBuffer iBuf = IntBuffer.allocate(1024); // same as above (no allocateDirect static method)

        CharBuffer directCharBuf = direct.asCharBuffer(); // we can change it like this.

        Path src = Paths.get("1.txt");
        Path dst = Paths.get("2.txt");

        long before = System.nanoTime();
        try (FileChannel channel1 = FileChannel.open(src, StandardOpenOption.READ);
             FileChannel channel2 = FileChannel.open(dst, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            int read = -1;
            ByteBuffer readBuffer = ByteBuffer.allocate((int) channel1.size());
            read = channel1.read(readBuffer);
            if (read == -1) {
                throw new IOException();
            }

            readBuffer.flip();
            channel2.write(readBuffer);
            readBuffer.clear();

            // buffer 사용법
            // capacity, limit, position, mark
            // 0 <= mark <= position <= limit <= capacity
            // clear 는 limit 헤더를 capacity 로, position 을 초기 위치로 돌려놓게 된다.
            // 버퍼 컨트롤 자체를 flip() 하게 되면 limit 포인터가 현재 포지션이 되고 포지션은 0으로 돌아가게 된다.
            // clear() 메서드 호출하게 되면 position = 0, limit = capacity
        }
        long after = System.nanoTime();

        System.out.println(after - before);

        // 버퍼가 아주 작은 경우...
        src = Paths.get("1.txt");
        dst = Paths.get("3.txt");
        before = System.nanoTime();
        try (FileChannel channel1 = FileChannel.open(src, StandardOpenOption.READ);
             FileChannel channel2 = FileChannel.open(dst, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            int read = -1;
            ByteBuffer readBuffer = ByteBuffer.allocate(8);

            // 여러번 읽기 위한 부분
            while((read = channel1.read(readBuffer)) != - 1) {
                readBuffer.flip();
                channel2.write(readBuffer);
                readBuffer.clear();
            }
        }
        after = System.nanoTime();
        System.out.println(after - before);

        src = Paths.get("1.txt");
        dst = Paths.get("4.txt");
        before = System.nanoTime();
        try (FileChannel channel1 = FileChannel.open(src, StandardOpenOption.READ);
             FileChannel channel2 = FileChannel.open(dst, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer readBuffer = ByteBuffer.allocateDirect(512);
            while((channel1.read(readBuffer)) != - 1) {
                readBuffer.flip();
                channel2.write(readBuffer);
                readBuffer.clear();
            }
        }
        after = System.nanoTime();
        System.out.println(after - before);
    }
}
