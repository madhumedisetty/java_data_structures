import java.util.ArrayList;

public class LeaderInArray {
    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {4, 7, 1, 0};
        System.out.println("Leaders in arr1: " + findLeaders(arr1));

        // Example 2
        int[] arr2 = {10, 22, 12, 3, 0, 6};
        System.out.println("Leaders in arr2: " + findLeaders(arr2));
    }

    // Method to find leaders in the array
    public static ArrayList<Integer> findLeaders(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>(); // Store leaders
        int maxFromRight = Integer.MIN_VALUE; // Max from right

        // Traverse from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxFromRight) { // Check if current is a leader
                leaders.add(arr[i]); // Add leader
                maxFromRight = arr[i]; // Update max
            }
        }

        // Reverse leaders to maintain order
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = leaders.size() - 1; i >= 0; i--) {
            result.add(leaders.get(i));
        }

        return result; // Return leaders
    }
}
