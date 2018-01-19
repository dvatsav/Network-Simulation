import java.io.IOException;
import java.util.*;

public class simulator {
	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		//System.out.println("Enter number of stations: ");
		int num_of_stations = Reader.nextInt(); //sc.nextInt();
		Graph g = new Graph(num_of_stations);

		for (int i = 0 ; i < num_of_stations ; ++i)
		{
			int station_number = Reader.nextInt();
			int capacity = Reader.nextInt();
			g.insert_stations(station_number, capacity);
		}
		/*
		g.insert_stations(0, 1);
		g.insert_stations(1, 1);
		g.insert_stations(2, 2);
		g.insert_stations(3, 1);
		g.insert_stations(4, 1);
	    */

		int num_of_routes = Reader.nextInt();
		for (int i = 0 ; i < num_of_routes ; ++i)
		{
			int source_station = Reader.nextInt();
			int dest_station = Reader.nextInt();
			int capacity = Reader.nextInt();
			g.insert_routes(source_station, dest_station, capacity);
			g.insert_routes(dest_station, source_station, capacity);
		}
		/*
		g.insert_routes(0, 1, 1);
		g.insert_routes(0, 4, 1);
		g.insert_routes(0, 3, 1);
		g.insert_routes(1, 2, 2);
		g.insert_routes(3, 1, 1);
		g.insert_routes(2, 4, 1);
		*/

		int num_of_trains = Reader.nextInt();
		for (int i = 0 ; i < num_of_trains ; ++i)
		{
			g.insert_train(i);
		}
		/*
		g.insert_train(0);
		g.insert_train(1);
		*/
		g.run_simulation();
		g.print_trains();

	}
}