package Models;

/**
 * 
 */
public class Boss extends WithLimitation {


    public Boss(String name, Limitation basic_limitaction, Limitation un_basic_limitaction) {
        super(name, basic_limitaction, un_basic_limitaction);
    }
}