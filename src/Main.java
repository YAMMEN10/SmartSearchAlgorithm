import A_Star.AStar;
import Parse_Json.ParseJson;

public class Main {

    public static void main(String[] args)
    {
        ParseJson parseJson=new ParseJson();
        AStar aStar=new AStar(parseJson.getRule());
    }
}
