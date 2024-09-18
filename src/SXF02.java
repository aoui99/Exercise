public class SXF02 {
    public static void main(String[] args) {
        // 示例输入
        String s = "abcdafage";
        String[] words = {"a", "ab", "acd", "ace", "af", "aaf", "cdh"};

        // 计算并输出结果
        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSubsequence(s, word)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isSubsequence(String s, String word) {
        int indexS = 0, indexWord = 0;
        while (indexS < s.length() && indexWord < word.length()) {
            if (s.charAt(indexS) == word.charAt(indexWord)) {
                indexWord++;
            }
            indexS++;
        }
        return indexWord == word.length();
    }
}
