//Evaluation of Post-fix expression using Stack

import java.util.*;

class Stack {
    int arr[];
    int top;
    int size;

    Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    void push(int value) {
        if (isFull()) {
            System.out.println("Stack is Full");
        } else {
            top++;
            arr[top] = value;
        }
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            top--;
        }
    }

    int getTop() {
        if (top != -1) {
            return arr[top];
        }
        return 0;
    }

    void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class question4 {

    public static int postfixEvaluation(String str) {
        Stack stack = new Stack(100);
        for (int i = 0; i <= str.length() - 1; i++) {
            int element = (int) (str.charAt(i) - '0');
            if (element >= 0 && element <= 9) {
                stack.push(element);
            } else {
                char operator = str.charAt(i);
                int a = stack.getTop();
                stack.pop();
                int b = stack.getTop();
                stack.pop();
                int c;
                if (operator == '*') {
                    c = b * a;
                    stack.push(c);
                } else if (operator == '/') {
                    c = b / a;
                    stack.push(c);
                } else if (operator == '+') {
                    c = b + a;
                    stack.push(c);
                } else if (operator == '-') {
                    c = b - a;
                    stack.push(c);
                }
            }
        }
        return stack.getTop();
    }

    public static void main(String[] args) {
        String str = "53+62/*35*+";
        System.out.println(postfixEvaluation(str));
    }
}