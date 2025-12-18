package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        String str = "abc defab this cdef";
        int[] arr = {-1,3,5,7,2,2,5,7,7,9,-1,6,8,23,4};
        //getTheLast4Chars(str);
        //getTheFirstNonDuplicatedCharInaString(str);
        //getTheFirstNonRepeatingChar(str);
        //findLargestAnd2ndLargestOfAnArray(arr);
        //findMaxiumDifference(arr);
        findRepeatingItemInArray(arr);
    }
    //get the last 4 characters of a string and print them one by one
    public static void getTheLast4Chars(String str) {
        System.out.println(str.length());
        for(int i = str.length()-4 ; i < str.length();i++) {
            if(str.charAt(i) == ' ') {
                //Replace the space with hyphen
                System.out.println("-");
            }else {
                System.out.println(str.charAt(i));
            }
        }
    }
    //Tìm ký tự không lặp lại đầu tiên của một chuổi
    public static
    void getTheFirstNonDuplicatedCharInaString(String str){
        for(int i = 0; i < str.length(); i++){
            //compare the first index to the last index
            //If they are different, then the character is duplicated
            if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))){
                if(str.charAt(i)==' '){
                    System.out.println("The first non duplicated char is: a space");
                    break;
                }else{
                    System.out.println("The first non duplicated char is: " + str.charAt(i));
                    break;
                }
            }else if(i==str.length()-1){
                System.out.println("There is no non duplicated char in the string");
            }
        }
    }

    public static void getTheFirstNonRepeatingChar(String str) {

        Map<Character, Integer> map = new HashMap<>();
        //Define a hash map which has Key as Character and Value as an Integer (count)
        //Counter is
        int counter = 1;

        for (int i = 0; i < str.length(); i++) {
            //A single and non-repeating is a key in hash map
            if (map.containsKey(str.charAt(i))) {
                //
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), counter);
            }
        }
        System.out.println(map);
        //Convert map to an Entry Set, and loop every entry in the set
        for (Map.Entry<Character, Integer> entryMap : map.entrySet()) {
            if (entryMap.getValue() == 1) {
                System.out.print(entryMap.getKey());
                break;
            }
        }
    }
    public static void findLargestAnd2ndLargestOfAnArray(int[] arr){
        int maxNumber = arr[0];
        int sndMaxNumber = arr[0];
        int smallestNumber = arr[0];
        for (int i: arr){
            if(i > maxNumber){
                sndMaxNumber = maxNumber;
                maxNumber = i;
            }else if(i < smallestNumber){
                smallestNumber = i;
            }
        }
        System.out.println("The largest number is: " + maxNumber);
        System.out.println("The 2nd largest number is: " + sndMaxNumber);
        System.out.println("The smallest number is: " + smallestNumber);

    }

    public static void findMaxiumDifference(int[] arr) {
        int maxNumber = arr[0];
        int smallestNumber = arr[0];
        for (int i: arr){
            if(i > maxNumber){
                maxNumber = i;
            }else if(i < smallestNumber){
                smallestNumber = i;
            }
        }
        System.out.println("The largest number is: " + maxNumber);
        System.out.println("The smallest number is: " + smallestNumber);
        int biggestDiff = maxNumber - smallestNumber;
        System.out.println("The Biggest Difference number is: " + biggestDiff);
    }

    public static void findMaxiumDifferenceV2(int[] arr) {
        int maxDiff = arr[0]-arr[1];
        for (int i = 0;i<arr.length;i++){
            for (int j = i+1;j<arr.length;j++){
                if(arr[i]-arr[j]>maxDiff){
                    maxDiff = arr[i]-arr[j];
                }
            }
        }
        System.out.println("The max difference is: " + maxDiff);
    }

    public static void findRepeatingItemInArray(int[] arr){
        Map<Integer, ArrayList<Integer>> map= new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> entryMap : map.entrySet()) {
            if(entryMap.getValue().size()>1){
                System.out.println("repeating item: "+entryMap.getKey()+ " at positions " + entryMap.getValue());
            }
        }
    }
}
