/**
 * Created by Dakota Kim on 5/28/14.
 */
import java.util.*;

public class TermReport {

	private LineUsageData[] lists;

	public static void main(String[] args) {
		TermReport print = new TermReport();
		print.input();  // This will read the input.
		print.output();  // This will print out the information.
	}

	public TermReport() {
		// Here, we create an array of 500 SinglyLinkedLists
		// Each index will represent 1 of 500 PCs.
		lists = new LineUsageData[501];
		for (int i = 1; i < lists.length; i++)
			lists[i] = new LineUsageData();
	}

	// This input() method will take input from System.in and place
	// the data received into the proper index.
	private void input() {
		Scanner scan = new Scanner(System.in);
		String line, user;
		int number;
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			Scanner s = new Scanner(line);
			number = s.nextInt();
			user = s.next();
			lists[number].addObservation(user);
		}
	}

	// This will print out the Line, Most Common User and Count.

	private void output() {
		System.out.println("Line\tMost Common User\tCount");
		// Loop through array and print out the most common user
		// and their number of appearances.
		for (int i = 1; i <= lists.length; i++) {
			Usage record = lists[i].findMaxUsage();
			System.out.println(i + "\t" + record.username() + "\t"
					+ record.count());
		}
	}
}
