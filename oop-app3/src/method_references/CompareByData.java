package method_references;

public class CompareByData {
    public static int compileByAge(Student o1, Student o2){
        return o1.getAge()- o2.getAge();
    }
    public int compareByAgeDesc(Student o1, Student o2){
        return o2.getAge()- o1.getAge();
    }
}
