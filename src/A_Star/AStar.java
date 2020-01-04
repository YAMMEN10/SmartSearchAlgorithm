package A_Star;

import Models.PeriodInformation;
import Models.Rule;
import Models.StateTableClass;
import Models.TheaterInformation;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AStar {


    private List<StateTableClass> stateTables;

    private Rule rule;

    public AStar(Rule rule) {
        this.rule = rule;
        stateTables = new ArrayList<>();
        rule.getTheaters().sort((o1, o2) -> {
            // TODO: implement your logic here
            if (o1.getStudents_size() >= o2.getStudents_size()) {
                return 1;
            }

            return -1;

        });
//        List<Integer> t = getTheaterSize();
//        List<Integer> temp_list = t.stream().collect(Collectors.toList());
//        getBestTheaterBasedStudentNumber(200, temp_list);
//        System.out.println();

    }


    public void AStare() {
        List<Integer> theaters_size = getTheaterSize();
        for (int day = 0; day < this.rule.getDays_information().size(); day++) {
            List<PeriodInformation> periods = this.rule.getDays_information().get(day).getPeriod_information();
            for (PeriodInformation period1 : periods) {
                List<Integer> temp_theaters_size = new ArrayList<>();
                Collections.copy(theaters_size, temp_theaters_size);
                List<Integer> theater_indexs = getBestTheaterBasedStudentNumber(period1.getTotal_student(), temp_theaters_size);
                for (int theate = 0; theate < theater_indexs.size(); theate++) {
                    for(int boss = 0; boss < rule.getBosses().size(); boss++){



                    }
                }


            }
        }

    }


    private List<Integer> getTheaterSize() {
        List<Integer> theaterSize = new ArrayList<>();
        List<TheaterInformation> theaterInformations = rule.getTheaters();
        for (TheaterInformation theaterInformation : theaterInformations) {
            theaterSize.add(theaterInformation.getStudents_size());
        }
        return theaterSize;
    }

    private List<Integer> getBestTheaterBasedStudentNumber(int total_student, List<Integer> theaters_size) {
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


    private boolean IsFinal(StateTableClass stateTable) {

        return true;
    }

}
