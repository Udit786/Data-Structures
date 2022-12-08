//Write a program to represent the given graph using (adjacency matrix/linked list) and implement
//Breadth-First Search Traversal for a given Graph.

import java.util.*;
import java.util.Queue;

class Graph {
    private ArrayList<ArrayList<Integer>> arrayList;

    public Graph(int numberVertices) {
        arrayList = new ArrayList<ArrayList<Integer>>(numberVertices);
        for (int i = 0; i < numberVertices; i++) {
            arrayList.add(new ArrayList<Integer>());
        }
    }

    public void EdgeAdd(int data1, int data2) {
        arrayList.get(data1).add(data2);
        arrayList.get(data2).add(data1);
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

    public void BFS(int key) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] level = new int[arrayList.size()];
        boolean[] checkVisit = new boolean[arrayList.size()];
        queue.add(key);
        checkVisit[key] = true;
        level[key] = 0;
        while (queue.isEmpty() == false) {
            int numberVertices = queue.remove();
            System.out.println("BFS Traversal: ");
            System.out.println("Vertex: " + numberVertices + "   Level = " + level[numberVertices]);
            for (int i = 0; i < arrayList.get(numberVertices).size(); i++) {
                int arr = arrayList.get(numberVertices).get(i);
                if (!checkVisit[arr]) {
                    level[arr] = level[numberVertices] + 1;
                    queue.add(arr);
                    checkVisit[arr] = true;
                }
            }
        }
    }
}

public class question15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of Vertices: ");
        int numberVertices = sc.nextInt();
        Graph graph = new Graph(numberVertices);
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
        graph.BFS(startingPoint);
    }
}