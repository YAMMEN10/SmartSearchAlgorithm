package Models.Master_Student_Classes;

import Models.Rule_Classes.Limitation;
import Models.Employee_Classes.WithLimitation;

public class MasterStudent extends WithLimitation {

    public MasterStudent(int current_watching, String name, Limitation basic_limitaction, Limitation un_basic_limitaction) {
        super(current_watching, name, basic_limitaction, un_basic_limitaction);
    }
}