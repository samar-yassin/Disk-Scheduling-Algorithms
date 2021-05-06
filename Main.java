import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static public void main (String[] arg) {
        int numberOfRequests, headStart;


        Scanner input = new Scanner(System.in);

        while(true) {
            ArrayList<Integer> Requests = new ArrayList<Integer>();

            System.out.println("Select the Scheduler you want to use:"
                    + "\n[1] First Come First Served"
                    + "\n[2] Shortest-Seek-Time-First"
                    + "\n[3] SCAN"
                    + "\n[4] C-SCAN"
                    + "\n[5] LOOK"
                    + "\n[6] C-LOOK"
                    + "\n[7] PROPOSED NEW OPTIMIZED REAL-TIME DISK SCHEDULING"
                    + "\n[8] Exit");
            int option = input.nextInt();


            if (option < 8 && option > 0) {
            	
                System.out.print("Enter the initial head start: ");
                headStart = input.nextInt();
                System.out.print("Enter the number of I/O requests: ");
                numberOfRequests = input.nextInt();
                
                System.out.println();


                // Read Requests
                for (int i = 0; i < numberOfRequests; ++i) {
                    input = new Scanner(System.in);
                    System.out.print("Request " + (i + 1) + " : ");

                    Requests.add(input.nextInt());
                }
                System.out.println("===========================\n");

                System.out.println();
                
                switch(option) {
                	case 1:
                		break;
                	case 2:
                		break;
                	case 3: {
                		Scan s = new Scan(Requests, headStart);
                		s.schedule();
                		break;
                	}
                	case 4: {
                	    CScan.CScan(Requests,headStart);
                        break;
                    }
                	case 5:
                		break;
                	case 6: {
                	    CLook.CLook(Requests,headStart);
                        break;
                    }
                	case 7: {
                	    Optimized.Optimized(Requests,headStart);
                        break;
                    }
                }
                System.out.println();
                System.out.println("===========================\n");

            } else if (option == 8) {

                System.exit(0);

            } else {
                System.out.println("\n===========================");
                System.out.println("Invalid option!");
                System.out.println("===========================\n");
                continue;

            }
        }
    }
}