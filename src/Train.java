import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Train {
    int number;
    int current_station;
    int total_delay = 0;
    ArrayList<Path> paths = new ArrayList<>();
    public Train(int number) {
        this.number = number;
    }

    public void insert_path() throws IOException {
        //System.out.print("How many paths in between?:");
        //Scanner sc = new Scanner(System.in);
        int total_paths = Reader.nextInt();
        for (int i = 0 ; i < total_paths ; ++i) {
            //System.out.println("Enter details in the following format: Start_station_number End_station_number start_time end_time");

            int start_station = Reader.nextInt();
            int end_station = Reader.nextInt();
            int start_time = time_convert(Reader.next());
            int end_time = time_convert(Reader.next());
            //System.out.println(start_time + " " + end_time);

            Path path = new Path(this.number, start_station, end_station, start_time, end_time);

            this.paths.add(path);
            if (this.paths.size() == 1) {
                this.current_station = start_station;
            }
        }
    }

    public String toString() {
        String pathstring = "";
        for (Path path : paths) {
            pathstring += path;
        }
        return "Train number: " + Integer.toString(number) + "\n " + pathstring + "Total delay for train is=: " + Integer.toString(total_delay) + "\n\n";
    }

    public int time_convert(String t) {
        String[] components = t.split(":");
        return Integer.parseInt(components[0]) * 60 + Integer.parseInt(components[1]);
    }
}
