package Parse_Json;

import Model.Boss;
import Model.DayName;
import Model.Limitation;
import Model.Rule;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseJson {

    public ParseJson(Rule rule) {
        this.rule = rule;
    }

    private Rule rule;

    public void extract_data() {

    }

    public List<Boss> getBosses(JSONObject input_boss) {
        int watcher_count = input_boss.getInt("watch_count");
        List<Boss> bosses = new ArrayList<>();
        JSONArray names_json = input_boss.getJSONArray("names");
        for (int i = 0; i < names_json.length(); i++) {
            JSONObject name_item = names_json.getJSONObject(i);
            String boss_name = name_item.getString("boss_name");
            Limitation basic = getBasicLimitation(name_item);
            Limitation favorite = getFavoriteLimitation(name_item);
            bosses.add(new Boss(boss_name, basic, favorite));
        }
        return bosses;

    }

    private Limitation getBasicLimitation(JSONObject name_item) {
        JSONObject basic_limitation = name_item.getJSONObject("limitation").getJSONObject("basic_condition");
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
        int max_of_period = basic_limitation.getJSONObject("period_condition").getInt("count_of_period_max");
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

    private Limitation getFavoriteLimitation(JSONObject name_item) {
        JSONObject favorite_limitation_json = name_item.getJSONObject("limitation").getJSONObject("favorite_condition");
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


}
