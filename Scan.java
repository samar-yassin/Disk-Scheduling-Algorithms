import java.util.ArrayList;

public class Scan {
	ArrayList<Integer> requests = new ArrayList<Integer>();
	int head, index, totalMovement;
	
	public Scan(ArrayList<Integer> requests, int headStart) {
		this.totalMovement = 0;
		this.head = headStart;
		this.requests = requests;
		sortRequests();
		totalMovement = head + requests.get(requests.size()-1);
	}
	
	void sortRequests() {
		int temp;
		for (int i = 0; i < requests.size(); i++) {
			for (int j = 0; j < requests.size() - 1; j++) {
				if (requests.get(j) > requests.get(j + 1)) {
					temp = requests.get(j);
					requests.set(j, requests.get(j+1));
					requests.set(j+1, temp);
				}
			}
		}
		for (int i = requests.size() - 1; i >= 0; i--) {
			if (requests.get(i) <= head) {
				index = i;
				break;
			}
		}
	}
	
	/*public void schedule() {
		int val = -1;
		System.out.println("Sequence:");
		for (int i = head; i < 200; i+= val) {
			totalMovement++;
			//System.out.println("i: " + i + " request: " + requests.get(index));
			if (i == requests.get(index)) {
				System.out.print(requests.get(index) + " ");
				requests.remove(index);
				
				if (index != 0)
					index += val;
			}
			if (i == 0) {
				val = 1;
			}
			if (requests.size() == 0) {
				break;
			}
		}
		System.out.println();
		System.out.println("Total Head Movements: " + --totalMovement);
		System.out.println();
	}*/
	
	public void schedule() {
		int increment = -1;
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
