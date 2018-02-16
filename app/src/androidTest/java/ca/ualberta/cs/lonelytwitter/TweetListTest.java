package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by aidankosik on 2018-02-15.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() throws IllegalArgumentException {
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding a normal tweet");

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testHasTweet()
    {
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding a normal tweet");

        assertFalse(tweets.hasTweet(tweet));

        try {
            tweets.add(tweet);
        } catch (IllegalArgumentException e) {
            Log.e("Error", "Illegal Argument");
        }

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding a normal tweet");

        tweets.add(tweet);
        Tweet returnTweet = tweets.getTweet(0);

        assertEquals(tweet, returnTweet);
    }

    public void testDeleteTweet() {
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("adding a normal tweet");

        tweets.add(tweet);

        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("Adding a normal tweet");
        Tweet tweet1 = new NormalTweet("Another tweet");
        Tweet tweet2 = new NormalTweet("Last tweet");

        tweets.add(tweet);
        tweets.add(tweet1);
        tweets.add(tweet2);

        TweetList returnTweets = tweets.getTweets();

        assertEquals(tweets, returnTweets);
    }

    public void testCountTweets() {
        TweetList tweets = new TweetList();

        Tweet tweet = new NormalTweet("Adding a normal tweet");

        tweets.add(tweet);

        assertEquals(1, tweets.getCount());
    }

}
