public class Path {
    int train_number;
    int source_station;
    int destination_station;
    String start_time;
    String end_time;

    public Path(int train_number, int source_station, int destination_station, String start_time, String end_time) {
        this.train_number = train_number;
        this.source_station = source_station;
        this.destination_station = destination_station;
        this.start_time = start_time;
        this.end_time = end_time;
    }
}
