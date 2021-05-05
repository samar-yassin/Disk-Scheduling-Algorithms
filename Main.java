import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static public void main (String[] arg) {
        int numberOfRequests;

        ArrayList<Integer> Requests = new ArrayList<Integer>();

        Scanner input = new Scanner(System.in);

        while(true) {
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


            if (option < 8) {

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