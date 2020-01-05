import A_Star.AStarAlgorithmClass;
import Models.Day_Classes.Day;
import Models.Period_Classes.Period;
import Models.State_Classes.CurrentState;
import Parse_Json.ParseJson;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ParseJson parseJson = new ParseJson();
        AStarAlgorithmClass aStarAlgorithmClass = new AStarAlgorithmClass(parseJson.getRule());
        List<Day> days = new ArrayList<>();
        for (int i = 0; i < parseJson.getRule().getDays_information().size(); i++) {
            List<Period> all_period = new ArrayList<>();
            for (int j = 0; j < parseJson.getRule().getDays_information().get(i).getPeriod_information().size(); j++) {
                all_period.add(new Period(
                        parseJson.getRule().getDays_information().get(i).getPeriod_information().get(j),
                        new ArrayList<>()));
            }
            Day day = new Day(all_period, parseJson.getRule().getDays_information().get(i));
            days.add(day);
        }
        Map<String, Integer> all_bosses = new HashMap<>();
        for(int boss = 0 ; boss < parseJson.getRule().getBosses().size(); boss++){
            all_bosses.put(parseJson.getRule().getBosses().get(boss).getName(),0);
        }

        Map<String, Integer> all_engineer = new HashMap<>();
        for(int engineer = 0 ; engineer < parseJson.getRule().getBosses().size(); engineer++){
            all_engineer.put(parseJson.getRule().getBosses().get(engineer).getName(),0);
        }

        Map<String, Integer> all_employee = new HashMap<>();
        for(int secretary = 0 ; secretary < parseJson.getRule().getSecretaries().size(); secretary++){
            all_employee.put(parseJson.getRule().getSecretaries().get(secretary).getName(),0);
        }

        Map<String, Integer> all_master_student = new HashMap<>();
        for(int master_student = 0 ; master_student < parseJson.getRule().getSecretaries().size(); master_student++){
            all_master_student.put(parseJson.getRule().getSecretaries().get(master_student).getName(),0);
        }

        CurrentState current_state = new CurrentState(
                days,
                all_bosses,
                all_engineer,
                all_employee,
                all_master_student,
                1,
                0,
                0
        );
        aStarAlgorithmClass.aStarSearch(current_state);

//        Integer[] arr = {1,2,3,4,5};
//        combinations2(arr, 3, 0, new Integer[3]);
    }


}
