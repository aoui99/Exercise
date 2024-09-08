package enum_test;

public class Test {
    public static void main(String[] args) {
        A a = A.X;
        System.out.println(a.ordinal());

        B x = B.X;
        x.go();
    }
}
