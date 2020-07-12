package lang;

import lang.*;

public class Parser {

    public String[][] tokens;

    public String[][] parse(String[][] lexeme)
    {
        tokens = new String[lexeme.length][4];

        for(int i = 0; i < lexeme.length; i++)
        {
            String[] token = lexeme[i];


            tokens[i] = token;
        }

        return tokens;
    }

}
