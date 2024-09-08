package interfaces2;

public class Test {
    public static void main(String[] args) {
        Singer s = new A();
        Driver d = new B();

    }
}

class B implements Driver{

    @Override
    public void drive() {

    }
}

class A extends Student implements Driver, Singer{

    @Override
    public void drive() {

    }

    @Override
    public void sing() {

    }
}

class Student{

}

interface Driver{
    void drive();
}

interface Singer{
    void sing();
}
