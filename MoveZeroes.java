package com.datastructure.array;
import java.util.Scanner;
public class MoveZeroes {
    //brute force approach
    public static void moveZeroes(int[] arr){
        int n=arr.length;
        int j=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[j++]=arr[i];
            }
        }
        while(j<n){
            arr[j++]=0;
        }
        System.out.println("The array after moving zeroes to the end is:");
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    //optimal approach
    public static void moveZeroesOptimal(int[] arr){
        int j=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        for(int i=j+1;i<arr.length;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
        System.out.println("The array after moving zeroes to the end is:");
        for(int i:arr){
            System.out.print(i+" ");
        }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        System.out.println("Enter the elements of the array:");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] x=arr;
        moveZeroes(arr);
        moveZeroesOptimal(x);
        sc.close();
    }
}
