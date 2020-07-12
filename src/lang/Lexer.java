package lang;

import lang.*;

public class Lexer {

    public String[][] tokens;

    public String[][] getLexeme(String code)
    {
        tokens = new String[code.length()][4];
        String[] tmpString = new String[2];
        String nextToken = "";
        int count = 0;

        for(int i = 0; i < code.length(); i++)
        {
            String chr = String.valueOf((char ) code.getBytes()[i]);
            tmpString = checkSymbols.check(dictionary.symbols, nextToken);

            if(!tmpString[0].equals(""))
            {
                tokens[count] = tmpString;
                nextToken = "";
                count++;
            }

            tmpString = checkSymbols.check(dictionary.symbols, chr);
            if(!tmpString[0].equals(""))
            {
                tokens[count] = new String[]{nextToken.replace("\n", ""), "UNKNOWN", "", ""};
                nextToken = "";
                count++;

                tokens[count] = tmpString;
                count++;
            }

            nextToken += chr;
        }

        return tokens;
    }

}
