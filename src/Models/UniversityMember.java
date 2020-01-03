package Model;

import java.util.*;

/**
 * 
 */
public abstract class UniversityMember {

    public UniversityMember(String name) {
        this.name = name;
    }

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}