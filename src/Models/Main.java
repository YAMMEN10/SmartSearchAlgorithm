import File_Manager.FileReader;
import Parse_Json.ParseJson;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        // write your code here
        FileReader file_reader = new FileReader("inputs/data.txt");
        JSONObject input_json = new JSONObject(file_reader.ReadInput());
        ParseJson parse_json = new ParseJson();
        parse_json.extract_data(input_json);
    }
}
