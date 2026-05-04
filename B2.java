public class B2 {

    static class Pair {
        int min, max;
    }

    public static Pair findMinMax(int[] arr, int left, int right) {

        Pair result = new Pair();

        // base case: 1 element
        if (left == right) {
            result.min = arr[left];
            result.max = arr[left];
            return result;
        }

        // base case: 2 elements
        if (right == left + 1) {
            if (arr[left] < arr[right]) {
                result.min = arr[left];
                result.max = arr[right];
            } else {
                result.min = arr[right];
                result.max = arr[left];
            }
            return result;
        }

        int mid = (left + right) / 2;

        Pair leftResult = findMinMax(arr, left, mid);
        Pair rightResult = findMinMax(arr, mid + 1, right);

        result.min = Math.min(leftResult.min, rightResult.min);
        result.max = Math.max(leftResult.max, rightResult.max);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {67, 25, 95, 40, 71, 88, 55, 82, 29, 60};

        Pair result = findMinMax(arr, 0, arr.length - 1);

        System.out.println("Min: " + result.min);
        System.out.println("Max: " + result.max);
        System.out.println("Range: " + (result.max - result.min));
    }
}