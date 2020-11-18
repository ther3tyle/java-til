package io.dsub.day09;


import io.dsub.day09.enums.Family;
import io.dsub.day09.interfaces.arithmetics.*;

public class Main {
    public static void main(String[] args) {

        // 다형성의 예(1)
        ArithmeticOperator op;
        op = new Multiply();
        System.out.println(op.operate(10, 20)); // prints 200

        op = new Add();
        System.out.println(op.operate(10, 20.0)); // prints 30.0

        // 다형성의 예(2)
        ArithmeticOperator [] ops;
        ops = new ArithmeticOperator[]{new Add(), new Subtract(), new Multiply(), new Divide()};
        for (ArithmeticOperator o : ops) {
            System.out.println(o.operate(10, 20.0));
        }


        // 다형성의 예(3)
        Calculator calculator;
        for (ArithmeticOperator operator : ops) {
            calculator = new Calculator(operator);
            System.out.println(calculator.operate(10, 20.0));
        }

        // 다형성의 예(4)
        Runner.run(new Multiply(), 1, 4);
        Runner.run(new Divide(), 3, 10.0);

        Family fam = Family.SON;
        System.out.println(fam.getKoreanWord());
        // 열거형 생성자와 멤버 변수 활용
        Family secondFam = Family.SON;
        fam.setKoreanWord("버린 자식");
        System.out.println(fam.getKoreanWord());
        System.out.println(Family.SON.getKoreanWord()); // singleton
    }
}
