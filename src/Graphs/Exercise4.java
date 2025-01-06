package Graphs;
import java.util.*;

//Даден е проект што се состои од повеќе задачи. За секоја задача се потребни одреден број денови
//за да се заврши, а задчите може да се зависни од други задачи (не може да се почне со задача 2
//        пред да се зврши задача 1). Да се одреди колку најмалку денови ќе бидат потребни да се
//заврши целиот проект ако на независни задачи може да се работи паралелно.
//Влез: Во првиот ред е даден бројот на задачи N. Потоа во следните N редови се дадени
//задачите и времето што е потребно за завршување на секоја задача. Во следниот ред е даден
//бројот на зависности M, а потоа во следните M редови се дадени зависностите. (Задача2 Задача1 значи
//дека Задача2 зависи од Задача1).
//Излез:  Минималното време да се заврши целиот проект.
//Пример:
//Влез:
//5
//Task1 3
//Task2 5
//Task3 2
//Task4 7
//Task5 4
//2
//Task2 Task1
//Task4 Task3
//Излез: 9
//(Објаснување: задачите 1, 3 и 5 може да се почнат паралелно. По завршување на задача
//1, може да се почне задача 2, таа ќе се заврши за најмалку (5+3) 8 дена. Задача
//4 може да почне по завршување на задача 3 и за неа ќе бидат потребни најмалку (2 + 7) 9 дена.
//Затоа што задача 1 и 2 и задача 3 и 4 може да се извршуваат паралелно, а паралелно се извршува и
//задача 5, потребни се 9 дена за да се заврши целиот проект.)
//
//        /
//
//You're given a project that consists of multiple tasks. Each task takes a certain
//amount of days to complete, and tasks can be dependent on each other (can't start task
//2 before task 1 is completed). Determine the minimum number of days to complete the
//entire project if it's possible to work on independent tasks in parallel.
//Input: The first line contains the number of tasks N. The next N lines contain the names
//of the tasks and the time needed for each task. The next line contains the number of dependencies M,
//followed by M lines that contain the dependencies. (Task2 Task1 means that Task2 depends on Task1)
//Output: The minimum number of days to complete the project.
//Example:
//Input:
//5
//Task1 3
//Task2 5
//Task3 2
//Task4 7
//Task5 4
//2
//Task2 Task1
//Task4 Task3
//Output: 9
//(Explanation: tasks 1, 3 and 5 can be done in parallel. After task 1 is done, task 2 can be started,
//and will need at least (5+3) 8 days. Task 4 can start after task 3 and needs at least (2 + 7) 9 days.
//Because tasks 1 and 2 and tasks 3 and 4 can be done in parallel, and task 5 can also be done in parallel,
//it takes 9 days to complete the entire project.)

public class Exercise4 {

    public static int findMinimumTime(int n, Map<String, Integer> tasks, List<String[]> dependencies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, Integer> completionTime = new HashMap<>();

        for (String task : tasks.keySet()) {
            graph.put(task, new ArrayList<>());
            inDegree.put(task, 0);
            completionTime.put(task, tasks.get(task));
        }

        for (String[] dep : dependencies) {
            String dependent = dep[0];
            String prerequisite = dep[1];
            graph.get(prerequisite).add(dependent);
            inDegree.put(dependent, inDegree.get(dependent) + 1);
        }

        Queue<String> queue = new LinkedList<>();
        for (String task : tasks.keySet()) {
            if (inDegree.get(task) == 0) {
                queue.offer(task);
            }
        }

        int totalTime = 0;

        while (!queue.isEmpty()) {
            String task = queue.poll();
            int taskCompletionTime = completionTime.get(task);
            totalTime = Math.max(totalTime, taskCompletionTime);

            for (String dependent : graph.get(task)) {
                completionTime.put(dependent, Math.max(completionTime.get(dependent), taskCompletionTime + tasks.get(dependent)));
                inDegree.put(dependent, inDegree.get(dependent) - 1);
                if (inDegree.get(dependent) == 0) {
                    queue.offer(dependent);
                }
            }
        }

        return totalTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());  // Using trim() to remove extra spaces
        Map<String, Integer> tasks = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] taskInfo = scanner.nextLine().trim().split("\\s+");  // Ensuring no extra spaces
            tasks.put(taskInfo[0], Integer.parseInt(taskInfo[1]));
        }

        int m = Integer.parseInt(scanner.nextLine().trim());
        List<String[]> dependencies = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] dependency = scanner.nextLine().trim().split("\\s+");
            dependencies.add(dependency);
        }

        System.out.println(findMinimumTime(n, tasks, dependencies));
    }
}