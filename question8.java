//Implement Polynomial addition using linked list concept.

class node {
    int coefficient;
    int power;
    node next;

    node(int coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
        next = null;
    }
}

class linkedList {
    node head;

    linkedList() {
        head = null;
    }

    void insertAtEnd(int coefficient, int power) {
        node n = new node(coefficient, power);
        if (head == null) {
            head = n;
        } else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.coefficient + "x^" + temp.power + " + ");
            temp = temp.next;
        }
        System.out.println();
    }

    void add(linkedList list1, linkedList list2) {
        linkedList list3 = new linkedList();
        node temp1 = list1.head;
        node temp2 = list2.head;
        while (temp1 != null) {
            int coefficient = temp1.coefficient;
            while (temp2 != null) {
                if (temp2.power == temp1.power) {
                    coefficient = coefficient + temp2.coefficient;
                    list3.insertAtEnd(coefficient, temp1.power);
                }
                temp2 = temp2.next;
            }
            temp2 = list2.head;
            temp1 = temp1.next;
        }
        list3.display();
    }
}

public class question8 {
    public static void main(String[] args) {
        linkedList list1 = new linkedList();
        linkedList list2 = new linkedList();
        list1.insertAtEnd(10, 2);
        list1.insertAtEnd(20, 1);
        list1.insertAtEnd(30, 0);
        list2.insertAtEnd(10, 2);
        list2.insertAtEnd(20, 1);
        list2.insertAtEnd(30, 0);
        list1.display();
        list2.display();
        linkedList list = new linkedList();
        list.add(list1, list2);
    }
}