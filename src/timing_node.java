public class timing_node {
    int start_time;
    int end_time;
    Train train;

    public timing_node(int start_time, int end_time, Train train) {
        this.train = train;
        this.start_time = start_time;
        this.end_time = end_time;
    }
}
