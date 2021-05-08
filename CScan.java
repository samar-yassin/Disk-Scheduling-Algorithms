import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CScan {
	static ArrayList<Integer> sequence = new ArrayList<Integer>();


	public static int calculateTotalSeekTime(ArrayList<Integer> Requests, int headstart, int direction){
		sequence.clear();

		System.out.println("CScan ALGORITHM");
		System.out.println("the sequence of head movement :");

		int seekTrack;
		int totalHeadMovement=0;
		int head=headstart;
		Requests.add(0);
		Requests.add(200);
		Collections.sort(Requests);

		if(direction==1) {
			for (int i = 0; i < Requests.size(); i++) {
				seekTrack = Requests.get(i);
				sequence.add(seekTrack);

				if (seekTrack >= headstart) {
					System.out.print(seekTrack + " ");
					totalHeadMovement += Math.abs(seekTrack - head);
					head = seekTrack;
				}
			}
			head = 0;
			totalHeadMovement += 200;
			for (int i = 0; i < Requests.size(); i++) {
				seekTrack = Requests.get(i);
				sequence.add(seekTrack);

				if (seekTrack < headstart) {
					System.out.print(seekTrack + " ");
					totalHeadMovement += Math.abs(seekTrack - head);
					head = seekTrack;
				}
			}
		}
		else if(direction==2) {
			for (int i = Requests.size()-1; i>=0; i--) {
				seekTrack = Requests.get(i);
				sequence.add(seekTrack);

				if (seekTrack <= headstart) {
					System.out.print(seekTrack + " ");
					totalHeadMovement += Math.abs(seekTrack - head);
					head = seekTrack;
				}
			}
			head = 200;
			totalHeadMovement += 200;
			for (int i = Requests.size()-1; i>=0; i--) {
				seekTrack = Requests.get(i);
				sequence.add(seekTrack);
				if (seekTrack > headstart) {
					System.out.print(seekTrack + " ");
					totalHeadMovement += Math.abs(seekTrack - head);
					head = seekTrack;
				}
			}
		}
			return totalHeadMovement;
	}
	public static ArrayList<Integer> getSequence() {
		return sequence;
	}
}
