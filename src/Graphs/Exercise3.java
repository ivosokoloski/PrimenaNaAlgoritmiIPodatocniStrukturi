package Graphs;
import java.util.*;
//
//Една компанија сака да воспостави комуникациска мрежа меѓу своите канцеларии во
//различни градови. Компанијата има листа на можни врски помеѓу градовите и нивната цена.
//Целта е да се минимизира вкупната цена за поврзување на сите градови. Да се одреди
//минималната цена за поврзување на сите градови.
//Влез: Во првиот ред е даден бројот на градови N. Потоа во следните N редови се дадени
//имињата на градовите. Во следниот ред е даден бројот на можни врски M, а потоа во следните
//M редови се дадени градовите што ги поврзува секоја врска и цената за воспоставување на таа врска.
//Излез:  Минималната цена да се поврзат сите градови.
//Пример:
//Влез:
//4
//London
//Paris
//Brussels
//Amsterdam
//5
//London Paris 400
//London Brussels 200
//Paris Brussels 100
//Brussels Amsterdam 150
//Paris Amsterdam 300
//
//Излез: 450 (Објаснување: ќе се воспостават врските London-Brussels,
//Brussels-Amsterdam и Brussels-Paris)
//
//        /
//
//A company wants to establish a communication network between its offices in different
//cities. They have a list of potential connections between cities, along with their costs.
//The company wants to minimize the total cost of connecting all cities.
//Determine the minimum cost to connect all cities.
//Input: The first line contains the number of cities N. The next N lines contain the names
//of the cities. The next line contains the number of possible connections M, followed by M
//lines that contain the two cities connected by each connection and the cost of establishing that connection.
//Output: The minimum cost to connect all cities.
//Example:
//Input:
//4
//London
//Paris
//Brussels
//Amsterdam
//5
//London Paris 400
//London Brussels 200
//Paris Brussels 100
//Brussels Amsterdam 150
//Paris Amsterdam 300
//Output: 450 (Explanation: the connections London-Brussels,
//Brussels-Amsterdam and Brussels-Paris will be established)



public class Exercise3{
    public static void main(String[] args) {
        AdjacencyListGraph3<String> graph = new AdjacencyListGraph3<>();
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            graph.addVertex(scanner.nextLine());
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] edgeData = scanner.nextLine().split(" ");
            String source = edgeData[0];
            String destination = edgeData[1];
            int weight = Integer.parseInt(edgeData[2]);
            graph.addEdge(source, destination, weight);
        }
        int result = graph.findMST();
        System.out.println(result);
    }
}

class AdjacencyListGraph3<T> {
    private Map<T, Map<T, Integer>> adjacencyList;

    public AdjacencyListGraph3() {
        this.adjacencyList = new HashMap<>();
    }


    public void addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashMap<>());
        }
    }


    public void removeVertex(T vertex) {
        // Remove the vertex from all adjacency lists
        for (Map<T, Integer> neighbors : adjacencyList.values()) {
            neighbors.remove(vertex);
        }

        adjacencyList.remove(vertex);
    }


    public void addEdge(T source, T destination, int weight) {
        addVertex(source);
        addVertex(destination);

        adjacencyList.get(source).put(destination, weight);
        adjacencyList.get(destination).put(source, weight); // for undirected graph
    }


    public void removeEdge(T source, T destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(destination);
        }
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(source); // for undirected graph
        }
    }


    public Map<T, Integer> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new HashMap<>());
    }

    public int findMST() {

        PriorityQueue<Edge<T>> edgeQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));


        for (T source : adjacencyList.keySet()) {
            for (Map.Entry<T, Integer> entry : adjacencyList.get(source).entrySet()) {
                T destination = entry.getKey();
                int weight = entry.getValue();
                edgeQueue.add(new Edge<>(source, destination, weight));
            }
        }


        UnionFind<T> uf = new UnionFind<>(adjacencyList.keySet());

        int totalCost = 0;
        int edgesUsed = 0;

        while (!edgeQueue.isEmpty() && edgesUsed < adjacencyList.size() - 1) {
            Edge<T> edge = edgeQueue.poll();
            if (uf.union(edge.source, edge.destination)) {
                totalCost += edge.weight;
                edgesUsed++;
            }
        }

        return edgesUsed == adjacencyList.size() - 1 ? totalCost : -1;
    }

    static class Edge<T> {
        T source, destination;
        int weight;

        public Edge(T source, T destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class UnionFind<T> {
        private Map<T, T> parent;

        public UnionFind(Set<T> vertices) {
            parent = new HashMap<>();
            for (T vertex : vertices) {
                parent.put(vertex, vertex);
            }
        }

        public T find(T vertex) {
            if (!parent.get(vertex).equals(vertex)) {
                parent.put(vertex, find(parent.get(vertex)));
            }
            return parent.get(vertex);
        }

        public boolean union(T vertex1, T vertex2) {
            T root1 = find(vertex1);
            T root2 = find(vertex2);

            if (!root1.equals(root2)) {
                parent.put(root1, root2);
                return true;
            }
            return false;
        }
    }
}