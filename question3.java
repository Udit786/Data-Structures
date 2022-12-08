//Write a program to maintain multiple queues in a single array.

import java.util.*;

class multipleQueues {
    int arr[];
    int front[];
    int rear[];

    multipleQueues(int queueNumber) {
        arr = new int[queueNumber * 4];
        front = new int[queueNumber];
        rear = new int[queueNumber];
        for (int i = 0; i < queueNumber; i++) {
            front[i] = i * 4;
            rear[i] = front[i] - 1;
        }
    }

    void enqueue(int key, int queueNumber) {
        queueNumber = queueNumber - 1;
        if (rear[queueNumber] < ((queueNumber + 1) * 4) - 1) {
            rear[queueNumber]++;
            arr[rear[queueNumber]] = key;
        } else {
            System.out.println("Queue is Full");
        }
    }

    void dequeue(int queueNumber) {
        queueNumber = queueNumber - 1;
        if (rear[queueNumber] < front[queueNumber]) {
            System.out.println("Queue is Empty");
        } else {
            front[queueNumber]++;
        }
    }

    void display(int queueNumber) {
        queueNumber = queueNumber - 1;
        for (int i = front[queueNumber]; i <= rear[queueNumber]; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class question3 {
    public static void main(String[] args) {
        multipleQueues multipleQueue = new multipleQueues(5);
        multipleQueue.enqueue(10, 1);
        multipleQueue.enqueue(20, 1);
        multipleQueue.enqueue(50, 2);
        multipleQueue.enqueue(60, 2);
        multipleQueue.enqueue(30, 3);
        multipleQueue.enqueue(40, 3);
        multipleQueue.enqueue(70, 4);
        multipleQueue.enqueue(80, 4);
        multipleQueue.display(1);
        multipleQueue.display(2);
        multipleQueue.display(3);
        multipleQueue.display(4);
    }
}