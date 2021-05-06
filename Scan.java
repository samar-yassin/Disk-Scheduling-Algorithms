import java.util.ArrayList;
import java.util.Collections;

public class Scan {
	ArrayList<Integer> requests = new ArrayList<Integer>();
	int head, index, totalMovement;
	
	public Scan(ArrayList<Integer> requests, int headStart) {
		this.totalMovement = 0;
		this.head = headStart;
		this.requests = requests;
		Collections.sort(requests);
		for (int i = requests.size() - 1; i >= 0; i--) {
			if (requests.get(i) <= head) {
				index = i;
				break;
			}
		}
	}
	
	public void schedule() {
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
		System.out.println();
		System.out.println("Total Head Movements: " + totalMovement);
		System.out.println();
	}
}
