package Models;

import java.util.List;

public class Rule {

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
        masterStudentFormated = new MasterStudentFormated();
        secretaryFormatted = new SecretaryFormatted();
        bossFormatted = new BossFormatted();
        masterStudentFormated.pushAllMasterStudent(this.getMaster_students());
        secretaryFormatted.pushAllSecretary(this.getSecretaries());
        bossFormatted.pushAllBoss(this.getBosses());



    }

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
    private MasterStudentFormated masterStudentFormated ;

    private SecretaryFormatted secretaryFormatted ;

    private BossFormatted bossFormatted ;

    public MasterStudentFormated getMasterStudentFormated() {
        return masterStudentFormated;
    }

    public void setMasterStudentFormated(MasterStudentFormated masterStudentFormated) {
        this.masterStudentFormated = masterStudentFormated;
    }

    public SecretaryFormatted getSecretaryFormatted() {
        return secretaryFormatted;
    }

    public void setSecretaryFormatted(SecretaryFormatted secretaryFormatted) {
        this.secretaryFormatted = secretaryFormatted;
    }

    public BossFormatted getBossFormatted() {
        return bossFormatted;
    }

    public void setBossFormatted(BossFormatted bossFormatted) {
        this.bossFormatted = bossFormatted;
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