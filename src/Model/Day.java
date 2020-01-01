package Model;

import java.util.*;

/**
 *
 */
public class Day {

    /**
     * Default constructor
     */
    public Day() {
    }


    /**
     *
     */
    private List<Period> periods;
    private DayInformation day_information;

    public Day(List<Period> periods, DayInformation day_information) {
        this.periods = periods;
        this.day_information = day_information;
    }

    public DayInformation getDay_information() {
        return day_information;
    }

    public void setDay_information(DayInformation day_information) {
        this.day_information = day_information;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

}