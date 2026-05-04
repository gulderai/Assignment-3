import java.util.Arrays;

public class Main {


    public static void heapify(int[] arr, int n, int i) {
        int largest = i; //
        int left = 2 * i + 1;
        int right = 2 * i + 2;


        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }


        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {

        int[] arr = {67, 25, 95, 40, 71, 88, 55, 82, 29, 60};
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        System.out.println("After building Max Heap:");
        System.out.println(Arrays.toString(arr));

        int max = arr[0];


        arr[0] = arr[n - 1];

        heapify(arr, n - 1, 0);

        System.out.println("Extracted max value: " + max);

        System.out.print("After extract-max: [");
        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i]);
            if (i < n - 2) System.out.print(", ");
        }
        System.out.println("]");
    }
}