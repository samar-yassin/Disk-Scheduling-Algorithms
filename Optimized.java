import java.util.ArrayList;
import java.util.Collections;

public class Optimized {
	
	static ArrayList<Integer> sequence = new ArrayList<Integer>();
	
    public static int calculateTotalSeekTime(ArrayList<Integer> Requests, int head) {
    	sequence.clear();
        Collections.sort(Requests);
        head=0;
        int totalHeadMovement=0;
        int seekTrack;

        System.out.println("PROPOSED NEW OPTIMIZED REAL-TIME DISK SCHEDULING");
        System.out.println("the sequence of head movement :");

        for(int i=0 ;i <Requests.size() ; i++){
            seekTrack= Requests.get(i);
            
            sequence.add(seekTrack);
            System.out.print(seekTrack+" ");

            totalHeadMovement += Math.abs(seekTrack - head);

            head =seekTrack;
        }

        return totalHeadMovement;
    }
    
	public static ArrayList<Integer> getSequence() {
		return sequence;
	}
}
