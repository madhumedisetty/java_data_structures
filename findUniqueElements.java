import java.util.*;
import java.util.Map.Entry;

public class findUniqueElements {

    public static void usingHashMap(int[] arr){
        HashMap<Integer, Integer> hash=new HashMap<>();
        for(int i:arr){
            if(hash.get(i)==null) 
               hash.put(i,1);
            else
               hash.put(i, hash.get(i)+1);
        }
        for(Entry<Integer, Integer> e:hash.entrySet()){
            if(e.getValue()==1)
               System.out.println(e.getKey()+" ");

        }
    }

    public static void usingSingleForLoop(int[] arr){
        Arrays.sort(arr);
        int[] unique=new int[10];
        int j=0;
        for(int i=0;i<arr.length;i++){
            //for the first element
            if(i==0){
                if(arr[i]!=arr[i+1]){
                    unique[j]=arr[i];
                    j++;
                }
            }
            //for the last element
            else if(i==arr.length-1){
                if(arr[i]!=arr[i-1]){
                    unique[j]=arr[i];
                    j++;
                }
            }
            //for remaining elements
            else if(arr[i-1]!=arr[i]&&arr[i+1]!=arr[i]){
                unique[j]=arr[i];
                j++;
            }
            
        }
        for(int x:unique){
            if(x!=0)
            System.out.println(x);
        }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        usingHashMap(arr);
        usingSingleForLoop(arr);
        sc.close();


    }
}