import java.util.ArrayList;
import java.util.Collections;

public class Look {
	static ArrayList<Integer> requests = new ArrayList<Integer>();
	static ArrayList<Integer> sequence = new ArrayList<Integer>();
	static int head, index, totalMovement;

	public static int calculateTotalSeekTime(ArrayList<Integer> _requests, int headStart) {
		totalMovement = 0;
		head = headStart;
		requests = _requests;
		Collections.sort(requests);
		for (int i = requests.size() - 1; i >= 0; i--) {
			if (requests.get(i) <= head) {
				index = i;
				break;
			}
		}
		return schedule();
	}

	public static int schedule() {
		int increment = -1;
		sequence.clear();
		totalMovement = (head - requests.get(0)) + (requests.get(requests.size()-1) - requests.get(0));
		System.out.println("Sequence:");
		for (int i = index; i != requests.size(); i+=increment) {
			sequence.add(requests.get(i));
			System.out.print( requests.get(i) + " ");
			if (i == 0) {
				i = index;
				increment = 1;
			}
		}
		System.out.println();
		return totalMovement;
	}
	
	public static ArrayList<Integer> getSequence() {
		return sequence;
	}
}