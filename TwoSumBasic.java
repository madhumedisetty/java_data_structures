package com.datastructure.array;
import java.util.*;

public class TwoSumBasic {
    //Brute force approach
    public static void twoSumBrute(int[] arr, int target){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    System.out.println("Elements are: " + i + ", " + j);
                    return;
                }
            }
        }
        System.out.println("No such pair exists");
    }
    //Optimal approach
    public static void twoSumOptimal(int[] arr, int target){
        HashMap<Integer, Integer> hs=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int comp=target-arr[i];
            if(hs.containsKey(comp)){
                System.out.println("Elements are: " + hs.get(comp) + ", " + i);
                return;
            }
            hs.put(arr[i],i);
        }
        System.out.println("No such pair exists");
    }
    //two pointer approach
    public static void twoSumTwoPointer(int[] arr, int target){
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        while(left<right){
            if(arr[left]+arr[right]==target){
                System.out.println("Elements are: " + left + ", " + right);
                return;
            }
            else if(arr[left]+arr[right]<target){
                left++;
            }
            else{
                right--;
            }
        }
        System.out.println("No such pair exists");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the target");
        int target=sc.nextInt();
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        twoSumBrute(arr,target);
        twoSumOptimal(arr,target);
        twoSumTwoPointer(arr,target);
        sc.close();
    }
    
    
}
