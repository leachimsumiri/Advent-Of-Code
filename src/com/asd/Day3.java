package com.asd;

import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        long res = day3();
        System.out.println(res);
    }

    public static long day3(){
        List<String> stringList = TestUtils.readFileIntoList("com/asd/resources/day3.txt");
        long total = 1;

        int firstPattern = getEncounteredTreesForPattern(stringList, 1, 1);
        total *= firstPattern;
        int secondPattern = getEncounteredTreesForPattern(stringList, 3, 1);
        total *= secondPattern;
        int thirdPattern = getEncounteredTreesForPattern(stringList, 5, 1);
        total *= thirdPattern;
        int forthPattern = getEncounteredTreesForPattern(stringList, 7, 1);
        total *= forthPattern;
        int fifthPattern = getEncounteredTreesForPattern(stringList, 1, 2);
        total *= fifthPattern;

        return total;
    }

    public static Integer getEncounteredTreesForPattern(List<String> stringList, int amountOfStepsRight, int amountOfStepsDown){
        int totalTrees = 0;
        int currentXCoord = 0;

        for(int i = 0; i < stringList.size(); i+=amountOfStepsDown){
            currentXCoord += amountOfStepsRight;

            if(i+amountOfStepsDown < stringList.size()){
                while(currentXCoord >= stringList.get(i+amountOfStepsDown).length()){
                    repeatLineToTheRight(stringList, i, amountOfStepsDown);
                }

                if(stringList.get(i+amountOfStepsDown).charAt(currentXCoord) == '#'){
                    totalTrees++;
                }
            }
        }

        return totalTrees;
    }

    public static void repeatLineToTheRight(List<String> stringList, int index, int amountOfStepsDown){
        stringList.set(index+amountOfStepsDown, stringList.get(index+amountOfStepsDown).repeat(2));
    }
}
