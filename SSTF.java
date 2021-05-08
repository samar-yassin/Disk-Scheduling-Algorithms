import java.util.ArrayList;
import java.util.Arrays;

public class SSTF {
	
	static ArrayList<Integer> sequence = new ArrayList<Integer>();
	
	public static int calculateTotalSeekTime(ArrayList<Integer> requests, int head){
		/* 
		 * 1- while finished isn't equal the size of the queue, there's still a request to be processed
		 * 2- each time we get the request with the minimum seek time difference from the head and process it
		 * 3- repeat -2- until all the requests been processed 
		 * */
		sequence.clear();
		int currentTrack, finished = 0, diff = 1000, j = 0, totalSeekTime = 0, size = requests.size();
		boolean[] done = new boolean[size];
		Arrays.fill(done, Boolean.FALSE);
		System.out.print("The sequence of head movement: ");
		while (finished != size){
			for (int i = 0; i < size; i++){
				currentTrack = requests.get(i);
				// get the request with the minimum seek time difference from the current track (head)
				if (Math.abs(currentTrack - head) < diff && !done[i]){
					diff = Math.abs(currentTrack - head);
					j = i;
				}
			}
			sequence.add(requests.get(j));
			System.out.print(requests.get(j) + " ");
			totalSeekTime += Math.abs(head - requests.get(j));
			done[j] = true;
			head = requests.get(j);
			finished++;
			diff = 1000;
		}
		System.out.println();
		return totalSeekTime;
	}
	
	public static ArrayList<Integer> getSequence() {
		return sequence;
	}
}
