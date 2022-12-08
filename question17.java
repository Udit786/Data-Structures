//Write a program to implement the Hash Table concept using linear probing
import java.util.*;

class question17 {
    int size;
    int arr[];

    question17(int size) {
        this.size = size;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = -1;
        }
    }

    int hash(int key) {
        return key % size;
    }

    int probing(int key) {
        int index = hash(key);
        int i = 0;
        while (arr[(index + i) % size] != -1) {
            i++;
            System.out.println("Collision has occured at index " + (index + i - 1) % size);
        }
        System.out.println("Element " + key + " has been inserted at index " + ((index + i) % size));
        return (index + i) % size;
    }

    void insert(int key) {
        arr[probing(key)] = key;
    }

    void display() {
        System.out.print("Index\tValue\n");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d\t%d\n", i, arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        int size = sc.nextInt();
        System.out.print("Enter the number of elements to be inserted: ");
        int num = sc.nextInt();
        question17 linearProbing = new question17(size);
        int arr[] = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Enter element: ");
            arr[i] = sc.nextInt();
            linearProbing.insert(arr[i]);
        }
        System.out.println();
        System.out.println("Hash Table: ");
        linearProbing.display();
    }
}