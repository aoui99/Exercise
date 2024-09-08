import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Collections;

public class Ch07Q35 {
    static int COUNT;

    public static void main(String[] args) throws FileNotFoundException {
        List<String> words = new LinkedList<String>();
        ArrayList<Integer> alphaList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(new File("src/words_alpha.txt"));
        Scanner scanner1 = new Scanner(System.in);
        String input;
        String word;
        String riddle;
        boolean conti;
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        scanner.close();
        Random rand = new Random();

        do {
            //初始化数值
            COUNT = 0;
            conti = true;
            word = words.get(rand.nextInt(words.size()));
            riddle = repeatString1("*", word.length());
            //循环判断输入字母是否在单词中
            while (conti) {
                System.out.printf("Enter a letter in word %s >", riddle);
                String alpha = scanner1.next();
                if (riddle.indexOf(alpha) != -1) {
                    System.out.printf("%s is already in the word", alpha);
                    System.out.println("");
                } else {
                    alphaList = guessLetter(word, alpha, riddle);
                    if (alphaList.isEmpty()) {
                        System.out.printf("%s is not in the word", alpha);
                        System.out.println("");
                    } else {
                        for (int i = 0; i < alphaList.size(); i++) {
                            riddle = riddle.substring(0, alphaList.get(i)) + alpha + riddle.substring(alphaList.get(i) + 1);
                        }
                    }
                    if (riddle.equals(word)) {
                        conti = false;
                    }
                }
            }
            System.out.printf("The word is %s.You missed %d time", word, COUNT);
            System.out.println("");

            System.out.println("Do you want to guess another word? Enter y or n>");
            input = scanner1.next();
        } while (input.equals("y"));
    }

    public static ArrayList<Integer> guessLetter(String word, String alpha, String riddle) {
        ArrayList<Integer> alphaList = new ArrayList<Integer>();
        for (int i = 0; i < word.length(); i++) {
            if (Character.toString(word.charAt(i)).equals(alpha)) {
                alphaList.add(i);
            }
        }
        if (alphaList.isEmpty()) {
            COUNT++;
        }
        return alphaList;
    }

    public static String repeatString1(String seed, int n) {
        return String.join("", Collections.nCopies(n, seed));
    }
}
