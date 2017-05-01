package interfaces.twitter;

import java.util.Comparator;

public class UserNameComparator implements Comparator<TwitterAccount> {

	@Override
	public int compare(TwitterAccount acc1, TwitterAccount acc2) {
		String acc1Name = acc1.getUserName();
		String acc2Name = acc2.getUserName();
		return acc1Name.compareTo(acc2Name);
	}
}
