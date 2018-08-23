package com.java.library;


import com.java.library.string.Test_0822;

/**
 * Created by fcl on 18.8.23
 * desc:  main()函数入口
 */

public class TestMain {

    public static void main(String[] args) {
//        System.out.print(Test_0822.reverse_v1_string(" wwww google  com"));
        try {
            System.out.print(Test_0822.reverse_v2_string("  wwww  google  com "));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
