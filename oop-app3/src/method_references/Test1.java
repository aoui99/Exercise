package method_references;

import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student(23, "蜘蛛精", 169.5);
        students[1] = new Student(26, "紫霞", 163.8);
        students[2] = new Student(26, "紫霞", 163.8);
        students[3] = new Student(24, "至尊宝", 167.5);

        //Arrays.sort(students, (o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight()));
        //Arrays.sort(students, CompareByData::compileByAge);
        CompareByData compare = new CompareByData();
        Arrays.sort(students, compare::compareByAgeDesc);

        System.out.println(Arrays.toString(students));
    }

}