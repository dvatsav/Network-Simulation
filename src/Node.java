import java.util.ArrayList;
import java.util.PriorityQueue;

public class Node {
    Node link;
    int source;
    int destination;
    int capacity;
    int free_at = 0;
    boolean full = false;
    PriorityQueue<Node> waitlist = new PriorityQueue<>();
    ArrayList<timing_node> times_at_station = new ArrayList<>();

    public Node(int source, int destination, int capacity) {
        this.link = null;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
    }

    public void add_time(Path path1, Path path2, Train train) {
        times_at_station.add(new timing_node(path1.end_time, path2.start_time, train));
        if (path2.start_time > free_at) {
            free_at = path2.start_time;
            System.out.println("free at " + free_at);
        }
    }

}
