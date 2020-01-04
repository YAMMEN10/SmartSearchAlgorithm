package A_Star;

import Models.Boss;
import Models.Rule;
import Models.StateTableClass;
import Models.TheaterInformation;
import javafx.util.Pair;

import java.util.*;

public class ConditionsClass {
    private Rule rule;

    public ConditionsClass(Rule rule) {
        this.rule = rule;
    }

    public List<Integer> getTheaterSize() {
        List<Integer> theaterSize = new ArrayList<>();
        List<TheaterInformation> theaterInformations = rule.getTheaters();
        for (TheaterInformation theaterInformation : theaterInformations) {
            theaterSize.add(theaterInformation.getStudents_size());
        }
        return theaterSize;
    }


    public List<Integer> getBestTheaterBasedStudentNumber(int total_student, List<Integer> theaters_size) {
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> best_theaters = new ArrayList<>();
        while (total_student > 0) {
            Pair<Integer, Integer> pair = binarySearch.binarySearch(theaters_size, 0, theaters_size.size() - 1, total_student);
            total_student -= pair.getValue();
            best_theaters.add(pair.getKey());
            theaters_size.remove(pair.getValue());

        }
        System.out.println(best_theaters.size());

        return best_theaters;
    }

    public Integer checkDeferentInBoss(PriorityQueue<Integer> bosses_priority_queue){
        return bosses_priority_queue.peek();
    }


    public boolean IsFinal(StateTableClass stateTable) {

        return true;
    }
}
