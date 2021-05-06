import java.util.ArrayList;
import java.util.Collections;

public class Optimized {

    public static void Optimized(ArrayList<Integer> Requests, int head) {
        Collections.sort(Requests);
        head=0;
        int totalHeadMovement=0;
        int seekTrack;

        for(int i=0 ;i <Requests.size() ; i++){
            seekTrack= Requests.get(i);

            System.out.println(seekTrack);

            totalHeadMovement += Math.abs(seekTrack - head);

            head =seekTrack;
        }

        System.out.println("the total head movement : "+totalHeadMovement);


    }

}
