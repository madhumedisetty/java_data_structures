package com.datastructure.array;
import java.util.Scanner;
public class RotateArray {
    //brute approach
    public static void rotateArray(int[] nums,int k){
        if(nums.length==1){
            return;
        }
        while(k>0){
            int temp=nums[nums.length-1];
            for(int i=nums.length-1;i>0;i--){
                nums[i]=nums[i-1];
            }
            nums[0]=temp;
            k--;
        }
    }
    //optimal approach
    public static void reverse(int[] nums,int start,int end){
        while(start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public static void rotateArrayOptimal(int[] nums,int k){
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);    
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] arr2=arr.clone(); 
        System.out.println("Enter the value of k:");
        int k=sc.nextInt();
        rotateArray(arr,k);
        System.out.println("The array after rotation is:");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        rotateArrayOptimal(arr2,k);
        System.out.println("The array after rotation is:");
        for(int i:arr2){
            System.out.print(i+" ");
        }
        System.out.println();
        sc.close();
    }
}
