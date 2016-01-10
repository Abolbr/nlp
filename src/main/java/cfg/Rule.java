package cfg;


import java.util.Collections;
import java.util.List;

public class Rule {
    private final NonTerminal source;
    private final List<Symbol> target;

    public Rule(NonTerminal source, List<Symbol> target) {
        this.source = source;
        this.target = target;
        source.rules.add(this);
    }

    public NonTerminal getSource() {
        return source;
    }

    public List<Symbol> getTarget() {
        return Collections.unmodifiableList(target);
    }
}
