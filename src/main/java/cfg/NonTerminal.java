package cfg;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonTerminal extends Symbol{
    public NonTerminal(String value) {
        super(value);
        rules=new ArrayList<Rule>();
    }
    protected final List<Rule> rules;

    public List<Rule> getRules() {
        return rules;
    }

}
