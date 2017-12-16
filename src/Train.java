import java.util.ArrayList;
import java.util.Scanner;

public class Train {
    int number;
    int current_station;
    ArrayList<Path> paths = new ArrayList<>();
    public Train(int number) {
        this.number = number;
    }

    public void insert_path() {
        System.out.println("Enter details in the following format: Start_station_number End_station_number start_time end_time");
        Scanner sc = new Scanner(System.in);
        int start_station = sc.nextInt();
        int end_station = sc.nextInt();
        String start_time = sc.next();
        String end_time = sc.next();
        Path path = new Path(this.number, start_station, end_station, start_time, end_time);
        this.paths.add(path);
        if (this.paths.size() == 1) {
            this.current_station = start_station;
        }
    }

}
