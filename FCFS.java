import java.util.ArrayList;

public class FCFS{
    public static int calculateTotalSeekTime(ArrayList<Integer> arr, int head) {
        int currentTrack, totalSeekTime = 0, len = arr.size();
        for (int i = 0; i < len; i++) {
            currentTrack = arr.get(i);
            totalSeekTime += Math.abs(currentTrack - head);
            head = currentTrack;
        }
        return totalSeekTime;
    }
}
