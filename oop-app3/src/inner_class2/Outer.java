package inner_class2;


public class Outer {
    private int age;
    public static String schoolName;

    /**
     * 有static修饰的内部类；
     * 外部类名.内部类名 对象名 = new 外部类.内部类(...)；
     * 可以直接访问外部类的静态成员，
     * 不能直接访问外部类的实例成员。
     */
    public static class Inner{
        private String name;
        public static int a;
        public void test(){

            System.out.println(schoolName);
//            System.out.println(age);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void test2(){

    }
}
