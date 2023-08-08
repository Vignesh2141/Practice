package org.neosoft;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<String> list1 = Arrays.asList("Java", "8","Spring");
//        List<String> list2 = Arrays.asList("explained", "through", "programs");
        String st="MOM";
        boolean checkPalindrome=isPalindrome(st);
        if(checkPalindrome){
            System.out.println("String "+st+" is a palindrome");
        }else{
            System.out.println("String "+st+ " is not a palindrome");
        }

    }

    private static boolean isPalindrome(String st) {
        boolean val=false;
        int left=0;
        int right=st.length()-1;
        while (left<right){
            if (st.charAt(left)!=st.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}