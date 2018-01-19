package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aidankosik on 2018-01-18.
 */

public class Confused extends Mood {

    public Confused(String mood) {
        super("Confused");
    }

    public Confused(String mood, Date date) {
        super("Confused", date);
    }

    public String getMood() {
        return mood + ">:)";
    }
}
