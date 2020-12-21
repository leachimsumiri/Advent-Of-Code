package com.asd;

import java.util.List;

import static java.lang.Integer.parseInt;

public class Day2 {
    public static void main(String[] args) {
        int res = day2();
        System.out.println(res);
    }

    public static Integer day2(){
        List<String> stringList = TestUtils.readFileIntoList("com/asd/resources/day2.txt");
        int validPasswords = 0;
        int validPasswordsPartTwo = 0;

        for(String line : stringList){
            int lowConstraintIntLength = getConstraintNumberLength(line, 0);
            int lowConstraint = parseInt(line.substring(0, lowConstraintIntLength));

            int highConstraintIntLength = getConstraintNumberLength(line, lowConstraintIntLength+1);
            int highConstraint = parseInt(line.substring(lowConstraintIntLength+1, lowConstraintIntLength+1+highConstraintIntLength));

            char policyChar = line.charAt(lowConstraintIntLength+1+highConstraintIntLength+1);

            String referenceString = line.substring(lowConstraintIntLength+1+highConstraintIntLength+1+2);

            int validPolicyChars = 0;
            int validPolicyCharsPartTwo = 0;

            for(int i = 0; i < referenceString.length(); i++){
                if(referenceString.charAt(i) == policyChar){
                    validPolicyChars++;
                    if(i == lowConstraint || i == highConstraint){
                        validPolicyCharsPartTwo++;
                    }
                }
            }

            if(validPolicyChars >= lowConstraint && validPolicyChars <= highConstraint){
                validPasswords++;
            }

            if(validPolicyCharsPartTwo == 1){
                validPasswordsPartTwo++;
            }
        }

        //return validPasswords;//part one
        return validPasswordsPartTwo;
    }

    public static Integer getConstraintNumberLength(String line, int startingCharIndex){
        for(int i = startingCharIndex; i < line.length(); i++){
            if(line.charAt(i) == '-' || line.charAt(i) == ' '){
                return i-startingCharIndex;
            }
        }

        return null;
    }
}
