//Given a singly linked list, determine if it's a palindrome. Return 1 or 0 denoting if it's a
//palindrome or not, respectively. 
import java.util.*;

class node {
    node next;
    char data;

    node(char k) {
        data = k;
        next = null;
    }
}

class List {
    node head = null;

    void insertAtStart(char k) {
        node n = new node(k);
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    public char deleteAtStart() {
        char x = 0;
        node temp = head;
        x = temp.data;
        head = head.next;
        temp.next = null;
        return x;
    }

    void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(" ");
    }
}

public class question7 {

    public static void palindrome(String str) {
        List list1 = new List();
        List list2 = new List();
        List list3 = new List();
        int flag = 0;
        for (int i = 0; i < str.length() / 2; i++) {
            list1.insertAtStart(str.charAt(i));
        }
        for (int i = (str.length() % 2 == 0 ? (str.length() / 2) : (str.length() / 2 + 1)); i < str.length(); i++) {
            list2.insertAtStart(str.charAt(i));
        }
        for (int i = 0; i < str.length() / 2; i++) {
            list3.insertAtStart(list2.deleteAtStart());
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (list1.deleteAtStart() == list3.deleteAtStart()) {
                continue;
            } else {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("String is a Palindrome");
        } else {
            System.out.println("String is not a Palindrome");
        }
    }

    public static void main(String[] args) {
        palindrome("121");
    }
}