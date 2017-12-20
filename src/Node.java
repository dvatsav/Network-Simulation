import java.util.PriorityQueue;

public class Node {
    Node link;
    int source;
    int destination;
    int capacity;
    boolean full = false;
    PriorityQueue<Node> waitlist = new PriorityQueue<>();

    public Node(int source, int destination, int capacity) {
        this.link = null;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
    }

    public Node()
    {
        ;
    }
}
