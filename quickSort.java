import java.util.Scanner;

public class quickSort {

    // Function to swap two elements
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Partition function: partitions the array and returns the pivot index
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Pivot is the last element
        int i = low - 1;        // Index of smaller element
        System.out.println("Pivot: " + pivot);  // Print the pivot
        for (int j = low; j < high; j++) {
            System.out.print("Current state: ");
            printArray(arr);  // Print current state of the array
            if (arr[j] <= pivot) {
                i++;  // Increment index of smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);  // Place pivot in correct position
        System.out.print("Current state: ");
        printArray(arr);  // Print array after partitioning
        return i + 1;
    }

    // Quick Sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);  // Partition the array
            quickSort(arr, low, pivotIndex - 1);  // Sort the elements before pivot
            quickSort(arr, pivotIndex + 1, high);  // Sort the elements after pivot
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Initial array: ");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.print("Sorted array: ");
        printArray(arr);

        scanner.close();
    }
}
