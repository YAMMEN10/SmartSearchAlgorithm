package Models;

public class Boss extends WithLimitation {

    public Boss(int current_watching, String name, Limitation basic_limitaction, Limitation un_basic_limitaction) {
        super(current_watching, name, basic_limitaction, un_basic_limitaction);
    }
}