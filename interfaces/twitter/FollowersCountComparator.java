package interfaces.twitter;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount> {

	@Override
	public int compare(TwitterAccount acc1, TwitterAccount acc2) {
		Integer followerCountAcc1 = acc1.getFollowerCount();
		Integer followerCountAcc2 = acc2.getFollowerCount();
		return followerCountAcc2.compareTo(followerCountAcc1);
	}
}
