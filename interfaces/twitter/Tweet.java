package interfaces.twitter;

public class Tweet {
	
	private String text;
	private TwitterAccount owner;
	private Tweet originalTweet;
	private int retweetCount = 0;
	

	public Tweet(TwitterAccount owner, String text) {
		this.owner = owner;
		this.text = text;
		this.originalTweet = null;
	}
	
	public Tweet(TwitterAccount owner, Tweet tweet) {
		if (tweet.getOwner() == owner) {
			throw new IllegalArgumentException();
		}
		this.owner = owner;
		this.text = tweet.getText();
		
		if (tweet.getOriginalTweet() == null) {
			this.originalTweet = tweet;
		} else {
			this.originalTweet = tweet.getOriginalTweet();
		}
		tweet.increaseRetweetcounter();
	}
	
	public String getText() {
		return this.text;
	}
	
	public TwitterAccount getOwner() {
		return this.owner;
	}
	
	public Tweet getOriginalTweet() {
		return this.originalTweet;
	}
	
	public void increaseRetweetcounter() {
		this.retweetCount++;
	}
	
	public int getRetweetCount() {
		return this.retweetCount;
	}
	
	public String toString() {
		return this.getOwner().getUserName() + ": " + this.getText();
	}
}
