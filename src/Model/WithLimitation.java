package Model;

import java.util.*;

/**
 * 
 */
public class WithLimitation extends UniversityMember {

    private Limitation basic_limitaction;

    private Limitation un_basic_limitaction;

    public WithLimitation(String name, Limitation basic_limitaction, Limitation un_basic_limitaction) {
        super(name);
        this.basic_limitaction = basic_limitaction;
        this.un_basic_limitaction = un_basic_limitaction;
    }

    public Limitation getBasic_limitaction() {
        return basic_limitaction;
    }

    public void setBasic_limitaction(Limitation basic_limitaction) {
        this.basic_limitaction = basic_limitaction;
    }

    public Limitation getUn_basic_limitaction() {
        return un_basic_limitaction;
    }

    public void setUn_basic_limitaction(Limitation un_basic_limitaction) {
        this.un_basic_limitaction = un_basic_limitaction;
    }
}