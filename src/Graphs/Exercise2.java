package Graphs;
import java.util.*;

//Дадени се градови и патишта кои постојат помеѓу нив. Дел од патиштата се поплавени
//и не може да се користат, што може да доведе до тоа градовите да се поделат на групи што не се меѓусебно поврзани. Секој град од една група е поврзан со барем еден друг град од групата преку достапни (непоплавени) патишта, а не е поврзан со градови надвор од групата. Да се одреди колку вакви групи ќе има во случај на поплава.
//Влез: Во првиот ред е даден бројот на патишта M. Во следните M редови се дадени
//градовите кои ги поврзува секој пат. Потоа е даден бројот k на поплавени патишта,
//а во следните k редови се дадени поплавените патишта.
//Излез:  Бројот на групи на градови кои ќе останат меѓусебно поврзани.
//Пример:
//Влез:
//        6
//London Paris
//Paris Brussels
//Brussels Amsterdam
//London Brussels
//Paris Berlin
//Berlin Warsaw
//2
//Paris Berlin
//London Brussels
//Излез: 2 (Објаснување: Ако не може да се користат патиштата Paris-Berlin и London-Brussels,
//градовите ќе се поделат во две групи: {London, Paris, Brussels, Amsterdam} и {Berlin, Warsaw})
//
//        /
//Given cities and roads that exist between them, some roads are flooded and cannot
//be used. This may cause the cities to split into groups that are no longer connected.
//Each city in a group is connected to at least one other city in the same group via accessible (non-flooded) roads and is not connected to cities outside the group. Determine how many such groups will exist in the event of a flood.
//Input: The first line contains the number of roads M. The next M lines specify
//the cities connected with each road. In the next line, you're given the number of flooded roads k,
//followed by k lines which give the flooded roads.
//Output: The number of groups of still connected cities.
//Example:
//Input:
//        6
//London Paris
//Paris Brussels
//Brussels Amsterdam
//London Brussels
//Paris Berlin
//Berlin Warsaw
//2
//Paris Berlin
//London Brussels
//Output: 2 (Explanation: If the roads Paris-Berlin and London-Brussels can't be used,
//the cities will be split into two groups: {London, Paris, Brussels, Amsterdam} and {Berlin, Warsaw}.)

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AdjacencyListGraph2<String> graph = new AdjacencyListGraph2<>();
        int n = input.nextInt();
        List<String> site = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String prv = input.next();
            String vtor = input.next();
            graph.addEdge(prv, vtor);
            site.add(prv);
            site.add(vtor);
        }
        int k = input.nextInt();
        for (int i = 0; i < k; i++) {
            graph.removeEdge(input.next(), input.next());
        }
        Set<String> visited = new HashSet<>();
        int rez = 0;
        for (String startVertex : site) {
            if (visited.contains(startVertex)) continue;
            rez++;
            funkcija(graph, startVertex, visited);
        }


        System.out.println(rez);

    }

    public static void funkcija(AdjacencyListGraph2<String> graph, String vertex, Set<String> visited) {
        visited.add(vertex);
        for (String neighbor : graph.getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                funkcija(graph, neighbor, visited);
            }
        }
    }

}

class AdjacencyListGraph2<T> {
    Map<T, Set<T>> adjacencyList;

    public AdjacencyListGraph2() {
        this.adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
        }
    }

    // Remove a vertex from the graph
    public void removeVertex(T vertex) {
        // Remove the vertex from all adjacency lists
        for (Set<T> neighbors : adjacencyList.values()) {
            neighbors.remove(vertex);
        }
        // Remove the vertex's own entry in the adjacency list
        adjacencyList.remove(vertex);
    }

    // Add an edge to the graph
    public void addEdge(T source, T destination) {
        addVertex(source);
        addVertex(destination);

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // for undirected graph
    }

    // Remove an edge from the graph
    public void removeEdge(T source, T destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(destination);
        }
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(source); // for undirected graph
        }
    }

    // Get all neighbors of a vertex
    public Set<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }

    public void DFS(T startVertex) {
        Set<T> visited = new HashSet<>();
        DFSUtil(startVertex, visited);
    }

    private void DFSUtil(T vertex, Set<T> visited) {
        // Mark the current node as visited and print it
        visited.add(vertex);
        System.out.print(vertex + " ");

        // Recur for all the vertices adjacent to this vertex
        for (T neighbor : getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                DFSUtil(neighbor, visited);
            }
        }
    }


    public void DFSNonRecursive(T startVertex) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        stack.push(startVertex);
        while (!stack.isEmpty()) {
            T vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.print(vertex + " ");
                for (T neighbor : getNeighbors(vertex)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public void BFS(T startVertex) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            T vertex = queue.poll();
            System.out.print(vertex + " ");

            for (T neighbor : getNeighbors(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public int shortestPath(T startVertex, T endVertex) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);
        int elementsAtLevel;
        int level = 0;

        while (!queue.isEmpty()) {
            elementsAtLevel = queue.size();
            while (elementsAtLevel > 0) {
                T vertex = queue.poll();
                if (vertex.equals(endVertex))
                    return level;

                for (T neighbor : getNeighbors(vertex)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
                elementsAtLevel--;
            }
            level++;
        }
        return -1;
    }

    public void pathsOfLengthN(T startVertex, int goalLength) {
        Set<T> visited = new HashSet<>();
        ArrayList<T> startPath = new ArrayList<>();
        startPath.add(startVertex);
        pathsOfLengthNUtil(startVertex, goalLength, visited, startPath);
    }

    private void pathsOfLengthNUtil(T vertex, int goalLength, Set<T> visited, List<T> currentPath) {
        if (currentPath.size()==goalLength+1) {
            System.out.println(currentPath);
            return;
        }
        visited.add(vertex);
        for (T neighbor : getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                currentPath.add(neighbor);
                pathsOfLengthNUtil(neighbor, goalLength, visited, currentPath);
                currentPath.remove(neighbor);
            }
        }
        visited.remove(vertex);
    }


    public void findPath(T startVertex, T endVertex) {
        Set<T> visited = new HashSet<>();
        Stack<T> invertedPath = new Stack<>();
        visited.add(startVertex);
        invertedPath.push(startVertex);

        while(!invertedPath.isEmpty() && !invertedPath.peek().equals(endVertex)) {
            T currentVertex = invertedPath.peek();
            T tmp = currentVertex;

            for(T vertex : getNeighbors(currentVertex)) {
                tmp = vertex;
                if(!visited.contains(vertex)) {
                    break;
                }
            }

            if(!visited.contains(tmp)) {
                visited.add(tmp);
                invertedPath.push(tmp);
            }
            else {
                invertedPath.pop();
            }
        }

        Stack<T> path = new Stack<>();
        while(!invertedPath.isEmpty()) {
            path.push(invertedPath.pop());
        }
        while(!path.isEmpty()) {
            System.out.println(path.pop());
        }
    }

    @Override
    public String toString() {
        String ret = new String();
        for (Map.Entry<T, Set<T>> vertex : adjacencyList.entrySet())
            ret += vertex.getKey() + ": " + vertex.getValue() + "\n";
        return ret;
    }



}
