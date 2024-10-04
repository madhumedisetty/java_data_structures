import java.util.*;
public class LongestPalindromSubstring {
    public static String longestPalindrome(String str){
        int n=str.length();
        if(n<=1){
            return(str);
        }
        int maxLen=1;
        int start=0;
        for(int i=0;i<n;i++){
            int l1=expandAroundCenter(str,i,i);
            int l2=expandAroundCenter(str,i,i+1);
            int currLen=Math.max(l1,l2);
            if(currLen>maxLen){
                maxLen=currLen;
                start=i-(currLen-1)/2;
            }
        }
        return str.substring(start, start+maxLen);

    }
    public static int expandAroundCenter(String str, int left, int right){
        while(left>=0 && right<str.length() && (str.charAt(right)==str.charAt(left))){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(longestPalindrome(s));
        sc.close();

    }
    
}
