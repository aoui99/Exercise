package inner_class3;
/**
 * 1.匿名内部类本质就是一个子类，并会立即创建出一个子类对象
 * 2.可以更方便的创建出一个子类对象
 * 3.匿名内部类通常作为一个参数传输给方法
 */
public class Test2 {
    public static void main(String[] args) {
//        Swimming s1 = new Swimming(){
//            @Override
//            public void swimming() {
//                System.out.println("狗🏊‍飞快~~~");
//            }
//        };
        int b = 10;
        Swimming s = a -> a * 2;
        System.out.println(s.swimming(10));
    }

    public static void go(Swimming s){
        System.out.println("开始------------");
        s.swimming(10);
    }
}

interface Swimming{
    int swimming(int a);
}