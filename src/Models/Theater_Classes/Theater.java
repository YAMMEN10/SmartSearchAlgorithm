package Models.Theater_Classes;

import Models.Boss_Classes.Boss;
import Models.Employee_Classes.Employee;
import Models.Master_Student_Classes.MasterStudent;
import Models.Secretary_Classes.Secretary;
import javafx.util.Pair;

import java.util.List;


public class Theater {

    private Pair<Integer, Integer> students_rang;
    private TheaterInformation theater_information;
    private Boss boss_theater;
    private Secretary secretary_theater;
    private List<MasterStudent> master_student_watchers;
    private List<Employee> employees_wathers;

    public Pair<Integer, Integer> getStudents_rang() {
        return students_rang;
    }

    public void setStudents_rang(Pair<Integer, Integer> students_rang) {
        this.students_rang = students_rang;
    }

    public TheaterInformation getTheater_information() {
        return theater_information;
    }

    public void setTheater_information(TheaterInformation theater_information) {
        this.theater_information = theater_information;
    }

    public Boss getBoss_theater() {
        return boss_theater;
    }

    public void setBoss_theater(Boss boss_theater) {
        this.boss_theater = boss_theater;
    }

    public Secretary getSecretary_theater() {
        return secretary_theater;
    }

    public void setSecretary_theater(Secretary secretary_theater) {
        this.secretary_theater = secretary_theater;
    }

    public List<MasterStudent> getMaster_student_watchers() {
        return master_student_watchers;
    }

    public void setMaster_student_watchers(List<MasterStudent> master_student_watchers) {
        this.master_student_watchers = master_student_watchers;
    }

    public List<Employee> getEmployees_wathers() {
        return employees_wathers;
    }

    public void setEmployees_wathers(List<Employee> employees_wathers) {
        this.employees_wathers = employees_wathers;
    }
}