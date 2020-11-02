package io.dsub.day18;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) throws FileNotFoundException {
        // 객체 직렬화를 위한 인터페이스 - Serializable
        // Heap 내용의 멤버 변수 등을 참조하여 어떤 데이터인지 확인할 수 있으므로
        // 읽어온 노드를 통해 필요한 구간들에 대해 직렬화를 할 수 있다.
        // 이렇게 일렬로 만든 데이터를 다시 객체화 하는 것 을 Deserialize(역직렬화) 라고 한다.
        class Foo implements Serializable {
            // 객체의 클래스 버전 관리
            // 객체를 저장할 때, 불러올 때 같은지를 체크합니다
            // serialVersionUID 가 일치하지 않으면 실패합니다.
            // 즉 클래스 업데이트가 존재하는 경우에는 반드시 업데이트 해주어야 합니다.
            static final long serialVersionUID = 1L;

            public Foo(){}
            public Foo(String username, String userID, String passWord) {
                this.username = username;
                this.userID = userID;
                this.passWord = passWord;
            }

            String username;
            String userID;

            // Serialize 에 포함되지 않는다 (즉 저장 혹은 불러오기에서 제외한다)
            transient String passWord;

            @Override
            public String toString() {
                return String.format("username: %s userID: %s\n", this.username, this.userID);
            }
        }

        Foo foo = new Foo("James Bond", "007", "impact");

        // 주 스트림
        File dst = new File("/Volumes/Dev/Java/java-til/obj.data");

        // Object IO 사용
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dst));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(dst))) {
            out.writeObject(foo);
            Object read = in.readObject();
            if (read instanceof Foo) {
                Foo readFoo = (Foo)read;
                System.out.println(readFoo);
                dst.deleteOnExit();
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }

        // 부모 클래스는 Serializable 하지 않을 때
        // 자식 클래스를 Serializable 하게 구현하기
        class ParentFoo {
            int memVarOne;
            double memVarTwo;
        }

        class ChildFoo extends ParentFoo implements Serializable {
            int childMemVar;

            // 중요한 것 은 Read, Write 순서를 꼭 지켜줘야 한다는 것
            private void writeObject(ObjectOutputStream out) throws IOException {
                out.writeInt(memVarOne);
                out.writeDouble(memVarTwo);
                out.defaultWriteObject();
            }

            private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
                memVarOne = in.readInt();
                memVarTwo = in.readDouble();
                in.defaultReadObject();
            }

        }
    }
}
