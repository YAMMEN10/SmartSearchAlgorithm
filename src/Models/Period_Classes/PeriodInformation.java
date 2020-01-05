package Models.Period_Classes;

public class PeriodInformation {
    private String subject_name;
    private int total_student;
    private int period_number;


    public PeriodInformation(String subject_name, int total_student, int period_number) {
        this.subject_name = subject_name;
        this.total_student = total_student;
        this.period_number = period_number;
    }

    public int getPeriod_number() {
        return period_number;
    }

    public void setPeriod_number(int period_number) {
        this.period_number = period_number;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getTotal_student() {
        return total_student;
    }

    public void setTotal_student(int total_student) {
        this.total_student = total_student;
    }
}
