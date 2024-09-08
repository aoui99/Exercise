package Leetcode;

import java.util.HashMap;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第
 * 一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class LC28 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(strStr("aabaabaaf", "aabaaf"));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for(int i = 0; i< haystack.length(); i++){
            while(j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)){
                j = next[j];
            }
            if(haystack.charAt(i) == needle.charAt(j + 1)){
                j++;
            }
            if(j == needle.length() - 1){
                return (i - needle.length()+1);
            }
        }
        return -1;
    }

    public static void getNext(int[] next, String s){
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++){
            while(j >=0 && s.charAt(i) != s.charAt(j+1)){
                j = next[j];
            }
            if(s.charAt(i) == s.charAt(j + 1)){
                j++;
            }
            next[i] = j;
        }
    }
}
