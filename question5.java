//Write a program to implement Circular Queue.
import java.util.*;

class circularQueues {
    int arr[];
    int size;
    int front;
    int rear;

    circularQueues(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = 0;
    }

    boolean isFull() {
        if (front == (rear + 1) % size) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    void enqueue(int key) {
        if (!isFull()) {
            rear = (rear + 1) % size;
            arr[rear] = key;
            System.out.println(key + " has been enqueued");
        } else {
            System.out.println("Queue is Full");
        }
    }

    void dequeue() {
        if (!isEmpty()) {
            front = (front + 1) % size;
            System.out.println("Front element has been dequeued");
        } else {
            System.out.println("Queue is Empty");
        }
    }

    int queueFront() {
        return (!isEmpty() ? arr[front + 1] : -1);
    }

    int queueRear() {
        return (!isEmpty() ? arr[rear] : -1);
    }

    void display() {
        if (!isEmpty()) {
            for (int i = front + 1; i <= ((rear < front) ? (size - 1) : rear); i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            if (rear < front) {
                for (int i = 0; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Queue is Empty");
        }
    }
}

public class question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        circularQueues queues = new circularQueues(5);
        queues.display();
        System.out.println("Front Element: " + queues.queueFront());
        System.out.println("Rear Element: " + queues.queueRear());
        queues.enqueue(30);
        queues.enqueue(40);
        queues.enqueue(50);
        queues.display();
        queues.dequeue();
        queues.dequeue();
        queues.display();
        queues.enqueue(60);
        queues.display();
        System.out.println("Front Element: " + queues.queueFront());
        System.out.println("Rear Element: " + queues.queueRear());
    }
}