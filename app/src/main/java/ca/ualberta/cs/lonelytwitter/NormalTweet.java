package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * A normal tweet, has no special implementation of getMessage.
 * @author dezfuli
 * @see Tweet
 */
public class NormalTweet extends Tweet {
    /**
     * Constructor for a normal tweet, takes only a message
     * and uses the tweet classes constructor.
     * @param message the tweets message
     */
    NormalTweet(String message){
        super(message);
    }

    /**
     * Second constructor for a normal tweet, takes two parameters.
     * One for the message of the tweet and the other is the date.
     * @param message the message of the tweet
     * @param date the date of the tweet
     */
    NormalTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Returns if the tweet is important or not.
     * Normal tweets are not important so this
     * always returns false.
     * @return Boolean will always return false.
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
