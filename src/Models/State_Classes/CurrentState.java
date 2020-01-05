package Models.State_Classes;

import Models.Boss_Classes.Boss;
import Models.Day_Classes.Day;
import Models.Master_Student_Classes.MasterStudent;
import Models.Secretary_Classes.Secretary;
import javafx.util.Pair;

import java.util.List;
import java.util.PriorityQueue;

public class CurrentState {
    private List<Day> days;
    private int weight;
    private int day;
    private int period;


    public CurrentState(List<Day> days, int weight, int day, int period) {
        this.days = days;
        this.weight = weight;
        this.day = day;
        this.period = period;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
