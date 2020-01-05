package Models.State_Classes;

import Models.Day_Classes.Day;

import java.util.List;
import java.util.Map;

public class CurrentState {
    private List<Day> days;
    private Map<String, Integer> all_bosses;
    private Map<String, Integer> all_engineer;
    private Map<String, Integer> all_employee;
    private Map<String, Integer> all_master_student;
    private int weight;
    private int day;
    private int period;


    public CurrentState(List<Day> days, Map<String, Integer> all_bosses, Map<String, Integer> all_engineer, Map<String, Integer> all_employee, Map<String, Integer> all_master_student, int weight, int day, int period) {
        this.days = days;
        this.all_bosses = all_bosses;
        this.all_engineer = all_engineer;
        this.all_employee = all_employee;
        this.all_master_student = all_master_student;
        this.weight = weight;
        this.day = day;
        this.period = period;
    }

    public Map<String, Integer> getAll_engineer() {
        return all_engineer;
    }

    public void setAll_engineer(Map<String, Integer> all_engineer) {
        this.all_engineer = all_engineer;
    }

    public Map<String, Integer> getAll_employee() {
        return all_employee;
    }

    public void setAll_employee(Map<String, Integer> all_employee) {
        this.all_employee = all_employee;
    }

    public Map<String, Integer> getAll_master_student() {
        return all_master_student;
    }

    public void setAll_master_student(Map<String, Integer> all_master_student) {
        this.all_master_student = all_master_student;
    }

    public Map<String, Integer> getAll_bosses() {
        return all_bosses;
    }

    public void setAll_bosses(Map<String, Integer> all_bosses) {
        this.all_bosses = all_bosses;
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
