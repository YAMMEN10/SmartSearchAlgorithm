package Model;

public class TheaterInformation {

    public TheaterInformation(String name, int students_size, int floor_number, int required_watcher) {
        this.name = name;
        this.students_size = students_size;
        this.floor_number = floor_number;
        this.required_watcher = required_watcher;
    }

    private String name;
    private int students_size;
    private int floor_number;
    private int required_watcher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudents_size() {
        return students_size;
    }

    public void setStudents_size(int students_size) {
        this.students_size = students_size;
    }

    public int getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(int floor_number) {
        this.floor_number = floor_number;
    }

    public int getRequired_watcher() {
        return required_watcher;
    }

    public void setRequired_watcher(int required_watcher) {
        this.required_watcher = required_watcher;
    }
}