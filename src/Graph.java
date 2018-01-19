import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph{
    ArrayList<ArrayList<Node>> adj_list;
    ArrayList<edge_node> edges = new ArrayList<>();
    public static ArrayList<Train> trains = new ArrayList<>();
    HashMap<String, edge_node> lookuptable = new HashMap<>();
    static HashMap<String, Node> lookuptable2 = new HashMap<>();
    int num_of_stations;
    public Graph(int n) {
        this.num_of_stations = n;
        adj_list = new ArrayList<>();
        for (int i = 0 ; i < num_of_stations ; ++i) {
            adj_list.add(new ArrayList<>());
        }
    }

    public void insert_stations(int number, int capacity) {
        Node temp = new Node(number, number, capacity);
        adj_list.get(number).add(temp);
        lookuptable2.put(String.valueOf(number), temp);
    }

    public void insert_routes(int source_station, int destination_station, int capacity) {
        adj_list.get(source_station).add(adj_list.get(destination_station).get(0));
        edge_node temp = new edge_node(source_station, destination_station, capacity);
        edges.add(temp);
        lookuptable.put(String.valueOf(source_station) + " " + String.valueOf(destination_station), temp);
    }

    public void insert_train(int train_number) throws IOException {
        Train train = new Train(train_number);
        train.insert_path();
        trains.add(train);
    }

    public void run_simulation() {
        for (int i = 0 ; i < trains.size() ; ++i) {
            if (i == 0) {
                for (int j = 0 ; j < trains.get(i).paths.size() ; ++j) {
                    edge_node edge = lookuptable.get(String.valueOf(trains.get(i).paths.get(j).source_station) + " " + String.valueOf(trains.get(i).paths.get(j).destination_station));
                    Node node = lookuptable2.get(String.valueOf(trains.get(i).paths.get(j).destination_station));
                    edge.add_time(trains.get(i).paths.get(j), trains.get(i));
                    if (j != trains.get(i).paths.size() - 1) {
                        node.add_time(trains.get(i).paths.get(j), trains.get(i).paths.get(j + 1), trains.get(i));
                    }
                }
            } else {
                for (int j = 0 ; j < trains.get(i).paths.size() ; ++j) {
                    edge_node edge = lookuptable.get(String.valueOf(trains.get(i).paths.get(j).source_station) + " " + String.valueOf(trains.get(i).paths.get(j).destination_station));
                    Node node = lookuptable2.get(String.valueOf(trains.get(i).paths.get(j).destination_station));
                    for (int l = 0; l < edge.times_on_path.size(); ++l) {
                        int num_of_clashes = 1;
                        if (check_clash(edge.times_on_path.get(l).start_time, trains.get(i).paths.get(j).start_time, edge.times_on_path.get(l).end_time, trains.get(i).paths.get(j).end_time)) {
                            num_of_clashes+=1;
                            if (num_of_clashes > edge.capacity)
                            {
                                int delay = edge.free_at - trains.get(i).paths.get(j).start_time;
                                trains.get(i).total_delay += delay;
                                trains.get(i).paths.get(j).start_time = edge.free_at;
                                trains.get(i).paths.get(j).end_time += delay;
                                if (j < trains.get(i).paths.size() - 1)
                                    update_times(delay, i, j + 1);
                                break;
                            }
                        }
                    }
                    edge.add_time(trains.get(i).paths.get(j), trains.get(i));
                    if (j != trains.get(i).paths.size() - 1) {
                        int num_of_clashes = 1;
                        for (int l = 0; l < node.times_at_station.size(); ++l) {
                            if (check_clash(trains.get(i).paths.get(j).end_time, node.times_at_station.get(l).start_time, trains.get(i).paths.get(j + 1).start_time, node.times_at_station.get(l).end_time)){
                                num_of_clashes += 1;
                                //System.out.println("hello " + trains.get(i));
                                if (num_of_clashes > node.capacity) {
                                    int delay = node.free_at - trains.get(i).paths.get(j).end_time;
                                    trains.get(i).total_delay += delay;
                                    trains.get(i).paths.get(j).end_time = node.free_at;
                                    if (j < trains.get(i).paths.size() - 1)
                                        update_times(delay, i, j + 1);
                                    break;
                                }
                            }
                        }
                        node.add_time(trains.get(i).paths.get(j), trains.get(i).paths.get(j + 1), trains.get(i));
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
        return (((start_1 <= start_2 && start_2 < end_1) || (end_2 < end_1 && end_2 > start_1)) || ((start_2 <= start_1 && start_1 < end_2) || (end_1 < end_2 && end_1 > start_2)));
    }

    public void update_times(int delay, int i, int j) {
        for (int k = j ; k < trains.get(i).paths.size() ; ++k) {
            trains.get(i).paths.get(k).start_time += delay;
            trains.get(i).paths.get(k).end_time += delay;
        }
    }
}