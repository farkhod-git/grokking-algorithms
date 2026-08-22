package dsa.graphs;

import java.util.*;

public class FindingMangoSeller {
    static void main() {
        // Network of friends

        Map<String, List<String>> graph = new HashMap<>();
        // you know Alice, Bob, Claire (but no one of them knows you)
        graph.put("you", List.of("alice", "bob", "claire"));
        // bob knows Anuj, Peggy (but no one of them knows bob)
        graph.put("bob", List.of("anuj", "peggy"));
        // alice knows Peggy (bob knows peggy too)
        // ...
        graph.put("alice", List.of("peggy"));
        graph.put("claire", List.of("thom", "jonny"));
        graph.put("anuj", List.of());
        graph.put("peggy", List.of());
        graph.put("thom", List.of());
        graph.put("jonny", List.of());



        // BFS (Breadth First Search)

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>(graph.get("you"));

        while (!queue.isEmpty()) {
            String person = queue.remove();
            if (!visited.contains(person)) {
                visited.add(person);
                if (person.endsWith("m")) {
                    System.out.println(person + " is a mango seller!");
                    return;
                }
                queue.addAll(graph.get(person));
            }
        }


    }
}
