package main.io.dsub.day06;

/**
 * 3차원 벡터 클래스 구현하기
 *
 * 3차원 벡터를 클래스로 구현하시오.
 *
 * 속성
 * float타입의 x, y, z
 *
 * 생성자
 * Vector3D(float x, float y, float z)
 *
 * 메소드
 * - x, y, z에 대한 getter 및 setter
 * - add(): 벡터끼리의 덧셈, 실수와의 덧셈을 반환
 * - sub(): 벡터끼리의 뺄셈, 실수와의 뺄셈을 반환
 * - inner(): 두 벡터의 내적을 반환
 * - mul(): 실수와의 곱을 반환
 * - mag(): 벡터의 크기를 반환
 * - print(): 벡터의 내용을 "(%.3f, %.3f, %.3f)\n" 형식으로 콘솔에 출력
 */

public class Vector3D {
    private float x;
    private float y;
    private float z;

    public Vector3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D add(Vector3D vector) {
        return new Vector3D(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector3D sub(Vector3D vector) {
        return new Vector3D(x - vector.x, y - vector.y, z - vector.z);
    }

    public Vector3D inner(Vector3D vector) {
        float x, y, z;
        x = this.x * vector.x;
        y = this.y * vector.y;
        z = this.z * vector.z;
        return new Vector3D(x, y, z);
    }

    public Vector3D mul(float f) {
        return new Vector3D(f*x, f*y, f*z);
    }

    public float mag() {
        return (float)(Math.sqrt((x * x) + (y * y) + (z * z)));
    }

    public void print() {
        System.out.printf("%.3f %.3f %.3f\n", this.x, this.y, this.z);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}

class Vector3DTest {
    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(0.5f, 0.2f, 0.9f);
        Vector3D v2 = new Vector3D(0.8f, 0.1f, 1.3f);
//        v1.add(v2).print();
//        v2.sub(v1).print();
//        v1.add(0.2f).print();
//        v2.sub(0.05f).print();
//        v1.inner(v2).print();
//        v1.mult(1.2f).print();
//        System.out.println(v2.mag());
    }
}
