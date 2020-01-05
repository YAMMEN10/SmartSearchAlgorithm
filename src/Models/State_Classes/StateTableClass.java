package Models.State_Classes;

import Models.Theater_Classes.Theater;

import java.util.List;

public class StateTableClass {
    List<Theater> theaters;

    public List<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
    }
}