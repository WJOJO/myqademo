package com.javon.myqademo.utils;

import java.util.*;

public class RandomUtils {

    /**
     * 取出20个随机数
     * @param max
     * @return
     */
    public static int[] getRandomQuestion(int max){
        List<Integer> list = new ArrayList<>();
        int[] result = new int[20];
        for (int i = 1; i <= max; i++) {
            list.add(i);
        }

        for (int i = 0; i < 20; i++) {
            int random = new Random().nextInt(list.size());
            result[i] = list.get(random);
            list.remove(random);
        }
        return result;
    }


}
