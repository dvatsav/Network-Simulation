import java.util.ArrayList;

public class Graph{
    ArrayList<ArrayList<Node>> adj_list;
    ArrayList<edge_node> edges = new ArrayList<>();
    public static ArrayList<Train> trains = new ArrayList<>();
    int num_of_stations;
    public Graph(int n) {
        this.num_of_stations = n;
        adj_list = new ArrayList<>();
        for (int i = 0 ; i < num_of_stations ; ++i) {
            adj_list.add(new ArrayList<>());
        }
    }

    public void insert_stations(int number, int capacity) {
        adj_list.get(number).add(new Node(number, number, capacity));
    }

    public void insert_routes(int source_station, int destination_station, int capacity) {
        adj_list.get(source_station).add(adj_list.get(destination_station).get(0));
        edges.add(new edge_node(source_station, destination_station));
    }

    public void insert_train(int train_number) {
        Train train = new Train(train_number);
        train.insert_path();
        trains.add(train);
    }

    public void run_simulation() {
        for (int i = 0 ; i < trains.size() ; ++i) {
            if (i == 1) {
                for (int j = 0 ; j < trains.get(i).paths.size() ; ++j) {
                    for (edge_node edge : edges) {
                        if (trains.get(i).paths.get(j).source_station == edge.source_station && trains.get(i).paths.get(j).destination_station == edge.destination_station) {
                            edge.add_time(trains.get(i).paths.get(j), trains.get(i));
                        }
                    }
                }
            } else {
                for (int j = 0 ; j < trains.get(i).paths.size() ; ++j) {
                    for (edge_node edge : edges) {
                        if (trains.get(i).paths.get(j).source_station == edge.source_station && trains.get(i).paths.get(j).destination_station == edge.destination_station) {
                            for (int l = 0; l < edge.times_on_path.size(); ++l) {
                                if (check_clash(edge.times_on_path.get(l).start_time, trains.get(i).paths.get(j).start_time, edge.times_on_path.get(l).end_time, trains.get(i).paths.get(j).end_time)) {
                                    int delay = edge.free_at - trains.get(i).paths.get(j).start_time;
                                    trains.get(i).total_delay += delay;
                                    trains.get(i).paths.get(j).start_time = edge.free_at;
                                    trains.get(i).paths.get(j).end_time += delay;
                                    break;
                                }
                            }
                            edge.add_time(trains.get(i).paths.get(j), trains.get(i));
                        }
                    }
                }
            }
        }
    }

    public void print_trains() {
        for (Train train : trains) {
            System.out.println(train);
        }
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

    public boolean check_clash(int start_1, int start_2, int end_1, int end_2) {
        return (start_1 <= start_2 && start_2 <= end_2) || (end_2 < end_1 && end_2 > start_1);
    }
}