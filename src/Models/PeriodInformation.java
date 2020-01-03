package Models;

public class PeriodInformation {
    private String subject_name;
    private int total_student;

    public PeriodInformation(String subject_name, int total_student) {
        this.subject_name = subject_name;
        this.total_student = total_student;
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
