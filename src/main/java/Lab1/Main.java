package Lab1;

public class Main {
    private static int array[];

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        array = new int[]{10, 5, 8, 9, 76, 54, 11, 20, 48};
        System.out.print("Initial array is: { ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("}");
        bubbleSort(array);
        System.out.print("Sorted array is: { ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("}");
    }
}
