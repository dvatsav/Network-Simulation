import java.io.IOException;
import java.util.*;

public class simulator {
	public static void refresh()
	{
		Graph.trains.clear();
	}



	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		for (int times = 0 ; times < 1 ; ++times)
		{
			int num_of_stations = Reader.nextInt();
			Graph g = new Graph(num_of_stations);

			for (int i = 0 ; i < num_of_stations ; ++i)
			{
				int station_number = Reader.nextInt();
				int capacity = Reader.nextInt();
				g.insert_stations(station_number, capacity);
			}

			int num_of_routes = Reader.nextInt();
			for (int i = 0 ; i < num_of_routes ; ++i)
			{
				int source_station = Reader.nextInt();
				int dest_station = Reader.nextInt();
				int capacity = Reader.nextInt();
				g.insert_routes(source_station, dest_station, capacity);
				g.insert_routes(dest_station, source_station, capacity);
			}

			int num_of_trains = Reader.nextInt();
			for (int i = 0 ; i < num_of_trains; ++i)
			{
				g.insert_train(i);
			}

			g.run_simulation();
			g.print_trains();
			refresh();
		}
		Collections.sort(Graph.finals, new Comparator<sortnodes>() {
			@Override
			public int compare(sortnodes o1, sortnodes o2) {
				return o1.total_delay - o2.total_delay;
			}
		});
		System.out.println(Graph.finals.get(0).trains);
		System.out.println(Graph.finals.get(0).total_delay);
	}
}