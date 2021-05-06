import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CScan {

    public static void CScan(ArrayList<Integer> Requests, int head){


        ArrayList<Integer>left = new ArrayList<>() ,  right=new ArrayList<Integer>();
        int seekTrack;

        left.add(0);
        right.add(199);

        int totalHeadMovement=0;

        System.out.println("CSCAN ALGORITHM");
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

            System.out.print(seekTrack);

            totalHeadMovement += Math.abs(seekTrack - head);

            head =seekTrack;
        }

        head=0; //return to the left
        totalHeadMovement+=199;

        for(int i=0 ;i <left.size() ; i++){
            seekTrack= left.get(i);

            System.out.print(seekTrack);

            totalHeadMovement += Math.abs(seekTrack - head);

            head =seekTrack;
        }

        System.out.println("\nthe total head movement : "+totalHeadMovement);


        }
}
