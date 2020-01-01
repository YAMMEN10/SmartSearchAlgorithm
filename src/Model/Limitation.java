package Model;

import java.util.*;

/**
 * 
 */
public class Limitation {

    /**
     * Default constructor
     */
    public Limitation() {
    }

    /**
     * 
     */
    private List<DayName> avaliable_days;

    /**
     * 
     */
    private List<DayName> nonavaliable_days;

    /**
     * 
     */
    private List<Integer> available_period;

    /**
     * 
     */
    private List<Integer> nonavailable_period;

    /**
     * 
     */
    private int continue_period;


    public List<DayName> getAvaliable_days() {
        return avaliable_days;
    }

    public void setAvaliable_days(List<DayName> avaliable_days) {
        this.avaliable_days = avaliable_days;
    }

    public List<DayName> getNonavaliable_days() {
        return nonavaliable_days;
    }

    public void setNonavaliable_days(List<DayName> nonavaliable_days) {
        this.nonavaliable_days = nonavaliable_days;
    }

    public List<Integer> getAvailable_period() {
        return available_period;
    }

    public void setAvailable_period(List<Integer> available_period) {
        this.available_period = available_period;
    }

    public List<Integer> getNonavailable_period() {
        return nonavailable_period;
    }

    public void setNonavailable_period(List<Integer> nonavailable_period) {
        this.nonavailable_period = nonavailable_period;
    }

    public int getContinue_period() {
        return continue_period;
    }

    public void setContinue_period(int continue_period) {
        this.continue_period = continue_period;
    }
}