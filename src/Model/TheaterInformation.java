package Model;

import java.util.*;

/**
 * 
 */
public class TheaterInformation {

    /**
     * Default constructor
     */
    public TheaterInformation() {
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private int students_size;

    /**
     * 
     */
    private int floor_number;

    /**
     * 
     */
    private int requrament_watcher;

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

    public int getRequrament_watcher() {
        return requrament_watcher;
    }

    public void setRequrament_watcher(int requrament_watcher) {
        this.requrament_watcher = requrament_watcher;
    }
}