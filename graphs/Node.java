import java.util.List;
import java.util.ArrayList;

public class Node {
    String name;
    List<Node> neighbours;
    boolean isMangoSeller;

    public Node(String name, boolean status) {
        this.name = name;
        neighbours = new ArrayList<>();
        isMangoSeller = status;
    }


    public void addNode(Node... node) {
        if(node.length == 1) {
            neighbours.add(node[0]);
        } else if(node.length > 1) {
            for(Node n: node)
                neighbours.add(n);
        }
    }


}

