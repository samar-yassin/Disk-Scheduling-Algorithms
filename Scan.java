import java.util.ArrayList;
import java.util.Collections;

public class Scan {
	static ArrayList<Integer> requests = new ArrayList<Integer>();
	static ArrayList<Integer> sequence = new ArrayList<Integer>();
	static int head, index, totalMovement, direction;
	
	public static int calculateTotalSeekTime(ArrayList<Integer> _requests, int headStart, int _direction) {
		totalMovement = 0;
		head = headStart;
		requests = _requests;
		direction = _direction;
		Collections.sort(requests);
		if (direction == 1) {
			for (int i = 0; i < requests.size(); i++) {
				if (requests.get(i) >= head) {
					index = i;
					break;
				}
			}
		} else {
			for (int i = requests.size() - 1; i >= 0; i--) {
				if (requests.get(i) <= head) {
					index = i;
					break;
				}
			}
		}
		return schedule();
	}
	
	public static int schedule() {
		int increment, end;
		if (direction == 1) {
			increment = 1;
			end = -1;
			totalMovement = (200 - head) + (200 - requests.get(0));
		} else {
			increment = -1;
			end = requests.size();
			totalMovement = head + requests.get(requests.size()-1);
		}
		sequence.clear();
		System.out.println("Sequence:");
		for (int i = index; i != end; i+=increment) {
			sequence.add(requests.get(i));
			System.out.print( requests.get(i) + " ");
			if (direction == 1) {
				if (i == requests.size() - 1) {
					i = index;
					increment = -1;
				}
			} else {
				if (i == 0) {
					i = index;
					increment = 1;
				}
			}
		}
		System.out.println();
		return totalMovement;
	}
	
	public static ArrayList<Integer> getSequence() {
		return sequence;
	}
}
