public class A3 {

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[low];
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                // swap arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[low];
        arr[low] = arr[i - 1];
        arr[i - 1] = temp;

        return i - 1;
    }

    public static void main(String[] args) {

        int[] arr = {67, 25, 95, 40, 71, 88, 55, 82, 29, 60};

        int pos = partition(arr, 0, arr.length - 1);

        System.out.println("After partition:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("\nPivot index: " + pos);
    }
}