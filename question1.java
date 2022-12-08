// Conversion of Infix expression to postfix expression using stack.
import java.util.*;

class Stack {
    char arr[];
    int top;
    int size;

    Stack(int size) {
        this.size = size;
        arr = new char[size];
        top = -1;
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    void push(char key) {
        if (top == (size - 1)) {
            System.out.println("Stack is Full");
        } else {
            top++;
            arr[top] = key;
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack is Empty");
        } else {
            top--;
        }
    }

    char getTop() {
        if (top != -1) {
            return arr[top];
        }
        return '0';
    }

    void display() {
        if (top == -1) {
            System.out.println("Stack is Empty");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

public class question1 {

    public static int precedence(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        }
        return 0;
    }

    public static String conversion(String str) {
        String result = "";
        Stack stack = new Stack(100);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                result = result + c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while ((!stack.isEmpty()) && (stack.getTop() != '(')) {
                    result = result + stack.getTop();
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if ((precedence(c) > precedence(stack.getTop())) || (stack.isEmpty())) {
                    stack.push(c);
                } else {
                    while ((!stack.isEmpty()) && (precedence(c) <= precedence(stack.getTop()))
                            && (stack.getTop() != '(')) {
                        result = result + stack.getTop();
                        stack.pop();
                    }
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            result = result + stack.getTop();
            stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "a+b/c*d";
        System.out.println(conversion(str));
    }
}