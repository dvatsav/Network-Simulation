import java.util.ArrayList;

public class edge_node {
    int source_station;
    int destination_station;
    int free_at = 0;
    int capacity = 0;
    ArrayList<timing_node> times_on_path = new ArrayList<>();

    public edge_node(int source_station, int destination_station, int capacity) {
        this.source_station = source_station;
        this.destination_station = destination_station;
        this.capacity = capacity;
    }

    public void add_time(Path path, Train train) {
        times_on_path.add(new timing_node(path.start_time, path.end_time, train));
        if (path.end_time > free_at) {
            free_at = path.end_time;
        }
    }
}
