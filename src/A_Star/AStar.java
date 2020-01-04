package A_Star;

import Models.Rule;
import Models.StateTableClass;

import java.util.ArrayList;
import java.util.List;

public class AStar {

    public AStar(Rule rule) {
        this.rule = rule;
        stateTables = new ArrayList<>();
    }

    private List<StateTableClass> stateTables;

    private Rule rule;



    public boolean isFinal(StateTableClass stateTable) {

        return true;
    }

    public StateTableClass getNewState() {
        //Operation


        return null;
    }



    // getter and setter

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public List<StateTableClass> getStateTables() {
        return stateTables;
    }

    public void setStateTables(List<StateTableClass> stateTables) {
        this.stateTables = stateTables;
    }

    public void addStates() {
        StateTableClass stateTable = getNewState();
        while (isFinal(stateTable)) {
            stateTables.add(getNewState());
        }
    }


}
