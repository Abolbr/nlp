package cfg.parsing;


import cfg.CFG;
import cfg.NonTerminal;
import cfg.Symbol;
import cfg.Terminal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeftMostDeviration {

    public static final List<List<Symbol>> leftMostDerivation(CFG cfg)
    {
        List<List<Symbol>> result=new ArrayList<>();
        List<Symbol> symbols=new LinkedList<>();
        symbols.add(cfg.getStartSymbols().get(0));
        result.add(symbols);
        int i=0;
        while(true)
        {
            List<Symbol> leftMost=leftMostDerivation(symbols);
            if(equals(leftMost,symbols))
                break;
            symbols=leftMost;
            result.add(symbols);
            i++;
            if(i==10)
                break;
        }
        return result;
    }

    private static final List<Symbol> leftMostDerivation(List<Symbol> symbols)
    {
        List<Symbol> result=new ArrayList<>();
        int i=0;
        for(;i<symbols.size();i++)
        {
            if(symbols.get(i) instanceof Terminal)
            {
                result.add(symbols.get(i));
            }
            else if(symbols.get(i) instanceof NonTerminal)
            {
                NonTerminal nonTerminal=(NonTerminal)symbols.get(i);
                if(!nonTerminal.getRules().isEmpty())
                {
                    result.addAll(nonTerminal.getRules().get(nonTerminal.getRules().size()-1).getTarget());
                }
                i++;
                break;
            }
        }
        for(;i<symbols.size();i++)
        {
            result.add(symbols.get(i));
        }
        return result;
    }

    private static final boolean equals(List<Symbol> lst1,List<Symbol> lst2)
    {
        if(lst2.size()!=lst1.size())
            return false;
        for(int i=0;i<lst1.size();i++)
        {
            if(lst1.get(i)!=lst2.get(i))
                return false;
        }
        return true;
    }

}
