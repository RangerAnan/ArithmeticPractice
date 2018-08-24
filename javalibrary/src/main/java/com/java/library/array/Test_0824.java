package com.java.library.array;

/**
 * Created by fcl on 18.8.24
 * 1.给定一个整数数组，请实现一个函数来调整数组中数字的顺序，使得所有奇数都位于偶数之前。
 * <p>
 * 2.基于第一题，使得数组中奇数与偶数顺序不变
 */

public class Test_0824 {


    /**
     * 第一题
     * 如：[1,3,2,6,7]  --> [1,3,7,2,4,6]
     * 一次循环搞定，所以时间复杂度O(n), 由于在原数组上操作，所以空间复杂度O(1)
     */
    public static Integer[] order_v1(Integer[] array) {
        //初始两个指针p1,p2，指向0
        //逐步移动一个指针p1，比较value1与value2（排序）
        //判断奇偶性:两个奇数，p1，p2都往前移动；两个偶数，p1向前移动；奇数在后，偶数在前，互换顺序；奇前偶后，p1向前移动
        int p1 = 1, p2 = 0;
        while (p2 < array.length) {
            //右数
            int value1 = array[p1] % 2;
            //左数
            int value2 = array[p2] % 2;

            if ((value1 == 0 && value2 == 0) || (value1 == 0 && value2 == 1)) {
                //偶数偶数；奇数偶数
                //p1右移，直到末尾，移动p2
                if (p1 == array.length - 1) {
                    p2++;
                } else {
                    p1++;
                }
            } else if (value1 == 1 && value2 == 1) {
                //奇数奇数
                if (p1 == array.length - 1) {
                    p2++;
                } else {
                    p1++;
                    p2++;
                }
            } else if (value1 == 1 && value2 == 0) {
                //左偶右奇
                int temp = array[p1];
                array[p1] = array[p2];
                array[p2] = temp;

                if (p1 == array.length - 1) {
                    p2++;
                } else {
                    p1++;
                    p2++;
                }
            }
        }
        for (Integer i : array) {
            System.out.print(i + "\n");
        }

        return array;
    }


    /**
     * 控制顺序
     */
    public static Integer[] order_v2(Integer[] array) {
        int p1 = 1, p2 = 0;

        while (p2 < array.length) {
            //右数
            int value1 = array[p1] % 2;
            //左数
            int value2 = array[p2] % 2;

            if ((value1 == 0 && value2 == 0) || (value1 == 0 && value2 == 1)) {
                //偶数偶数；奇数偶数
                //p1右移，直到末尾，移动p2
                if (p1 == array.length - 1) {
                    p2++;
                } else {
                    p1++;
                }
            } else if (value1 == 1 && value2 == 1) {
                //奇数奇数
                if (p1 == array.length - 1) {
                    p2++;
                } else {
                    p1++;
                    p2++;
                }
            } else if (value1 == 1 && value2 == 0) {
                //左偶右奇-互换
                int temp = array[p1];
                array[p1] = array[p2];
                array[p2] = temp;

                p2++;

                //p1->p2之间的偶数相邻互换
                int end = p2, start = p1;
                while (start > end) {
                    int temp2 = array[start];
                    array[start] = array[start - 1];
                    array[start - 1] = temp2;
                    start--;
                }

                //移动p1指针
                if (p1 != array.length - 1) {
                    p1++;
                }
            }
        }
        for (Integer i : array) {
            System.out.print(i + "\n");
        }
        return array;
    }

}
