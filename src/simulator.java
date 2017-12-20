import java.util.*;

public class simulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter number of stations: ");
        int num_of_stations = 6; //sc.nextInt();
        Graph g = new Graph(num_of_stations);

        g.insert_stations(0, 1);
        g.insert_stations(1, 1);
        g.insert_stations(2, 1);
        g.insert_stations(3, 1);
        g.insert_stations(4, 1);
        g.insert_stations(5, 1);
        g.insert_routes(0, 1, 1);
        g.insert_routes(5, 4, 1);
        g.insert_routes(2, 3, 1);
        g.insert_routes(1, 5, 1);
        g.insert_routes(3, 4, 1);
        g.insert_routes(4, 3, 1);
        g.insert_routes(4, 0, 1);
        g.insert_routes(3, 1, 1);
        //g.print_graph();
        g.insert_train(0);
        g.insert_train(1);
        g.insert_train(2);
        g.run_simulation();
        g.print_trains();

    }
}