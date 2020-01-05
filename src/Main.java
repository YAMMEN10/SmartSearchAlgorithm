import A_Star.AStarAlgorithmClass;
import Models.Day_Classes.Day;
import Models.Period_Classes.Period;
import Models.State_Classes.CurrentState;
import Parse_Json.ParseJson;

import java.util.ArrayList;
import java.util.List;

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
        CurrentState current_state = new CurrentState(
                days,
                1,
                0,
                0
        );
        aStarAlgorithmClass.aStarSearch(current_state);
    }
}
