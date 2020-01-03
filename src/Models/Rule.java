package Model;

import java.util.List;

public class Rule {

    public Rule(List<TheaterInformation> avaliable_theater, int employee_watches, int profesor_watches, int enginer_watches, int master_student_watches, List<Boss> bosses, List<Secretary> secretareis, List<DayInformation> days_information, List<MasterStudent> master_students, List<Employee> employees) {
        this.available_theater = avaliable_theater;
        this.employee_watches = employee_watches;
        this.professor_watches = profesor_watches;
        this.engineer_watches = enginer_watches;
        this.master_student_watches = master_student_watches;
        this.bosses = bosses;
        this.secretaries = secretareis;
        this.days_information = days_information;
        this.master_students = master_students;
        this.employees = employees;
    }

    private List<TheaterInformation> available_theater;
    private List<DayInformation> days_information;
    private List<Boss> bosses;
    private List<Secretary> secretaries;
    private List<MasterStudent> master_students;
    private List<Employee> employees;
    private int employee_watches;
    private int professor_watches;
    private int engineer_watches;
    private int master_student_watches;

    public List<TheaterInformation> getAvailable_theater() {
        return available_theater;
    }

    public void setAvailable_theater(List<TheaterInformation> available_theater) {
        this.available_theater = available_theater;
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

    public int getProfessor_watches() {
        return professor_watches;
    }

    public void setProfessor_watches(int professor_watches) {
        this.professor_watches = professor_watches;
    }

    public int getEngineer_watches() {
        return engineer_watches;
    }

    public void setEngineer_watches(int engineer_watches) {
        this.engineer_watches = engineer_watches;
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

    public List<Secretary> getSecretaries() {
        return secretaries;
    }

    public void setSecretaries(List<Secretary> secretaries) {
        this.secretaries = secretaries;
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