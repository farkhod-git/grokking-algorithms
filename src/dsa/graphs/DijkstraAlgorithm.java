package dsa.graphs;

import java.util.*;

public class DijkstraAlgorithm {
    private static class NodeCost {
        String node;
        int cost;

        public NodeCost(String node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public String toString() {
            return node + " <> " + cost;
        }
    }

    static void t() {
        List<int[]>[] lists = new List[10];
        lists[0] = new ArrayList<>();
    }

    static void main() {
        findShortestPathInWeightedGraph(new String[][]{
                {"Start", "A", "6"},
                {"Start", "B", "2"},
                {"A", "Finish", "1"},
                {"B", "A", "3"},
                {"B", "Finish", "5"}
        }, "Start", "Finish");
        System.out.println("----------------");

        findShortestPathInWeightedGraph(new String[][]{
                {"Book", "LP", "5"},
                {"Book", "Poster", "0"},
                {"LP", "Guitar", "15"},
                {"LP", "Drum", "20"},
                {"Poster", "Guitar", "30"},
                {"Poster", "Drum", "35"},
                {"Guitar", "Piano", "20"},
                {"Drum", "Piano", "10"}
        }, "Book", "Piano");


    }

    private static void findShortestPathInWeightedGraph(String[][] edges, String START, String FINISH) {
        Map<String, Map<String, Integer>> graph = toGraph(edges);
        Queue<NodeCost> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        Map<String, Integer> costs = new LinkedHashMap<>();
        Map<String, String> parents = new LinkedHashMap<>();

        pq.offer(new NodeCost(START, 0));
        costs.put(START, 0);

        while (!pq.isEmpty()) {
            //System.out.println(pq);
            //System.out.println(costs);
            NodeCost minCostNode = pq.poll();

            if (minCostNode.node.equals(FINISH))
                break;

            if (minCostNode.cost != costs.get(minCostNode.node))
                continue;

            Map<String, Integer> neighbors = graph.get(minCostNode.node);
            for (var neighbor : neighbors.entrySet()) {
                String k = neighbor.getKey();
                int v = neighbor.getValue();
                int newCost = minCostNode.cost + v;

                if (costs.containsKey(k)) {
                    if (costs.get(k) > newCost) {
                        costs.put(k, newCost);
                        parents.put(k, minCostNode.node);
                        pq.add(new NodeCost(k, newCost));
                    }
                } else {
                    costs.put(k, newCost);
                    parents.put(k, minCostNode.node);
                    pq.add(new NodeCost(k, newCost));
                }
            }
        }

        //System.out.println(costs);
        System.out.printf("Minimal cost from [%s] to [%s] is [%s]%n", START, FINISH, costs.get(FINISH));
        System.out.println("Path for minimal cost");

        StringBuilder sb = new StringBuilder();
        String k = FINISH;
        while (k != null) {
            sb.insert(0, k + " -> ");
            k = parents.get(k);
        }
        System.out.println(sb.delete(sb.length() - 4, sb.length()));
    }

    private static Map<String, Map<String, Integer>> toGraph(String[][] edges) {
        Map<String, Map<String, Integer>> graph = new LinkedHashMap<>();
        for (String[] edge : edges) {
            String from = edge[0];
            String to = edge[1];
            int weight = Integer.parseInt(edge[2]);
            graph.computeIfAbsent(from, _ -> new LinkedHashMap<>()).put(to, weight);
        }
        return graph;
    }
}
