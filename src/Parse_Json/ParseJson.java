package Parse_Json;

import File_Manager.FileReader;
import Models.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseJson {

    private Rule rule;

    public ParseJson() {
        FileReader file_reader = new FileReader("inputs/data.txt");
        JSONObject input_json = new JSONObject(file_reader.ReadInput());
        rule = new Rule(getTheaterInformation(input_json), getDayInformation(input_json), getBosses(input_json),
                getSecretary(input_json), getMasterStudent(input_json), getEmployee(input_json),
                getEmployeeWatches(input_json),getProfessorWatches(input_json),getEngineerWatches(input_json),
                getMasterWatches(input_json));

        System.out.println("");
    }


    private List<DayInformation> getDayInformation(JSONObject input_json) {
        List<DayInformation> days = new ArrayList<>();
        JSONArray days_json = input_json.getJSONArray("days");
        for (int i = 0; i < days_json.length(); i++) {
            JSONObject item_day = days_json.getJSONObject(i);
            String day_name = item_day.getString("day_name");
            JSONArray periods_json = item_day.getJSONArray("periods");
            List<PeriodInformation> periods = new ArrayList<>();
            for (int j = 0; j < periods_json.length(); j++) {
                JSONObject item_period = periods_json.getJSONObject(j);
                String subject_name = item_period.getString("subject_name");
                int total_student = item_period.getInt("total_student");
                periods.add(new PeriodInformation(subject_name, total_student));
            }
            days.add(new DayInformation(day_name, periods));
        }
        return days;
    }

    private List<Boss> getBosses(JSONObject input_json) {
        //int watcher_count = input_boss.getInt("watch_count");
        List<Boss> bosses = new ArrayList<>();
        JSONObject boss_json = input_json.getJSONObject("boss");
        JSONArray names_json = boss_json.getJSONArray("names");
        for (int i = 0; i < names_json.length(); i++) {
            JSONObject name_item = names_json.getJSONObject(i);
            String boss_name = name_item.getString("boss_name");
            Limitation basic = getBasicLimitation(name_item);
            Limitation favorite = getFavoriteLimitation(name_item);
            bosses.add(new Boss(boss_name, basic, favorite));
        }
        return bosses;
    }

    private Limitation getBasicLimitation(JSONObject input_json) {
        JSONObject basic_limitation = input_json.getJSONObject("limitation").getJSONObject("basic_condition");
        JSONArray can_get_days_condition_json_array = basic_limitation.getJSONObject("days_condition").getJSONArray("available_basic_day");
        JSONArray can_not_get_days_condition_json_array = basic_limitation.getJSONObject("days_condition").getJSONArray("unavailable_basic_day");
        List<DayName> can_get_day_condition = new ArrayList<>();
        for (int j = 0; j < can_get_days_condition_json_array.length(); j++) {
            can_get_day_condition.add(DayName.valueOf(can_get_days_condition_json_array.getString(j)));
        }
        List<DayName> cant_not_get_day_condition = new ArrayList<>();
        for (int j = 0; j < can_not_get_days_condition_json_array.length(); j++) {
            cant_not_get_day_condition.add(DayName.valueOf(can_not_get_days_condition_json_array.getString(j)));
        }

        JSONArray can_get_period_json_array = basic_limitation.getJSONObject("period_condition").getJSONArray("available_basic_period");
        JSONArray can_not_get_period_json_array = basic_limitation.getJSONObject("period_condition").getJSONArray("unavailable_basic_period");
        int max_of_period = basic_limitation.getJSONObject("period_condition").getInt("max_of_period");
        List<Integer> can_get_period = new ArrayList<>();
        for (int j = 0; j < can_get_period_json_array.length(); j++) {
            can_get_period.add(can_get_period_json_array.getInt(j));
        }
        List<Integer> cant_not_get_period = new ArrayList<>();
        for (int j = 0; j < can_not_get_period_json_array.length(); j++) {
            cant_not_get_period.add(can_not_get_period_json_array.getInt(j));
        }
        Limitation limitation = new Limitation(can_get_day_condition, cant_not_get_day_condition, can_get_period, cant_not_get_period, max_of_period);
        return limitation;
    }

    private Limitation getFavoriteLimitation(JSONObject input_json) {
        JSONObject favorite_limitation_json = input_json.getJSONObject("limitation").getJSONObject("favorite_condition");
        JSONArray can_getfavorite_json_array = favorite_limitation_json.getJSONObject("days_condition").getJSONArray("available_favorite_day");
        List<DayName> can_get_day_condition_favortie = new ArrayList<>();
        for (int j = 0; j < can_getfavorite_json_array.length(); j++) {
            can_get_day_condition_favortie.add(DayName.valueOf(can_getfavorite_json_array.getString(j)));
        }

        JSONArray can_get_period_favorite_json_array = favorite_limitation_json.getJSONObject("period_condition").getJSONArray("unavailable_favorite_period");
        List<Integer> can_get_period_favorite = new ArrayList<>();
        for (int j = 0; j < can_get_period_favorite_json_array.length(); j++) {
            can_get_period_favorite.add(can_get_period_favorite_json_array.getInt(j));
        }
        Limitation favorite_limitation = new Limitation(can_get_day_condition_favortie, null, can_get_period_favorite, null, null);
        return favorite_limitation;
    }

    private List<TheaterInformation> getTheaterInformation(JSONObject input_json) {
        List<TheaterInformation> theaters = new ArrayList<>();
        JSONArray theater_json = input_json.getJSONArray("theater");
        for (int i = 0; i < theater_json.length(); i++) {
            JSONObject item_theater = theater_json.getJSONObject(i);
            String theater_name = item_theater.getString("theater_name");
            int student_size = item_theater.getInt("student_size");
            int floor_number = item_theater.getInt("floor_number");
            int watcher_number = item_theater.getInt("watcher_number");
            theaters.add(new TheaterInformation(theater_name, student_size, floor_number, watcher_number));
        }
        return theaters;
    }

    private List<MasterStudent> getMasterStudent(JSONObject input_json) {
        // int watcher_count = input_boss.getInt("watch_count");
        List<MasterStudent> master_students = new ArrayList<>();
        JSONObject boss_json = input_json.getJSONObject("master_student");
        JSONArray names_json = boss_json.getJSONArray("names");
        for (int i = 0; i < names_json.length(); i++) {
            JSONObject name_item = names_json.getJSONObject(i);
            String boss_name = name_item.getString("boss_name");
            Limitation basic = getBasicLimitation(name_item);
            Limitation favorite = getFavoriteLimitation(name_item);
            master_students.add(new MasterStudent(boss_name, basic, favorite));
        }
        return master_students;
    }

    private List<Employee> getEmployee(JSONObject input_json) {
        List<Employee> employees = new ArrayList<>();
        JSONObject employee_json = input_json.getJSONObject("employee");
//        int watch_count = employee_json.getInt("watch_count");
        JSONArray names = employee_json.getJSONArray("names");
        for (int i = 0; i < names.length(); i++) {
            employees.add(new Employee(names.getJSONObject(i).getString("employee_name")));
        }
        return employees;
    }

    private List<Secretary> getSecretary(JSONObject input_json) {
        List<Secretary> secretaries = new ArrayList<>();
        JSONObject employee_json = input_json.getJSONObject("secretary");
//        int watch_count = employee_json.getInt("watch_count");
        JSONArray names = employee_json.getJSONArray("names");
        for (int i = 0; i < names.length(); i++) {
            secretaries.add(new Secretary(names.getJSONObject(i).getString("secretary_name")));
        }
        return secretaries;
    }

    private int getProfessorWatches(JSONObject input_json){
        JSONObject employee_json = input_json.getJSONObject("boss");
        return employee_json.getInt("watch_count");
    }

    private int getEngineerWatches(JSONObject input_json){
        JSONObject employee_json = input_json.getJSONObject("boss");
        return employee_json.getInt("watch_count");
    }

    private int getMasterWatches(JSONObject input_json){
        JSONObject employee_json = input_json.getJSONObject("master_student");
        return employee_json.getInt("watch_count");
    }

    private int getEmployeeWatches(JSONObject input_json){
        JSONObject employee_json = input_json.getJSONObject("secretary");
        return employee_json.getInt("watch_count");
    }



    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
}
