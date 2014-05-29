/**
 * Created by Dakota Kim on 5/28/14.
 */
import java.util.*;


public class LineUsageData {

	// Since we are going to hold two values, username and count.
	// I am going to implement a Map<String, Integer>.

	private SinglyLinkedList<Usage> usageList;

	public LineUsageData() {
		usageList = new SinglyLinkedList<Usage>();
	}

	// add one sighting of a use on this line
	public void addObservation(String username) {
		Usage usage;
		for (int i = 0; i < usageList.size(); i++) {
			usage = usageList.get(i);
			// If the user has never been seen before, it creates a new usage for that user.
			if (usage == null)
				usage = new Usage(username);
			usage.increment();
			usageList.add(usage);
		}

	}

	// find the user with the most sightings on this line
	public Usage findMaxUsage() {
		Usage user;
		Usage highScore = new Usage("<NONE>");  // with count 0

		for (int i = 0; i < usageList.size(); i++) {
			user = usageList.get(i);
			if (user.count() > highScore.count())
				highScore = user;
		}
		return highScore;
	}
}


