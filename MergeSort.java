public class MergeSort {
    //add comments to each line of code to explain the logic
    public static void main(String[] args) {    
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    //merge sort function
    public static void mergeSort(int[] arr, int left, int right) {
        //base case
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    //merge function
    public static void merge(int[] arr, int left, int mid, int right) { 
        //calculate the size of the left and right subarrays
        int n1 = mid - left + 1;
        int n2 = right - left;
        //create the left and right subarrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        //copy the elements of the left subarray into the left array
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];    
        }
        //initialize the indices of the left and right subarrays and the merged array
        int i = 0, j = 0, k = left;
        //merge the two subarrays
        while (i < n1 && j < n2) {
            //if the current element of the left subarray is less than or equal to the current element of the right subarray
            if (L[i] <= R[j]) {
                //copy the current element of the left subarray into the merged array
                arr[k] = L[i];
                i++;
            } else {
                //copy the current element of the right subarray into the merged array
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        //copy the remaining elements of the left subarray into the merged array
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        //copy the remaining elements of the right subarray into the merged array
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }   
}

