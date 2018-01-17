import java.util.*;

public class simulator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter number of stations: ");
		int num_of_stations = 5; //sc.nextInt();
		Graph g = new Graph(num_of_stations);

		g.insert_stations(0, 1);
		g.insert_stations(1, 1);
		g.insert_stations(2, 2);
		g.insert_stations(3, 1);
		g.insert_stations(4, 1);
	   
		g.insert_routes(0, 1, 1);
		g.insert_routes(0, 4, 1);
		g.insert_routes(0, 3, 1);
		g.insert_routes(1, 2, 2);
		g.insert_routes(3, 1, 1);
		g.insert_routes(2, 4, 1);
		
		g.insert_train(0);
		g.insert_train(1);
		
		g.run_simulation();
		g.print_trains();

	}
}