public class Main {

    public static int binarySearchIterative(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (target < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 8, 12, 16, 23, 38};

        System.out.println(binarySearchIterative(a, 23));
        System.out.println(binarySearchIterative(a, 2));
        System.out.println(binarySearchIterative(a, 40));
    }
}