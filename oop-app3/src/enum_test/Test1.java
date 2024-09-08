package enum_test;

public class Test1 {
    public static final int BOY = 0;
    public static final int GIRL = 1;
    public static void main(String[] args) {
        check(Constant.BOY);
    }
    public static void check(Constant sex){
        switch (sex){
            case BOY:
                System.out.println("男生");
                break;
            case GIRL:
                break;
            default:

        }
    }
}
