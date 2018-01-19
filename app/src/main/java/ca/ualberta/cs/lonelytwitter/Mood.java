package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by aidankosik on 2018-01-18.
 */

public abstract class Mood {
    private Date date;
    protected String mood;

    public Mood(String mood) {
        this.mood = mood;
        this.date = new Date();
    }

    public Mood(String mood, Date date) {
        this.mood = mood;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String getMood();



}
