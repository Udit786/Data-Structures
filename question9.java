//Implement Polynomial Multiplication using linked list concept.
import java.util.*;

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
        node temp4 = head;
        while (temp4 != null) {
            System.out.print(temp4.coefficient + "x^" + temp4.power + " + ");
            temp4 = temp4.next;
        }
        System.out.println();
    }

    void multiply(linkedList list1, linkedList list2) {
        linkedList list3 = new linkedList();
        node temp1 = list1.head;
        node temp2 = list2.head;
        while (temp1 != null) {
            while (temp2 != null) {
                list3.insertAtEnd(temp1.coefficient * temp2.coefficient, temp1.power + temp2.power);
                temp2 = temp2.next;
            }
            temp2 = list2.head;
            temp1 = temp1.next;
        }
        list3.display();
    }
}

public class question9 {
    public static void main(String[] args) {
        linkedList list1 = new linkedList();
        linkedList list2 = new linkedList();
        list1.insertAtEnd(1, 2);
        list1.insertAtEnd(2, 1);
        list1.insertAtEnd(1, 0);
        list2.insertAtEnd(1, 2);
        list2.insertAtEnd(2, 1);
        list2.insertAtEnd(1, 0);
        list1.display();
        list2.display();
        linkedList list = new linkedList();
        list.multiply(list1, list2);
    }
}