import java.util.ArrayList;

public class Graph {
    ArrayList<ArrayList<Node>> adj_list;
    int num_of_stations;
    public Graph(int n) {
        this.num_of_stations = n;
        adj_list = new ArrayList<>();
        for (int i = 0 ; i < num_of_stations ; ++i) {
            adj_list.add(new ArrayList<Node>());
        }
    }

    public void insert_stations(int number, int capacity) {
        adj_list.get(number).add(new Node(number, number, capacity));
    }

    public void insert_routes(int source_station, int destination_station, int capacity) {
        adj_list.get(source_station).add(adj_list.get(destination_station).get(0));
    }

    public void insert_train(int train_number) {
        Train train = new Train(train_number);
        train.insert_path();
    }

    public void print_graph() {
        for (int i = 0 ; i < num_of_stations ; ++i) {
            System.out.print("Station " + i + " has capacity " + adj_list.get(i).get(0).capacity + " and is connected to stations: ");
            for (int j = 0 ; j < adj_list.get(i).size() ; ++j) {
                System.out.print(adj_list.get(i).get(j).source + ", ");
            }
            System.out.println();
        }
    }
}