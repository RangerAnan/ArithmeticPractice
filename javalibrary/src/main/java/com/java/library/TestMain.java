package com.java.library;


import com.java.library.array.Test_0824;
import com.java.library.string.Test_0822;

/**
 * Created by fcl on 18.8.23
 * desc:  main()函数入口
 */

public class TestMain {

    public static void main(String[] args) {
        try {
//        System.out.print(Test_0822.reverse_v1_string(" wwww google  com"));
//            System.out.print(Test_0822.reverse_v2_string("  wwww  google  com "));

            Integer[] array = {0, 3, 1, 2, 8, 6, 7};
//            Test_0824.order_v1(array);
            Test_0824.order_v2(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
