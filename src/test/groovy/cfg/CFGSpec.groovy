package cfg

import cfg.parsing.LeftMostDeviration
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class CFGSpec extends Specification{
    @Shared
    private CFG cfg;

    def setup()
    {
        if(!cfg)
        {
            //terminals
            Terminal sleeps=new Terminal('sleeps')
            Terminal saw=new Terminal('saw')
            Terminal man=new Terminal('man')
            Terminal woman=new Terminal('woman')
            Terminal telescope=new Terminal('telescope')
            Terminal dog=new Terminal('dog')
            Terminal the=new Terminal('the')
            Terminal with=new Terminal('with')
            Terminal _in=new Terminal('in')
            List<Terminal> terminalList=new ArrayList<>();
            terminalList<<sleeps
            terminalList<<saw
            terminalList<<man
            terminalList<<woman
            terminalList<<telescope
            terminalList<<dog
            terminalList<<the
            terminalList<<with
            terminalList<<_in
            // non terminals
            NonTerminal S=new NonTerminal('S')
            NonTerminal NP=new NonTerminal('NP')
            NonTerminal VP=new NonTerminal('VP')
            NonTerminal PP=new NonTerminal('PP')
            NonTerminal DT=new NonTerminal('DT')
            NonTerminal Vi=new NonTerminal('Vi')
            NonTerminal Vt=new NonTerminal('Vt')
            NonTerminal NN=new NonTerminal('NN')
            NonTerminal IN=new NonTerminal('IN')
            ArrayList<NonTerminal> nonTerminalList=new ArrayList<>();
            nonTerminalList<<S
            nonTerminalList<<NP
            nonTerminalList<<VP
            nonTerminalList<<PP
            nonTerminalList<<DT
            nonTerminalList<<Vi
            nonTerminalList<<Vt
            nonTerminalList<<NN
            nonTerminalList<<IN
            //rules
            List<Rule> rules=new ArrayList<>();
            rules<<new Rule(S,[NP,VP])

            rules<<new Rule(VP,[Vi])
            rules<<new Rule(VP,[Vt,NP])
            rules<<new Rule(VP,[VP,PP])

            rules<<new Rule(NP,[DT,NN])
            rules<<new Rule(NP,[NP,PP])

            rules<<new Rule(PP,[IN,NP])


            rules<<new Rule(Vi,[sleeps])
            rules<<new Rule(Vt,[saw])

            rules<<new Rule(NN,[man])
            rules<<new Rule(NN,[dog])
            rules<<new Rule(NN,[woman])
            rules<<new Rule(NN,[telescope])

            rules<<new Rule(DT,[the])

            rules<<new Rule(IN,[with])
            rules<<new Rule(IN,[_in])


            cfg=new CFG(terminalList,nonTerminalList,rules,Collections.singletonList(S))
        }
    }

    def "show"()
    {
        when :
            List<List<Symbol>> result=LeftMostDeviration.leftMostDerivation(cfg)
            for(List<Symbol> lst:result)
            {
                println(symbolListToString(lst))
            }
        then :true
    }


    static String symbolListToString(List<Symbol> symbolList){
        String str='';
        for(Symbol symbol:symbolList)
            str+=' '+symbol.value
        return str.trim()
    }

}