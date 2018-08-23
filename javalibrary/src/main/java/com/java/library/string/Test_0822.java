package com.java.library.string;

/**
 * Created by fcl on 18.8.23
 * 1.翻转字符串（首尾互换），但是单词顺序不变。如"hello world" -->"world hello"
 * 思路：（1）整体翻转字符串；（2）二次翻转单词（无空格的串）
 */

public class Test_0822 {

    /**
     * 第一题
     */
    public static String reverse_v1_string(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        char[] chars = string.toCharArray();
        //1.整体翻转
        char[] newChars = reverseChar(chars, 0, chars.length - 1);
        System.out.print(new String(newChars) + "\n");

        //2.翻转单词串
        //end是前面的指针，start是后面的指针
        int start = 0, end = 0;
        while (start < newChars.length) {
            if (newChars[start] == ' ') {
                //跳过
                start++;
                end++;
            } else if (end == newChars.length || newChars[end] == ' ') {
                //找到单词串（第一个指针到空格或者末尾），二次翻转
                newChars = reverseChar(newChars, start, end - 1);
                start = end++;
            } else {
                end++;
            }
        }
        return new String(newChars);
    }

    /**
     * 翻转字符串
     */
    private static char[] reverseChar(char[] chars, int start, int end) {
        if (chars == null || chars.length == 0) {
            return chars;
        }
        //首尾互换
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return chars;
    }
}
