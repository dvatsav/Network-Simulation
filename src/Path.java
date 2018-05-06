public class Path {
    int train_number;
    int source_station;
    int destination_station;
    int start_time;
    int end_time;

    public Path(int train_number, int source_station, int destination_station, int start_time, int end_time) {
        this.train_number = train_number;
        this.source_station = source_station;
        this.destination_station = destination_station;
        this.start_time = start_time;
        this.end_time = end_time;
    }


    public String toString() {
        return "source station: " + Integer.toString(source_station) + ", destination station: " + Integer.toString(destination_station) + ", starting at: " + start_time + ", ending at: " + end_time + "\n";
    }
}
