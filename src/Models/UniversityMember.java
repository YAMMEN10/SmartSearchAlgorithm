package Models;

public abstract class UniversityMember {

    public UniversityMember(int current_watching, String name) {
        this.current_watching = current_watching;
        this.name = name;
    }

    public int current_watching;

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrent_watching() {
        return current_watching;
    }

    public void setCurrent_watching(int current_watching) {
        this.current_watching = current_watching;
    }
}