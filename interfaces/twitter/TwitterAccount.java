package interfaces.twitter;

import java.util.ArrayList;
import java.util.Comparator;

public class TwitterAccount {
	
	private String userName;
	private ArrayList<TwitterAccount> followers = new ArrayList<>();
	private ArrayList<TwitterAccount> following = new ArrayList<>();
	private ArrayList<Tweet> tweets = new ArrayList<>();
	private int retweetCount = 0;
	
	public TwitterAccount(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public ArrayList<TwitterAccount> getFollowers() {
		return followers;
	}

	public ArrayList<TwitterAccount> getFollowing() {
		return following;
	}

	public void follow(TwitterAccount account) {
		if (account != this && !following.contains(account)) {
			this.getFollowing().add(account);
			account.getFollowers().add(this);
		}
	}
	
	public void unfollow(TwitterAccount account) {
		if (this.getFollowing().contains(account)) {
			this.getFollowing().remove(account);
			account.getFollowers().remove(this);
		}
	}
	
	public boolean isFollowing(TwitterAccount account) {
		if (this.getFollowing().contains(account)) {
			return true;
		}
		return false;
	}
	
	public boolean isFollowedBy(TwitterAccount account) {
		if (this.getFollowers().contains(account)) {
			return true;
		}
		return false;
	}
	
	public void tweet(String text) {
		tweets.add(0, new Tweet(this, text));
	}
	
	public void retweet(Tweet tweet) {
		tweets.add(0, new Tweet(this, tweet));
		tweet.increaseRetweetcounter();
		
		if (tweet.getOriginalTweet() != null) {
			tweet.getOriginalTweet().getOwner().increaseRetweetCounter();
		} else {
			tweet.getOwner().increaseRetweetCounter();
		}
	}
	
	public int getRetweetCount() {
		return this.retweetCount;
	}
	
	public void increaseRetweetCounter() {
		this.retweetCount++;
	}
	
	public ArrayList<Tweet> getTweets() {
		return this.tweets;
	}
	
	public Tweet getTweet(int i) {
		return this.tweets.get(i - 1);
	}
	
	public int getTweetCount() {
		return this.getTweets().size();
	}
	
	public int getFollowerCount() {
		return this.getFollowers().size();
	}

	public ArrayList<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator) {
		if (comparator == null) {
			return this.getFollowers();
		}
		ArrayList<TwitterAccount> sortedList = this.getFollowers();
		sortedList.sort(comparator);
		return sortedList;
	}
	
	public String toString() {
		return this.getUserName();
	}
}
