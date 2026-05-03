import java.util.*;

public class DijkstrasAlgorithm {
    
    static class Node {
        String name;
        int cost;

        public Node(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }
    }

    public static List<String> dijkstra(HashMap<String, HashMap<String, Integer>> graph, HashMap<String, Integer> costs, HashMap<String, String> parents){

        HashSet<String> visited = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        
        for(String k: costs.keySet())
            pq.add(new Node(k, costs.get(k)));

        while (!pq.isEmpty()) {
            Node lowestCostNode = pq.poll();
            String nodeName = lowestCostNode.name;
            int cost = lowestCostNode.cost;

            HashMap<String, Integer> neighbours = graph.get(nodeName);
            if (!visited.contains(nodeName)) {
                 visited.add(nodeName);

                 for(String n: neighbours.keySet()) {
                    int newCost = cost + neighbours.get(n);

                    if (costs.get(n) > newCost) {
                        costs.put(n, newCost);
                        parents.put(n, nodeName);
                        pq.add(new Node(n, newCost));
                    }
                 }
            }
           
        }

       List<String> path = new ArrayList<>();
       String current = "fin";

       while (current != null) {   
           path.add(current);
           current = parents.get(current);
       }

       Collections.reverse(path);
       return path;

    }


    public static void main(String[] args) {

        HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
        
        graph.put("start", new HashMap<String, Integer>());
        graph.put("a", new HashMap<String, Integer>());
        graph.put("b", new HashMap<String, Integer>());
        graph.put("fin", new HashMap<String, Integer>());

        graph.get("start").put("a", 6);
        graph.get("start").put("b", 2);
        graph.get("a").put("fin", 1);
        graph.get("b").put("a", 3);
        graph.get("b").put("fin", 5);
        
        HashMap<String, Integer> costs = new HashMap<>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", Integer.MAX_VALUE);

        LinkedHashMap<String, String> parents = new LinkedHashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);
        
        System.out.println("The path of the shortest distance is: " + dijkstra(graph, costs, parents));

    }
}




