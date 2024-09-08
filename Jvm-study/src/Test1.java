public class Test1 {
    public static final int a = 1;
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Test1.class.getClassLoader();
        Class<?> test2 = classLoader.loadClass("Test2");
        System.out.println(test2.getClassLoader());
    }
}