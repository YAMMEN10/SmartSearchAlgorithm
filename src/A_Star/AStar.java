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
        MasterStudentFormated masterStudentFormated = new MasterStudentFormated();
        masterStudentFormated.pushAllMasterStudent(rule.getMaster_students());

        SecretaryFormatted secretaryFormatted = new SecretaryFormatted();
        secretaryFormatted.pushAllSecretary(rule.getSecretaries());

        BossFormatted bossFormatted = new BossFormatted();
        bossFormatted.pushAllBoss(rule.getBosses());

    }

    public void AStare() {
        List<Integer> theaters_size = this.conditions.getTheaterSize();
        for (int day = 0; day < this.rule.getDays_information().size(); day++) {
            List<PeriodInformation> periods = this.rule.getDays_information().get(day).getPeriod_information();
            for (PeriodInformation period1 : periods) {
                List<Integer> temp_theaters_size = new ArrayList<>();
                Collections.copy(theaters_size, temp_theaters_size);
                List<Integer> theater_index = this.conditions.getBestTheaterBasedStudentNumber(period1.getTotal_student(), temp_theaters_size);
                for (int theater = 0; theater < theater_index.size(); theater++) {

                }


            }
        }

    }



}
