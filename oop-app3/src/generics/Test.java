package generics;

public class Test {
    public static void main(String[] args) {
        System.out.println(test("safka"));
    }
    public static <T> T test(T t){
        return t;
    }
}
