package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * This is an interface used by all objects that are tweetable.
 */
public interface Tweetable {
    public String getMessage();
    public Date getDate();
}
