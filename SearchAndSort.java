import java.util.Arrays;
import java.util.Scanner;

public class SearchAndSort {
    private static String duration;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of elements in the array: ");
            int n = scanner.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.print("Enter the number to search: ");
            int target = scanner.nextInt();

            System.out.println("Select the search type:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");

            int searchType = scanner.nextInt();
            long startTime, endTime, duration;

            if (searchType == 1) {
                startTime = System.nanoTime();
                int linearSearchIndex = linearSearch(arr, target);
                endTime = System.nanoTime();
                duration = endTime - startTime;

                if (linearSearchIndex == -1) {
                    System.out.println("Element not found in the array.");
                } else {
                    System.out.println("Element found at index " + linearSearchIndex);
                }
            } else if (searchType == 2) {
                Arrays.sort(arr);
                startTime = System.nanoTime();
                int binarySearchIndex = binarySearch(arr, target);
                endTime = System.nanoTime();
                duration = endTime - startTime;

                if (binarySearchIndex == -1) {
                    System.out.println("Element not found in the array.");
                } else {
                    System.out.println("Element found at index " + binarySearchIndex);
                }
            } else {
                System.out.println("Invalid search type selected.");
                return;
            }

            System.out.println("Time taken: " + duration + " nanoseconds.");

            System.out.println("Select the sorting algorithm type:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");

            int sortType = scanner.nextInt();
            startTime = System.nanoTime();

            switch (sortType) {
                case 1:
                    bubbleSort(arr);
                    break;
                case 2:
                    selectionSort(arr);
                    break;
                case 3:
                    insertionSort(arr);
                    break;
                case 4:
                    mergeSort(arr, 0, arr.length - 1);
                    break;
                case 5:
                    quickSort(arr, 0, arr.length - 1);
                    break;
                default:
                    System.out.println("Invalid sorting algorithm type selected.");
                    return;
            }

            endTime = System.nanoTime();
            duration = endTime - startTime;
            System.out.println("Sorted array: " + Arrays.toString(arr));
        }

        System.out.println("Time taken: " + duration + " nanoseconds.");
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
