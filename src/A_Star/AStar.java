package A_Star;

import Models.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AStar {


    private List<StateTableClass> stateTables;

    private Rule rule;

    public AStar(Rule rule) {
        this.rule = rule;
        stateTables = new ArrayList<>();
        rule.getTheaters().sort(new Comparator<TheaterInformation>() {
            @Override
            public int compare(final TheaterInformation o1, final TheaterInformation o2) {
                // TODO: implement your logic here
                if (o1.getStudents_size() >= o2.getStudents_size()) {
                    return 1;
                }

                return -1;

            }
        });


    }

    public List<Integer> getTheaterSize()
    {
        List<Integer> theaterSize=new ArrayList<>();
        List<TheaterInformation> theaterInformations=rule.getTheaters();
        for (int i = 0; i <theaterInformations.size() ; i++) {
            theaterSize.add(theaterInformations.get(i).getStudents_size());
        }
        return theaterSize;
    }

    public void AStare() {
        List<Integer> theaters_size=getTheaterSize();
        for (int day = 0; day < this.rule.getDays_information().size(); day++) {
            List<PeriodInformation> periods = this.rule.getDays_information().get(day).getPeriod_information();
            for (int period = 0; period < periods.size(); period++) {
                List<Integer> thater_indexs = getBestTheaterBasedStudentNumber(periods.get(period).getTotal_student(),theaters_size);

            }
        }

    }

    private List<Integer> getBestTheaterBasedStudentNumber(int total_student,List<Integer> theaters_size) {
        BinarySearch binarySearch=new BinarySearch();
        List<Integer> best_theaters=new ArrayList<>();
        while (total_student>0)
        {
            Pair<Integer,Integer> pair=binarySearch.binarySearch(theaters_size,0,theaters_size.size(),total_student);
            total_student-=pair.getValue();
            best_theaters.add(pair.getKey());

        }

        return  best_theaters;
    }


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
