package A_Star;

import Models.*;

import java.util.ArrayList;
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
        AStar();

    }

    public void AStar() {

        List<Integer> theaters_size = this.conditions.getTheaterSize();
        PriorityQueue<Boss> temp_boss = copyQueueForPeriod(rule.getBossFormatted().getBoss_queue());

        for (int day = 0; day < this.rule.getDays_information().size(); day++) {
            List<PeriodInformation> periods = this.rule.getDays_information().get(day).getPeriod_information();
            for (PeriodInformation period_item : periods) {
                List<Integer> temp_theaters_size = new ArrayList<>();
                this.copyList(theaters_size, temp_theaters_size);
                List<Integer> theater_index = this.conditions.getBestTheaterBasedStudentNumber(period_item.getTotal_student(), temp_theaters_size);
                for (int theater = 0; theater < theater_index.size(); theater++) {
                    int temp_watch = temp_boss.peek().getCurrent_watching();
                    for (Boss boss : temp_boss) {

                        if (boss.getBasic_limitaction().getAvailable_days().size() == 0 || boss.getBasic_limitaction().getAvailable_days().contains(DayName.valueOf(rule.getDays_information().get(day).getDay_name()))) {
                            if (boss.getBasic_limitaction().getAvailable_period().size() == 0 || boss.getBasic_limitaction().getAvailable_period().contains(period_item.getPeriod_numbre())) {
                                if (boss.getCurrent_watching() == temp_watch) {
                                    System.out.println("test");
                                }
                            } else continue;
                        } else continue;
                    }


                }


            }
        }

    }

    public PriorityQueue copyQueueForPeriod(PriorityQueue queue) {
        PriorityQueue priorityQueue = new PriorityQueue(queue);
        return priorityQueue;
    }

    public void copyList(List source, List destination) {
        for (int i = 0; i < source.size(); i++) {
            destination.add(source.get(i));
        }

    }

}
