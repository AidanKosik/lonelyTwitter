package ca.ualberta.cs.lonelytwitter;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by aidankosik on 2018-02-15.
 */

public class TweetList {
    private ArrayList<Tweet> tweets;

    public void add(Tweet tweet) throws IllegalArgumentException {
        tweets.add(tweet);

    }

    public void addTweets(ArrayList<Tweet> tweets) {
        this.tweets = tweets;
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(0);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public TweetList getTweets() {
        TweetList sortedTweets = new TweetList();
        sortedTweets.addTweets(tweets);


        return sortedTweets.sort();
    }

    public int getCount() {
        return tweets.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public TweetList sort() {
        tweets.sort(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return this;
    }

}
