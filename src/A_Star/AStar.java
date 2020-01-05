package A_Star;

import Models.Period_Classes.PeriodInformation;
import Models.Rule_Classes.Rule;
import Models.State_Classes.StateTableClass;

import java.security.Security;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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

    }

    public void AStare() {
        List<Integer> theaters_size = this.conditions.getTheaterSize();
        for (int day = 0; day < this.rule.getDays_information().size(); day++) {
            List<PeriodInformation> periods = this.rule.getDays_information().get(day).getPeriod_information();
            for (int period = 0; period < periods.size(); period++) {
                List<Integer> temp_theaters_size = new ArrayList<>();
                Collections.copy(theaters_size, temp_theaters_size);
                List<Integer> theater_index = this.conditions.getBestTheaterBasedStudentNumber(periods.get(period).getTotal_student(), temp_theaters_size);
                for (int theater = 0; theater < theater_index.size(); theater++) {


                }


            }
        }

    }

    public PriorityQueue copyQueueForPeriod(PriorityQueue priorityQueue) {
        return new PriorityQueue<>(priorityQueue);
    }


}
