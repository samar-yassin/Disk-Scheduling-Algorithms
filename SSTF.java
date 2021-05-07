import java.util.ArrayList;
import java.util.Arrays;

public class SSTF {
	public static int calculateTotalSeekTime(ArrayList<Integer> arr, int head){
		int currentTrack, finished = 0, diff = 1000, j = 0, totalSeekTime = 0, len = arr.size();
		boolean[] done = new boolean[len];
		Arrays.fill(done, Boolean.FALSE);
		while (finished != len){
			for (int i = 0; i < len; i++){
				currentTrack = arr.get(i);
				if (Math.abs(currentTrack - head) < diff && !done[i]){
					diff = Math.abs(currentTrack - head);
					j = i;
				}
			}
			totalSeekTime += Math.abs(head - arr.get(j));
			done[j] = true;
			head = arr.get(j);
			finished++;
			diff = 1000;
		}
		return totalSeekTime;
	}
}
