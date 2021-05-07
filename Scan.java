import java.util.ArrayList;
import java.util.Collections;

public class Scan {
	static ArrayList<Integer> requests = new ArrayList<Integer>();
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
		totalMovement = head + requests.get(requests.size()-1);
		System.out.println("Sequence:");
		while (requests.size() > 0) {
			head = requests.get(index);
			System.out.print(requests.get(index) + " ");
			requests.remove(index);
			if (index == 0) {
				index = -1;
				increment = 1;
			}
			index += increment;
		}
		return totalMovement;
	}
}
