package com.java.library.string;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by fcl on 18.8.23
 * 1.翻转字符串（首尾互换），但是单词顺序不变。如"hello world" -->"world hello"
 * 思路：（1）整体翻转字符串；（2）二次翻转单词（无空格的串）
 * <p>
 * 2.题一中得到的字符串用作一个url参数：去掉首尾空格，并将单词中间的每个空格替换成"%20"
 * 如：" com  google www" --> "com%20%20google%20www"
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


    /**
     * 第二题
     * notice:空格-->%20:原来一个字符换后，变成3个字符
     */
    public static String reverse_v2_string(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        //1.去掉首尾字符串
        String s = trim(string);
        System.out.print(s + "\n");
        char[] c = s.toCharArray();

        //2.每一个空格替换成%20
        //2.1 数组扩容:新增的长度在末尾
        int count = getSpaceCount(s);
        int newLen = s.length() + 2 * count;
        char[] chars = Arrays.copyOf(c, newLen);

        //2.2替换:从后往前移动，遇到空格替换
        //两个指针，一个指向len，一个指向newLen，依次将len的值赋给newLen
        int p1 = c.length - 1, p2 = newLen - 1;
        while (p1 > 0) {
            if (chars[p1] != ' ') {
                chars[p2] = chars[p1];
                p2--;
            } else {
                //p1指向空格
                chars[p2] = '0';
                chars[p2 - 1] = '2';
                chars[p2 - 2] = '%';
                p2 = p2 - 3;
            }
            p1--;
        }
        return new String(chars);
    }

    /**
     * 获取字符串之间的空格数
     */
    private static int getSpaceCount(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                count++;
            } else {
                continue;
            }
        }
        return count;
    }

    /**
     * 去掉字符串首尾空格
     */
    private static String trim(String string) {
        char[] chars = string.toCharArray();
        //两个指针向前移动，start非空就停止
        //count 是除末尾空格的长度
        int start = 0, count = chars.length;
        while (start < chars.length) {
            if (chars[start] == ' ') {
                start++;
            } else {
                break;
            }
        }

        while (start < count && chars[count - 1] == ' ') {
            count--;
        }
        System.out.print("\n start:" + start + ";count:" + count + ";length:" + chars.length + "\n");
        return new String(chars, start, count - start);
    }
}
