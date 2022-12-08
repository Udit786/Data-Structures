//Implement the Min Heap tree and sort the elements.

import java.util.*;

class question19 {
    static void heapify(int arr[], int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if ((left < n) && (arr[left] < arr[smallest])) {
            smallest = left;
        }
        if ((right < n) && (arr[right] < arr[smallest])) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr, n, smallest);
        }
    }

    static void sort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        System.out.print("Minimum Heap: ");
        display(arr);
        System.out.println();
        System.out.println("Sorting: ");
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            System.out.println("Element " + arr[i] + " is removed from the heap");
            heapify(arr, i, 0);
            display(arr);
        }
    }

    static void display(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int num = sc.nextInt();
        int arr[] = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Enter the element to be added: ");
            arr[i] = sc.nextInt();
        }
        System.out.println();
        sort(arr);
        display(arr);
        System.out.println();
        System.out.print("Sorted Array: ");
        display(arr);
    }
}