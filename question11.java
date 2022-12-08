//. Implement the following operations on doubly linked lists:
//1. Insert (end) 2. concatenate two list 3. display
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

    void concatenate(linkedList list1, linkedList list2) {
        node temp = list1.head;
        while (temp != null) {
            int data = temp.data;
            list2.insertAtEnd(data);
            temp = temp.next;
        }
        list2.display();
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

public class question11 {
    public static void main(String[] args) {
        linkedList list1 = new linkedList();
        linkedList list2 = new linkedList();
        list1.insertAtEnd(10);
        list1.insertAtEnd(20);
        list1.insertAtEnd(30);
        list2.insertAtEnd(40);
        list2.insertAtEnd(50);
        list2.insertAtEnd(90);
        list1.display();
        list2.display();
        list1.concatenate(list1, list2);
    }
}