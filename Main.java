import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main (String[] arg) {
		int numberOfRequests, headStart, direction = 0;


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
			System.out.print("Your input: ");
			int option = input.nextInt();


			if (option < 8 && option > 0) {

				if(option>2 && option<7){
					System.out.println("Choose the direction of the head :" +
							"\n[1] towards 200" +
							"\n[2] towards 0" +
							"\nyour input: ");

					direction = input.nextInt();
					if(direction!=2 && direction!=1){
						System.out.println("\n===========================");
						System.out.println("Something went wrong.");
						System.out.println("===========================\n");
						continue;
					}

				}


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
					System.out.println("Total seek time: " + FCFS.calculateTotalSeekTime(Requests, headStart));
					break;
				case 2:
					System.out.println("Total seek time: " + SSTF.calculateTotalSeekTime(Requests, headStart));
					break;
				case 3: 
					System.out.println("Total seek time: " + Scan.calculateTotalSeekTime(Requests, headStart, direction));
					break;
				case 4: {
					System.out.println("Total seek time: " + CScan.calculateTotalSeekTime(Requests, headStart, direction));
					break;
				}
				case 5:
					System.out.println("Total seek time: " + Look.calculateTotalSeekTime(Requests, headStart, direction));
					break;
				case 6: {
					System.out.println("Total seek time: " + CLook.calculateTotalSeekTime(Requests, headStart, direction));
					break;
				}
				case 7: {
					System.out.println("Total seek time: " + Optimized.calculateTotalSeekTime(Requests, headStart));
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