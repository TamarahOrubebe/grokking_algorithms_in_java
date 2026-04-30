import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;


public class BreadthFirstSearch {
    public static boolean search(Node startNode) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        HashSet<Node> searched = new HashSet<>();

        queue.add(startNode);

        while(!queue.isEmpty()) {
            Node node = queue.remove();

            if(node.isMangoSeller == true) {
                System.out.println("" + node.name + " is the mango seller");
                return true;
            }
            for(Node n: node.neighbours)
                queue.add(n);
            searched.add(node);

        }
        System.out.println("There is no Mango seller amongst your connections"); 
        return false;
    }

    public static void main(String[] args) {
        
        Node startNode = new Node("you", false);
        Node alice = new Node("alice", false);
        Node bob = new Node("bob", false);
        Node claire = new Node("claire", false);

        // Bob's neighbours
        Node anuj = new Node("anuj", false);
        Node peggy = new Node("peggy", false);

        // Claire's neighbours
        Node thom = new Node("thom", false);
        Node johnny = new Node("johnny", true);

        startNode.addNode(alice, bob, claire);
        bob.addNode(anuj, peggy);
        alice.addNode(peggy);
        claire.addNode(thom, johnny);

        search(startNode);
    }

 }       



           
