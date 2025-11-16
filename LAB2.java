import java.util.Arrays;
import java.util.Random;

public class LAB2 {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
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

            int pi = i + 1;
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }


        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            }
            
            else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        
        while (j < right.length) {
            arr[k++] = right[j++];
        }
         
    }

    public static int[] randomArray(int size) {
        Random rnd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rnd.nextInt(1000);
        return arr;
    }

    public static int[] partiallySorted(int size, int procentsorted) {
        
        int[] arr = new int[size];
        
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        Random rnd = new Random();
        int percentToSwap = 100 - procentsorted;
        int swaps = size * percentToSwap / 100;

        for (int i = 0; i < swaps; i++) {
            int index1 = rnd.nextInt(size);
            int index2 = rnd.nextInt(size);
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
    }

        return arr;
    }

    public static int[] lotsofDuplicates(int size) {
        
        int[] arr = new int[size];

        Random rnd = new Random();
        int randomvalue = rnd.nextInt(size);

        for (int i = 0; i < size; i++) {
            arr[i] = randomvalue;
        }


        int swaps = (int)(size * 0.1);

        for (int i = 0; i < swaps; i++) {
            arr[i] = rnd.nextInt(size);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};


        for (int size : sizes)  {
            long info1 = 0, info2 = 0, info3 = 0;
            
            for (int i = 0; i < 5; i++) {
                int[] arr1 = partiallySorted(size, 95);
                int[] arr2 = Arrays.copyOf(arr1, arr1.length);
                int[] arr3 = Arrays.copyOf(arr1, arr1.length);

                long start, end;

                start = System.nanoTime();
                insertionSort(arr1);
                end = System.nanoTime();
                info1 += end - start;
                
                start = System.nanoTime();
                quickSort(arr2, 0, arr2.length - 1);
                end = System.nanoTime();
                info2 += end - start;

                start = System.nanoTime();
                mergeSort(arr3);
                end = System.nanoTime();
                info3 += end - start;
            }

            System.out.println("Вставками " + (info1/5) + " для " + size + " размеров");
            System.out.println("QuickSort " + (info2/5) + " для " + size + " размеров");
            System.out.println("MergeSort " + (info3/5) + " для " + size + " размеров" + "\n");
        }

    }
}
