import java.util.ArrayList;

public class Ch09Q11 {
    public static void main(String[] args) {
        Student[] students = new Student[15000];
        ArrayList<Integer> normal = new ArrayList<>();
        ArrayList<Integer> exception = new ArrayList<>();

        for (int i = 0; i < 15000; i++) {
            int score = (int) (Math.random() * 150) + 1;
            students[i] = new Student(score);
            try {
                isScoreValid(students[i]);
                normal.add(students[i].getScore());
            } catch (ScoreExceedsMaxValueException se) {
                System.out.println("分数大于100");
                exception.add(students[i].getScore());
            }
        }
        int sumN = 0;
        for (int i=0;i<normal.size();i++){
            System.out.println("");
            System.out.printf("正常分数：%s",normal.get(i));
            sumN += normal.get(i);
        }
        System.out.println("");
        System.out.printf("正常平均分数：%s",sumN/normal.size());

        int sumE = 0;
        for (int i=0;i<exception.size();i++){
            System.out.println("");
            System.out.printf("异常分数：%s",exception.get(i));
            sumE += exception.get(i);
        }
        System.out.println("");
        System.out.printf("异常平均分数：%s",sumE/exception.size());

    }

    public static void isScoreValid(Student s) throws ScoreExceedsMaxValueException {
        if (s.getScore() <= 100)
            System.out.println(s.getScore());
        else
            throw new ScoreExceedsMaxValueException(s.getScore());

    }

}


class Student {
    private int score;

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}


