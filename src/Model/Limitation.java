package Model;

import java.util.List;

public class Limitation {

    private List<DayName> available_days;
    private List<DayName> non_available_days;
    private List<Integer> available_period;
    private List<Integer> non_available_period;
    private Integer continue_period;

    public Limitation(List<DayName> available_days, List<DayName> non_available_days, List<Integer> available_period, List<Integer> non_available_period, Integer continue_period) {
        this.available_days = available_days;
        this.non_available_days = non_available_days;
        this.available_period = available_period;
        this.non_available_period = non_available_period;
        this.continue_period = continue_period;
    }

    public List<DayName> getAvailable_days() {
        return available_days;
    }

    public void setAvailable_days(List<DayName> available_days) {
        this.available_days = available_days;
    }

    public List<DayName> getNon_available_days() {
        return non_available_days;
    }

    public void setNon_available_days(List<DayName> non_available_days) {
        this.non_available_days = non_available_days;
    }

    public List<Integer> getAvailable_period() {
        return available_period;
    }

    public void setAvailable_period(List<Integer> available_period) {
        this.available_period = available_period;
    }

    public List<Integer> getNon_available_period() {
        return non_available_period;
    }

    public void setNon_available_period(List<Integer> non_available_period) {
        this.non_available_period = non_available_period;
    }

    public int getContinue_period() {
        return continue_period;
    }

    public void setContinue_period(int continue_period) {
        this.continue_period = continue_period;
    }
}