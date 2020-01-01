package Parse_Json;

import Model.Rule;

public abstract class ParseJson {

    public ParseJson() {
        rule = new Rule();
    }

    private Rule rule;

    public abstract void extract_data();

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
}
