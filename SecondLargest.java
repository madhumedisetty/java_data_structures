// package com.datastructure.array;
import java.util.Scanner;
public class SecondLargest {
    public static int secondLargest(int[] arr){
        int largest=arr[0];
        int secondLargest=Integer.MIN_VALUE;
        if(arr.length<2){
            return(-1);
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>secondLargest&&arr[i]!=largest){
                secondLargest=arr[i];
            }
        }
        if(secondLargest==Integer.MIN_VALUE){
            return(-1);
        }
        return(secondLargest);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Second largest element is: " + secondLargest(arr));
        sc.close();
    }
}
