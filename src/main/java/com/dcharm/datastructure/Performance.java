package com.dcharm.datastructure;

/**
 * Created by wangqiang on 2015/8/19.
 */
public class Performance {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        for(int i = 0; i < 100000000; i++) {
            mathOp();
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    private static void bitOp() {
        int x = 1024;
        int y = x >> 6;
    }

    private static void mathOp() {
        int x = 1024;
        int y = 1024 / 48;
    }

}
