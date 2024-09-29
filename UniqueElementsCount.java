package com.datastructure.array;
import java.util.HashSet;
import java.util.Scanner;

public class UniqueElementsCount {
    public static void uniqueElementsCount1(int[] arr){
        //using hashset
        HashSet<Integer> hs=new HashSet<>();
        for(int x:arr){
            hs.add(x);
        }
        int n=hs.size();
        int j=0;
        for(int x:hs){
            arr[j++]=x;
        }
        System.out.println("Unique elements count: " + n);
        System.out.println("Unique elements are:");
        for(int k=0;k<n;k++){
            System.out.print(arr[k]+" ");
        }
        System.out.println();
    }
    public static void uniqueElementsCount2(int[] arr){
        //without using hashset
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        System.out.println("Unique elements count: " + (i+1));
        System.out.println("Unique elements are:");
        for(int k=0;k<=i;k++){
            System.out.print(arr[k]+" ");
        }
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
        int[] arr2=arr.clone();
        uniqueElementsCount1(arr);
        uniqueElementsCount2(arr2);
        sc.close();
    }
    
}
