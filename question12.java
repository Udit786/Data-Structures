//Given a sorted linked list, delete all duplicates such that each element appears only once.

class node {
    node next;
    int data;

    node(int data) {
        this.data = data;
        next = null;
    }
}

class linkedList {
    node head = null;
    int size = 0;

    void insertAtStart(int data) {
        node n = new node(data);
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head = n;
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

    void removeDuplicates() {
        node temp1 = head;
        node temp2 = head;
        while (temp1.next != null && temp2 != null) {
            temp2 = temp1.next;
            while ((temp1.data == temp2.data) && (temp2 != null)) {
                temp2 = temp2.next;
            }
            temp1.next = temp2;
            temp1 = temp1.next;
        }
    }

    void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class question12 {
    public static void main(String[] args) {
        linkedList list = new linkedList();
        list.insertAtStart(10);
        list.insertAtStart(20);
        list.insertAtStart(30);
        list.insertAtStart(40);
        list.insertAtStart(20);
        list.insertAtStart(10);
        list.display();
        list.sortLinkedList();
        list.display();
        list.removeDuplicates();
        list.display();
    }
}