//Write a program to represent the given graph using (adjacency matrix/linked list) andimplement
//Depth First Search Traversal for a given Graph.
import java.util.*;
import java.util.Stack;

class Graphs {
    private ArrayList<ArrayList<Integer>> arrayList;

    public Graphs(int numberVertices) {
        arrayList = new ArrayList<ArrayList<Integer>>(numberVertices);
        for (int i = 0; i < numberVertices; i++) {
            arrayList.add(new ArrayList<Integer>());
        }
    }

    public void EdgeAdd(int data, int data2) {
        arrayList.get(data).add(data2);
        arrayList.get(data2).add(data);
    }

    public void GraphDisplay() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(i + " = ");
            for (int j = 0; j < arrayList.get(i).size(); j++) {
                System.out.print(arrayList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void DFS(int key) {
        boolean[] checkVisit = new boolean[arrayList.size()];
        int[] startTime = new int[arrayList.size()];
        int[] endTime = new int[arrayList.size()];
        Stack<Integer> stack = new Stack<Integer>();
        int items[] = new int[arrayList.size()];
        int time = 1;
        int num = 0;
        stack.push(key);
        startTime[key] = time;
        checkVisit[key] = true;
        items[num] = key;
        num++;
        while (stack.isEmpty() == false) {
            int store = stack.peek();
            boolean temp = false;
            for (int i = 0; i < arrayList.get(store).size(); i++) {
                int arr = arrayList.get(store).get(i);
                if (checkVisit[arr] == false) {
                    stack.push(arr);
                    startTime[arr] = ++time;
                    checkVisit[arr] = true;
                    temp = true;
                    items[num] = arr;
                    num++;
                    break;
                }
            }
            if (temp == false) {
                endTime[store] = ++time;
                stack.pop();
            }
        }
        System.out.print("DFS Traversal: ");
        for (int i = 0; i < num; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < num; i++) {
            System.out.println("Vertex: " + items[i] + "\tStart Time = " + startTime[items[i]] + ", End Time = "
                    + endTime[items[i]]);
        }
    }
}

public class question16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of Vertices: ");
        int numberVertices = sc.nextInt();
        Graphs graph = new Graphs(numberVertices);
        System.out.print("Enter the total number of Edges: ");
        int numberEdges = sc.nextInt();
        for (int i = 0; i < numberEdges; i++) {
            System.out.print("Enter Source: ");
            int source = sc.nextInt();
            System.out.print("Enter Destination: ");
            int destination = sc.nextInt();
            graph.EdgeAdd(source, destination);
        }
        System.out.println();
        System.out.println("The Adjacency List of the Graph is");
        graph.GraphDisplay();
        System.out.println();
        System.out.print("Enter the Start Point of the Traversal: ");
        int startingPoint = sc.nextInt();
        graph.DFS(startingPoint);
    }
}