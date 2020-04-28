package Lab1;
//2, 4, 6, 8, 10
import java.util.*;
import java.lang.*;

public class Lab1_Main {
    // Task 2
    void arrComp(int[][] arr1, int[][] arr2) {
        System.out.println("Comparing arr1 and arr2, program will show values that equals:");

        int arr1Length = 0, arr2Length = 0;
        for(int[] i : arr1){
            arr1Length += i.length;
        }
        for(int[] i : arr2){
            arr1Length += i.length;
        }
        int[] buff = new int[arr1Length + arr2Length];
        int buff_i = 0;
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[i].length; j++){
                for(int a = 0; a < arr1.length; a++){
                    for(int b = 0; b < arr1[a].length; b++){
                        if(arr1[i][j] == arr2[a][b]){
                            boolean alreadyUsed = false;
                            for(int c = 0; c < buff.length; c++){
                                if(arr2[a][b] == buff[c]){
                                    alreadyUsed = true;
                                    break;
                                }
                            }
                            if(alreadyUsed == true){
                                alreadyUsed = false;
                                continue;
                            }
                            else{
                                System.out.println(arr2[a][b]);
                                buff[buff_i] = arr2[a][b];
                            }
                        }
                    }
                }
            }
        }
    }
    // Task 4
    int[] delElFromArr(int[] arr, int elToDel){
        System.out.print("Program will delete " + elToDel + " element from array: ");
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        while(elToDel < 0 || elToDel > arr.length) {
            System.out.println("Value is invalid!\nEnter valid value:");
            Scanner in = new Scanner(System.in);
            elToDel = in.nextInt();
        }
        if(elToDel > 0) {
            elToDel -= 1;
        }
        int[] newArr = new int[arr.length - 1];
        for(int i = 0, j = 0; i < arr.length; i++){
            if(i != elToDel){
                newArr[j] = arr[i];
                j++;
            }
        }

        System.out.println("Array after element deletion:");
        for(int i : newArr){
            System.out.println(i);
        }
        return newArr;
    }
    // Task 6
    void doArraysEquivalent(int[] arr1, int[] arr2){
        System.out.print("Program do equivalence check between arrays: ");
        for(int i : arr1){
            System.out.print(i + " ");
        }
        System.out.print(" and ");
        for(int i : arr2){
            System.out.print(i + " ");
        }
        System.out.println();

        if(arr1.length != arr2.length){
            System.out.println("Check result: Arrays don't equivalent");
        }
        else{
            boolean valueHasDuplicate = false;
            for(int i = 0; i < arr1.length; i++){
                for(int j = 0; j < arr2.length; j++){
                    if(arr1[i] == arr2[j]){
                        valueHasDuplicate = true;
                    }
                }
                if(valueHasDuplicate == false){
                    System.out.println("Check result: Arrays don't equivalent");
                    break;
                }
                else{
                    valueHasDuplicate = false;
                }
            }
            if(valueHasDuplicate == false){
                int counterInArr1 = 0;
                int counterInArr2 = 0;
                boolean arraysEquivalent = true;
                for(int i = 0; i < arr1.length; i++){
                    for(int j = 0; j < arr1.length; j++){
                        if(arr1[i] == arr1[j]){
                            counterInArr1++;
                        }
                    }
                    for(int a = 0; a < arr1.length; a++){
                        if(arr1[i] == arr2[a]) {
                            for (int b = 0; b < arr1.length; b++) {
                                if (arr2[a] == arr2[b]) {
                                    counterInArr2++;
                                }
                            }
                            break;
                        }
                    }
                    if(counterInArr1 != counterInArr2){
                        System.out.println("Check result: Arrays don't equivalent");
                        arraysEquivalent = false;
                        break;
                    }
                    else{
                        counterInArr1 = 0;
                        counterInArr2 = 0;
                    }
                }
                if(arraysEquivalent == true){
                    System.out.println("Check result: Arrays equivalent");
                }
            }
        }
    }
    // Task 8
    void countAmOfDuplicates(int[] arr) {
        System.out.print("Program will count amount times each number contains in array: ");
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        int temp = 0;
        for(int i = 0, j = 1; j < arr.length; i++, j++){
            if(arr[i] > arr[j]){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i = 0;
                j = 1;
            }
        }

        System.out.print("Array after bubble sort: ");
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i != 0) {
                if (arr[i - 1] == arr[i]) {
                    continue;
                }
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    counter++;
                }
            }
            System.out.println(arr[i] + " - " + counter);
            counter = 0;
        }
    }
    // Task 10
    void connectArrays(int[] ...arr){
        System.out.println("Program will convert several arrays into one:");

        int arrLength = 0;
        for(int[] i : arr){
            arrLength += i.length;
        }
        int[] newArr = new int[arrLength];
        int z = 0;
        for(int[] i : arr){
            for(int j : i){
                newArr[z] = j;
                z++;
            }
        }
        for(int i : newArr){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Lab1_Main m1 = new Lab1_Main();
        // Task 2

        int[][] arr1 = {{3, 4, 5}, {6, 8, 9}};
        int[][] arr2 = {{4, 5, 12, 13}, {6, 6, 8, 10}};
        m1.arrComp(arr1, arr2);

        // Task 4

        int[] arr3 = {1, 2, 3, 4, 5};
        int elYouWantToDelete = 3;

        int[] newArr3 = m1.delElFromArr(arr3, elYouWantToDelete);

        // Task 6

        int[] arr4 = {0, 2, 2, 3};
        int[] arr5 = {2, 3, 2, 0};
        m1.doArraysEquivalent(arr4, arr5);

        // Task 8

        int[] arr6 = {1, 43, 32, 43, 32, 43, 14};
        m1.countAmOfDuplicates(arr6);

        // Task 10

        int[] arr7 = {4, 5, 2, 7};
        int[] arr8 = {1, 6, 3};
        int[] arr9 = {2, 4};
        int[] arr10 = {6, 5, 9, 11, 13};
        m1.connectArrays(arr7, arr8, arr9, arr10);
    }
}

