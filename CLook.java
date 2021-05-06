import java.util.ArrayList;
import java.util.Collections;

public class CLook {

    public static void CLook(ArrayList<Integer> Requests, int head){

        ArrayList<Integer>left = new ArrayList<>() ,  right=new ArrayList<Integer>();
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

            System.out.print(seekTrack);

            totalHeadMovement += Math.abs(seekTrack - head);

            head =seekTrack;
        }


        for(int i=0 ;i <left.size() ; i++){
            seekTrack= left.get(i);

            System.out.print(seekTrack);

            totalHeadMovement += Math.abs(seekTrack - head);



            head =seekTrack;
        }

        System.out.println("\nthe total head movement : "+totalHeadMovement);

    }

    }
