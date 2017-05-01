package interfaces.twitter;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount> {

	@Override
	public int compare(TwitterAccount acc1, TwitterAccount acc2) {
		Integer tweetCountAcc1 = acc1.getTweetCount();
		Integer tweetCountAcc2 = acc2.getTweetCount();
		return tweetCountAcc2.compareTo(tweetCountAcc1);
	}

	
}
