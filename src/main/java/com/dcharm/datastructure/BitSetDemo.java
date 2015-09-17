package com.dcharm.datastructure;

import java.util.BitSet;

/**
 * Created by wangqiang on 2015/8/18.
 */
public class BitSetDemo {
    private final static int ADDRESS_BITS_PER_WORD = 6;
    private final static int BITS_PER_WORD = 1 << ADDRESS_BITS_PER_WORD;
    private final static int BIT_INDEX_MASK = BITS_PER_WORD - 1;

    public static void main(String[] args) {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);
        bits1.set(3);
        bits1.set(5);
        bits2.set(5);
        bits2.set(6);
        bits1.or(bits2);
        System.out.println(bits1);
    }

}
