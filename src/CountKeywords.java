import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountKeywords {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Java source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        if(file.exists()){
            System.out.println("The number of keywords in " + filename
                + " is " + countKeywords(file));
        }
        else{
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception{
        String[] keywordString = {
                "abstract", "assert", "boolean", "break",
                "byte", "case", "catch","char", "class",
                "const", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import",
                "instanceof", "int", "interface", "long",
                "native", "new", "package", "private", "protected",
                "public", "return", "short", "static", "strictfp",
                "super", "switch", "synchronized", "this", "throw",
                "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"
        };
        Set<String> keywordSet =
                new HashSet<>(Arrays.asList(keywordString));

        int count = 0;
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
            String line = input.nextLine();
            if (line.startsWith("//")) continue;
            String[] tokens = line.split("[\\s\\(\\)\\{\\}]");
            boolean note = false;
            for(int i=0; i<tokens.length; i++){
                String block = tokens[i];
                if(block.equals("\"")) note = !note;
                if(block.startsWith("\"")) note = !note;
                if(block.endsWith("\"")) note = !note;

                if(block.equals("/\u002A")) note = !note;
                if(block.equals("\u002A/")) note = !note;

                if(!note){
                    if(keywordSet.contains(block)) {
                        count++;
                        System.out.print(block + " ");
                    }
                }
            }
            /*if(keywordSet.contains(word)) {
                count++;
                System.out.print(word + " ");
            }   */
        }
        System.out.println();
        return count;
    }
}
