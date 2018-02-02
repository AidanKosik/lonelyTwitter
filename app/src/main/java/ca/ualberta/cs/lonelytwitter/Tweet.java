package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by dezfuli on 1/16/18.
 */

/**
 * This is the generic tweet class. Any specific type of tweet takes from
 * this class. The tweet class contains methods for getting and
 * setting the message and for the date. Message and date are the
 * only two attributes of the class. There is also a toString
 * function that converts the object into a string format
 * for saving the objects. It implements the interface tweetable.
 * @author dezfuli
 * @see Tweetable
 */
public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;

    /**
     * Constructor for the Tweet class. Takes just a string for the message
     * and sets the date to the date when created.
     * @param message the tweets message
     */
    Tweet(String message){

        this.message = message;
        date = new Date();
//        message = message;
    }

    /**
     * Second constructor for the Tweet class. Takes two parameters.
     * One which is the message of the tweet, and the other
     * is a given date rather than the date at the time.
     * @param message the tweets message
     * @param date the date of the tweet
     */
    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * Returns the message of the tweet.
     * @return String the message of the tweet
     * @see String
     */
    public String getMessage(){
        return message;
    }

    /**
     * Sets the message of this tweet.
     * @param message the new message for the tweet
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    /**
     * Returns the date of the tweet.
     * @return Date the date the tweet was posted.
     */
    public Date getDate(){
        return date;
    }

    /**
     * Sets the date of an existing tweet.
     * @param date the date the tweet was posted.
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * An abstract class for deciding if the tweet is important.
     * This is implemented by types of tweets.
     * @return Boolean true if important, false otherwise
     * @see ImportantTweet
     */
    public abstract Boolean isImportant();

    /**
     * Writes the tweet as a string used for saving the tweet.
     * @return String the message of the tweet
     */
    @Override
    public String toString(){
        return message;
    }
}
