package Parse_Json;

import File_Manager.FileReader;
import Model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseJson {


    public ParseJson() {
        rule=new Rule();
    }

    private Rule rule;

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public void extract_data() {
        String data = new FileReader("inputs/data.txt").ReadInput();
        JSONObject input = new JSONObject(data);
        JSONArray days_json = input.getJSONArray("days");
        List<DayInformation> days = new ArrayList<>();
        for (int count = 0; count < days_json.length(); count++) {
            List<PeriodInformation> periods_information = new ArrayList<>();
            periods_information.add(new PeriodInformation(days_json.getJSONObject(count).getString("day_name"), 1));

            System.out.println("s");
        }


    }

    public List<MasterStudent> add_master_students(JSONObject input)
    {
        JSONObject master_students_json=input.getJSONObject("master_student");
        rule.setMaster_student_watches(master_students_json.getInt("watch_count"));
        JSONArray master_students_names_json=input.getJSONArray("");


        return null;
    }

}
