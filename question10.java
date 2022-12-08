//Implement the following operations on doubly linked lists:
//1. Insert (at position) 2. sort the list 3. display.
class node {
    int data;
    node next;
    node prev;

    node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

class linkedList {
    node head;
    int size;

    linkedList() {
        head = null;
        size = 0;
    }

    void insertAtStart(int value) {
        node n = new node(value);
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        size++;
    }

    void insertAtEnd(int value) {
        node n = new node(value);
        if (head == null) {
            head = n;
        } else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            n.prev = temp;
        }
        size++;
    }

    void insertAtPosition(int value, int location) {
        node n = new node(value);
        if (location == 1) {
            insertAtStart(value);
        } else if (location == size) {
            insertAtEnd(value);
        } else if (location > size + 1) {
            System.out.println("Location does not exist");
        } else {
            node temp = head;
            for (int i = 0; i < location - 2; i++) {
                temp = temp.next;
            }
            temp.next.prev = n;
            n.next = temp.next;
            temp.next = n;
            n.prev = temp;
        }
        size++;
    }

    void sortLinkedList() {
        int flag = 1;
        while (flag < size) {
            node temp1 = head;
            node temp2 = temp1.next;
            while (temp1 != null && temp2 != null) {
                if (temp1.data > temp2.data) {
                    int temp = temp1.data;
                    ;
                    temp1.data = temp2.data;
                    temp2.data = temp;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            flag++;
        }
    }

    void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class question10 {
    public static void main(String[] args) {
        linkedList list = new linkedList();
        list.insertAtStart(10);
        list.insertAtEnd(20);
        list.insertAtStart(30);
        list.insertAtEnd(40);
        list.display();
        list.insertAtPosition(50, 1);
        list.display();
        list.insertAtPosition(90, 2);
        list.display();
        list.insertAtPosition(60, 3);
        list.display();
        list.insertAtPosition(70, 6);
        list.display();
        list.insertAtPosition(80, 5);
        list.display();
        list.insertAtPosition(100, 8);
        list.display();
        list.insertAtPosition(110, 10);
        list.display();
        list.sortLinkedList();
        list.display();
    }
}