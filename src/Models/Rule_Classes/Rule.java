package Models.Rule_Classes;

import Models.Boss_Classes.Boss;
import Models.Boss_Classes.BossFormatted;
import Models.Day_Classes.DayInformation;
import Models.Employee_Classes.Employee;
import Models.Master_Student_Classes.MasterStudent;
import Models.Master_Student_Classes.MasterStudentFormatted;
import Models.Secretary_Classes.Secretary;
import Models.Secretary_Classes.SecretaryFormatted;
import Models.Theater_Classes.TheaterInformation;

import java.util.List;
import java.util.PriorityQueue;

public class Rule {
    private List<TheaterInformation> theaters;
    private List<DayInformation> days_information;
    private List<Boss> bosses;
    private List<Secretary> secretaries;
    private List<MasterStudent> master_students;
    private List<Employee> employees;
    private int employee_watches;
    private int professor_watches;
    private int engineer_watches;
    private int master_student_watches;
    private PriorityQueue<MasterStudent> master_student_priority_queue;
    private PriorityQueue<Secretary> secretary_priority_queue;
    private PriorityQueue<Boss> boss_priority_queue;

    public Rule(List<TheaterInformation> available_theater, List<DayInformation> days_information, List<Boss> bosses, List<Secretary> secretaries, List<MasterStudent> master_students, List<Employee> employees, int employee_watches, int professor_watches, int engineer_watches, int master_student_watches) {
        this.theaters = available_theater;
        this.days_information = days_information;
        this.bosses = bosses;
        this.secretaries = secretaries;
        this.master_students = master_students;
        this.employees = employees;
        this.employee_watches = employee_watches;
        this.professor_watches = professor_watches;
        this.engineer_watches = engineer_watches;
        this.master_student_watches = master_student_watches;

        this.boss_priority_queue = new BossFormatted().pushAllBoss(this.getBosses()).getBoss_priority_queue();
        this.master_student_priority_queue = new MasterStudentFormatted().pushAllMasterStudent(this.getMaster_students()).getMaster_student_priority_queue();
        this.secretary_priority_queue = new SecretaryFormatted().pushAllSecretary(this.getSecretaries()).getSecretary_priority_queue();

        this.theaters.sort(// TODO: implement your logic here
                Rule::compare);
    }

    private static int compare(TheaterInformation o1, TheaterInformation o2) {
        if (o1.getStudents_size() > o2.getStudents_size()) {
            return 1;
        } else if (o1.getStudents_size() < o2.getStudents_size()) {
            return -1;
        } else return 0;
    }


    public PriorityQueue<MasterStudent> getMaster_student_priority_queue() {
        return master_student_priority_queue;
    }

    public void setMaster_student_priority_queue(PriorityQueue<MasterStudent> master_student_priority_queue) {
        this.master_student_priority_queue = master_student_priority_queue;
    }

    public PriorityQueue<Secretary> getSecretary_priority_queue() {
        return secretary_priority_queue;
    }

    public void setSecretary_priority_queue(PriorityQueue<Secretary> secretary_priority_queue) {
        this.secretary_priority_queue = secretary_priority_queue;
    }

    public PriorityQueue<Boss> getBoss_priority_queue() {
        return boss_priority_queue;
    }

    public void setBoss_priority_queue(PriorityQueue<Boss> boss_priority_queue) {
        this.boss_priority_queue = boss_priority_queue;
    }

    public List<TheaterInformation> getTheaters() {
        return theaters;
    }

    public void setTheaters(List<TheaterInformation> theaters) {
        this.theaters = theaters;
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