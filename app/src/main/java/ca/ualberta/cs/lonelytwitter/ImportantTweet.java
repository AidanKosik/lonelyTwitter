package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * This class of tweets are important tweets. It extends tweet.
 */
public class ImportantTweet extends Tweet {
    /**
     * Constructor tweet when only taking message as a parameter.
     * @param message this is the message of the tweet.
     */
    ImportantTweet(String message){
        super(message);
    }

    /**
     * Constructor for important tweet when taking message
     * and date as parameters.
     * @param message the message of the tweet
     * @param date the date of the tweet
     */
    ImportantTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Returns if the tweet is important or not.
     * Since important tweets are always important,
     * this will always return true.
     * @return Boolean that is always false.
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
