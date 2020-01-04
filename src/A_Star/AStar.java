package A_Star;

import Models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AStar {
    private List<StateTableClass> stateTables;
    private Rule rule;
    private ConditionsClass conditions;

    public AStar(Rule rule) {
        this.rule = rule;
        stateTables = new ArrayList<>();
        this.conditions = new ConditionsClass(this.rule);
        rule.getTheaters().sort((o1, o2) -> {
            // TODO: implement your logic here
            if (o1.getStudents_size() >= o2.getStudents_size()) {
                return 1;
            }

            return -1;

        });
        MasterStudentFormated secretaryFormatted = new MasterStudentFormated();
        secretaryFormatted.pushAllMasterStudent(rule.getMaster_students());

    }

    public void AStare() {
//        List<Integer> theaters_size = this.conditions.getTheaterSize();
//        for (int day = 0; day < this.rule.getDays_information().size(); day++) {
//            List<PeriodInformation> periods = this.rule.getDays_information().get(day).getPeriod_information();
//            for (PeriodInformation period1 : periods) {
//                List<Integer> temp_theaters_size = new ArrayList<>();
//                Collections.copy(theaters_size, temp_theaters_size);
//                List<Integer> theater_indexs = this.conditions.getBestTheaterBasedStudentNumber(period1.getTotal_student(), temp_theaters_size);
//                for (int theate = 0; theate < theater_indexs.size(); theate++) {
//
//                }
//
//
//            }
//        }

    }



}
