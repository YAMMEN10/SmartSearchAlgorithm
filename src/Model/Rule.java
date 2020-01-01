package Model;

import java.util.List;

/**
 *
 */
public class Rule {


    public Rule() {
    }

    public Rule(List<TheaterInformation> avaliable_theater, int employee_watches, int profesor_watches, int enginer_watches, int master_student_watches, List<Boss> bosses, List<Secretary> secretareis, List<DayInformation> days_information, List<MasterStudent> master_students, List<Employee> employees) {
        this.avaliable_theater = avaliable_theater;
        this.employee_watches = employee_watches;
        this.profesor_watches = profesor_watches;
        this.enginer_watches = enginer_watches;
        this.master_student_watches = master_student_watches;
        this.bosses = bosses;
        this.secretareis = secretareis;
        this.days_information = days_information;
        this.master_students = master_students;
        this.employees = employees;
    }

    /**
     *
     */
    private List<TheaterInformation> avaliable_theater;

    private List<DayInformation> days_information;

    /**
     *
     */
    private int employee_watches;

    /**
     *
     */
    private int profesor_watches;

    /**
     *
     */
    private int enginer_watches;

    /**
     *
     */
    private int master_student_watches;

    /**
     *
     */
    private List<Boss> bosses;

    /**
     *
     */
    private List<Secretary> secretareis;


    /**
     *
     */
    private List<MasterStudent> master_students;

    /**
     *
     */
    public List<Employee> employees;

    public List<TheaterInformation> getAvaliable_theater() {
        return avaliable_theater;
    }

    public void setAvaliable_theater(List<TheaterInformation> avaliable_theater) {
        this.avaliable_theater = avaliable_theater;
    }

    public List<DayInformation> getDays_information() {
        return days_information;
    }

    public void setDays_information(List<DayInformation> days_information) {
        this.days_information = days_information;
    }

    public int getEmployee_watches() {
        return employee_watches;
    }

    public void setEmployee_watches(int employee_watches) {
        this.employee_watches = employee_watches;
    }

    public int getProfesor_watches() {
        return profesor_watches;
    }

    public void setProfesor_watches(int profesor_watches) {
        this.profesor_watches = profesor_watches;
    }

    public int getEnginer_watches() {
        return enginer_watches;
    }

    public void setEnginer_watches(int enginer_watches) {
        this.enginer_watches = enginer_watches;
    }

    public int getMaster_student_watches() {
        return master_student_watches;
    }

    public void setMaster_student_watches(int master_student_watches) {
        this.master_student_watches = master_student_watches;
    }

    public List<Boss> getBosses() {
        return bosses;
    }

    public void setBosses(List<Boss> bosses) {
        this.bosses = bosses;
    }

    public List<Secretary> getSecretareis() {
        return secretareis;
    }

    public void setSecretareis(List<Secretary> secretareis) {
        this.secretareis = secretareis;
    }

    public List<MasterStudent> getMaster_students() {
        return master_students;
    }

    public void setMaster_students(List<MasterStudent> master_students) {
        this.master_students = master_students;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}