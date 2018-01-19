package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aidankosik on 2018-01-18.
 */

public class Touchy extends Mood {

    public Touchy(String mood) {
        super("Touchy");
    }

    public Touchy(String mood, Date date) {
        super("Touchy", date);
    }

    public String getMood() {
        return mood + ":)";
    }
}
