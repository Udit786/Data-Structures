//Write a program to implement the Hash Table concept using quadratic probing
import java.util.*;

class question18 {
    int size;
    int arr[];

    question18(int size) {
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
        while (arr[(index + i * i) % size] != -1) {
            i++;
            System.out.println("Collision has occured at index " + ((index + (i - 1) * (i - 1)) % size));
        }
        System.out.println("Element " + key + " has been inserted at index " + ((index + i * i) % size));
        return (index + i * i) % size;
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
        int arr[] = new int[num];
        question18 squareProbing = new question18(size);
        for (int i = 0; i < num; i++) {
            System.out.print("Enter element: ");
            arr[i] = sc.nextInt();
            squareProbing.insert(arr[i]);
        }
        squareProbing.display();
    }
}