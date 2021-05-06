import java.util.ArrayList;
import java.util.Collections;

public class Optimized {

    public static void Optimized(ArrayList<Integer> Requests, int head) {
        Collections.sort(Requests);
        head=0;
        int totalHeadMovement=0;
        int seekTrack;

        System.out.println("PROPOSED NEW OPTIMIZED REAL-TIME DISK SCHEDULING");
        System.out.println("the sequence of head movement :");

        for(int i=0 ;i <Requests.size() ; i++){
            seekTrack= Requests.get(i);

            System.out.print(seekTrack+" ");

            totalHeadMovement += Math.abs(seekTrack - head);

            head =seekTrack;
        }

        System.out.println("\nthe total head movement : "+totalHeadMovement);


    }

}
