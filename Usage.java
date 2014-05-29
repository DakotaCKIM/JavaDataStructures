/**
 * Created by Dakota Kim on 5/28/14.
 */
public class Usage {

	private String user;
	private int count;

	public Usage(String x) {
		user = x;
		count = 0;
	}

	public void increment() {
		count++;
	}

	public String username() {
		return user;
	}

	public int count() {
		int z = this.count;
		return z;
	}
}
