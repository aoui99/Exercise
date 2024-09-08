package innerclass;

public class Outer {
    private int age = 99;
    public static String a;

    public class Inner{
        private String name;
        /*Jdk16之后可以声明静态变量*/
        public static String schoolName;
        private int age = 88;

        public void test(){
//            System.out.println(age);
//            System.out.println(a);
            int age = 66;
            System.out.println(age);
            System.out.println(this.age);
            System.out.println(Outer.this.age);

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getSchoolName() {
            return schoolName;
        }

        public static void setSchoolName(String schoolName) {
            Inner.schoolName = schoolName;
        }
    }

    public void test2(){
        System.out.println(age);
        System.out.println(a);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
