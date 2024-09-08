package inner_class3;

public class Test {
    public static void main(String[] args) {
        Animal a = new Animal(){
            @Override
            public void cry() {
                System.out.println("狗汪汪的叫~~~");
            }
        };
        a.cry();
    }
}

//class Cat extends Animal{
//
//    @Override
//    public void cry() {
//        System.out.println("猫喵喵的叫~~~");
//    }
//}
abstract class Animal{
    public abstract void cry();
}