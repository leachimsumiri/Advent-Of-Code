package com.asd;

import java.util.List;

public class Day1 {
    public static void main(String[] args) {
        int res = day1();
        System.out.println(res);
    }

    public static Integer day1(){
        List<Integer> intList = TestUtils.readFileIntoListInteger("com/asd/resources/day1.txt");
        for(int number : intList){
            for(int number2 : intList){
                for(int number3 : intList) {
                    if (number + number2 + number3 == 2020) {
                        return number * number2 * number3;
                    }
                }
            }
        }
        return null;
    }
}
