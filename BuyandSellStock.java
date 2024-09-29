package com.datastructure.array;
import java.util.Scanner;
public class BuyandSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice, prices[i]);
            maxProfit=Math.max(maxProfit, prices[i]-minPrice);
        }
        return maxProfit;
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
        System.out.println("The maximum profit is: " + maxProfit(arr));
        sc.close();
    }
}
