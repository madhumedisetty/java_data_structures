

public class MatrixSearch {

    // Brute force search method
    public static boolean bruteForceSearch(int[][] matrix, int target) {
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true; 
                }
            }
        }
        return false; 
    }

    // Binary search method (works for sorted rows)

    public static boolean binarySearchInSortedRows(int[][] matrix, int target) {
        // Iterate over each row
        for (int i = 0; i < matrix.length; i++) {
            // Apply binary search on each row if it's sorted
            if (binarySearch(matrix[i], target)) {
                return true; 
            }
        }
        return false; 
    }

    // Helper method for binary search on a single row
    private static boolean binarySearch(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (row[mid] == target) {
                return true; 
            } else if (row[mid] < target) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return false; 
    }


    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 16;

        System.out.println("Brute Force Search Result: " + bruteForceSearch(matrix, target)); // Output: true

        System.out.println("Binary Search in Sorted Rows Result: " + binarySearchInSortedRows(matrix, target)); // Output: true

        target = 25;
        System.out.println("Brute Force Search Result: " + bruteForceSearch(matrix, target)); // Output: false
        System.out.println("Binary Search in Sorted Rows Result: " + binarySearchInSortedRows(matrix, target)); // Output: false
    }
}
