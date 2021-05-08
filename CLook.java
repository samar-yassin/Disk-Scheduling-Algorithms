import java.util.ArrayList;
import java.util.Collections;

public class CLook {

	static ArrayList<Integer> sequence = new ArrayList<Integer>();
	
	public static int calculateTotalSeekTime(ArrayList<Integer> Requests, int head){
		sequence.clear();
		ArrayList<Integer>left = new ArrayList<Integer>() ,  right=new ArrayList<Integer>();
		int seekTrack;

		int totalHeadMovement=0;

		System.out.println("CLOOK ALGORITHM");
		System.out.println("the sequence of head movement :");

		for(int i=0 ;i <Requests.size() ; i++){
			if(Requests.get(i) <= head)
				left.add(Requests.get(i));
			else
				right.add(Requests.get(i));
		}

		Collections.sort(right);
		Collections.sort(left);


		for(int i=0 ;i <right.size() ; i++){
			seekTrack= right.get(i);
			sequence.add(seekTrack);
			System.out.print(seekTrack + " ");

			totalHeadMovement += Math.abs(seekTrack - head);

			head =seekTrack;
		}


		for(int i=0 ;i <left.size() ; i++){
			seekTrack= left.get(i);
			sequence.add(seekTrack);
			System.out.print(seekTrack + " ");

			totalHeadMovement += Math.abs(seekTrack - head);



			head =seekTrack;
		}

		return totalHeadMovement;
	}
	
	public static ArrayList<Integer> getSequence() {
		return sequence;
	}
}
