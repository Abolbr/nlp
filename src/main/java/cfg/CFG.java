package cfg;

import java.util.List;

public class CFG {
    private final List<Terminal> terminalList;
    private final List<Terminal> nonTerminalList;
    private final List<Rule> rulesList;
    private final List<NonTerminal> startSymbols;

    public CFG(List<Terminal> terminalList, List<Terminal> nonTerminalList, List<Rule> rulesList, List<NonTerminal> startSymbols) {
        this.terminalList = terminalList;
        this.nonTerminalList = nonTerminalList;
        this.rulesList = rulesList;
        this.startSymbols = startSymbols;
    }

    public List<Terminal> getTerminalList() {
        return terminalList;
    }

    public List<Terminal> getNonTerminalList() {
        return nonTerminalList;
    }

    public List<Rule> getRulesList() {
        return rulesList;
    }

    public List<NonTerminal> getStartSymbols() {
        return startSymbols;
    }
}
