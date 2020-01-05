package Models.Boss_Classes;

import Models.Rule_Classes.Limitation;
import Models.Employee_Classes.WithLimitation;

public class Boss extends WithLimitation {
    private String type;

    public Boss(int current_watching, String name, String type, Limitation basic_limitation, Limitation un_basic_limitation) {
        super(current_watching, name, basic_limitation, un_basic_limitation);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}