//package edu.bupt.sice.young;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MorseCodeSkel {
    private static final String[] symbols = new String[]{
            "-----", ".----", "..---", "...--", "....-", // 0-4
            ".....", "-....", "--...", "---..", "----.", // 5-9
            ".-", "-...", "-.-.", "-..", ".", "..-.",    // A-F
            "--.", "....", "..", ".---", "-.-", ".-..",  // G-L
            "--", "-.", "---", ".--.", "--.-", ".-.",    // M-R
            "...", "-", "..-", "...-", ".--", "-..-",    // S-X
            "-.--", "--.."};                            // Y Z
    private static final String[] letters = new String[]{
            "0","1","2","3","4",
            "5","6","7","8","9",
            "A","B","C","D","E","F",
            "G","H","I","J","K","L",
            "M","N","O","P","Q","R",
            "S","T","U","V","W","X",
            "Y","Z"};

    public static String letter2morse(String input) {
        String morse = new String("");
        if(input.replace("  ", " ") != input){
            String[] split = input.split("  ");
            for(int i=0;i< split.length;i++){
                String word = split[i];

                if(word.replace(" "," ")!= word){
                    String[] split2 = word.split(" ");
                    for (int m=0;m<split2.length;m++){
                        String letter = split2[m];
                        for(int k=0;k< letters.length;k++){
                            if (letters[k].equals(letter)){
                                morse = morse+ symbols[k];
                            }
                        }
                        morse = morse + " ";
                    }
                }else{
                    String[] split1 = word.split(" ");
                    for(int j=0;j< split1.length;j++){
                        String letter = split1[j];
                        for(int k=0;k< letters.length;k++){
                            if (letters[k].equals(letter)){
                                morse = morse + symbols[k];
                            }
                        }
                    }
                }

                if (i!= split.length){
                    morse = morse + "     ";
                }
            }
            return morse;
        };

        if(input.replace("   ", " ") != input){
            String[] split = input.split("   ");
            for(int i=0;i< split.length;i++){
                String word = split[i];
                String[] split1 = word.split(" ");
                for(int j=0;j< split1.length;j++){
                    String letter = split1[j];
                    for(int k=0;k< symbols.length;k++){
                        if (letters[k].equals(letter)){
                            morse = morse + symbols[k];
                        }
                    }
                }
                if (i != split.length){
                    morse = morse + " ";
                }
            }
        }else{
            String[] split1 = input.split(" ");
            for(int j=0;j< split1.length;j++){
                String letter = split1[j];
                for(int k=0;k< symbols.length;k++){
                    if (letters[k].equals(letter)){
                        morse = morse + symbols[k];
                    }
                }
            }
        }
        return morse;
    }

    public static String morse2letter(String input) {
        String text = new String("");
        if(input.replace("     ", " ") != input){
            String[] split = input.split("     ");
            for(int i=0;i< split.length;i++){
               String word = split[i];

               if(word.replace("   "," ")!= word){
                   String[] split2 = word.split("   ");
                   for (int m=0;m<split2.length;m++){
                       String letter = split2[m];
                       for(int k=0;k< symbols.length;k++){
                           if (symbols[k].equals(letter)){
                               text = text + letters[k];
                           }
                       }
                       text = text + " ";
                   }
               }else{
                   String[] split1 = word.split(" ");
                   for(int j=0;j< split1.length;j++){
                       String letter = split1[j];
                       for(int k=0;k< symbols.length;k++){
                           if (symbols[k].equals(letter)){
                               text = text + letters[k];
                           }
                       }
                   }
               }

               if (i!= split.length){
                   text = text + "  ";
               }
            }
            return text;
        };

        if(input.replace("   ", " ") != input){
            String[] split = input.split("   ");
            for(int i=0;i< split.length;i++){
                String word = split[i];
                String[] split1 = word.split(" ");
                for(int j=0;j< split1.length;j++){
                    String letter = split1[j];
                    for(int k=0;k< symbols.length;k++){
                        if (symbols[k].equals(letter)){
                            text = text + letters[k];
                        }
                    }
                }
                if (i != split.length){
                    text = text + " ";
                }
            }
        }else{
            String[] split1 = input.split(" ");
            for(int j=0;j< split1.length;j++){
                String letter = split1[j];
                for(int k=0;k< symbols.length;k++){
                    if (symbols[k].equals(letter)){
                        text = text + letters[k];
                    }
                }
            }
        }
        return text;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File morse = new File("morse.txt");
        Scanner scanner1 = new Scanner(morse);
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            System.out.println(morse2letter(line));
        }
        scanner1.close();

        File text = new File("text.txt");
        Scanner scanner2 = new Scanner(text);
        while (scanner2.hasNextLine()) {
            String line = scanner2.nextLine();
            System.out.println(letter2morse(line));
        }
        scanner2.close();
    }
}
