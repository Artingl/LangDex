package lang;

import lang.*;

public class Lexer {

    public String[][] tokens;

    public String[][] getLexeme(String code)
    {
        tokens = new String[code.length()][4];
        String[] tmpString;
        String nextToken = "";
        String sAdd = "";
        int count = 0;
        boolean skips = false;

        for(int i = 0; i < code.length(); i++)
        {
            String chr = String.valueOf((char ) code.getBytes()[i]);

            if(chr.equals("\"") || chr.equals("'"))
            {
                skips = !skips;
                if(!skips)
                {
                    tokens[count] = new String[]{sAdd + chr, "UNKNOWN", "", ""};
                    count++;
                    sAdd = "";
                    continue;
                }
            }

            if(skips)
            {
                sAdd += chr;
                continue;
            }

            tmpString = checkSymbols.check(dictionary.symbols, nextToken.trim());
            if(!tmpString[0].equals(""))
            {
                tokens[count] = tmpString;
                nextToken = "";
                count++;
                continue;
            }

            tmpString = checkSymbols.check(dictionary.symbols, chr);
            if(!tmpString[0].equals(""))
            {
                if(!nextToken.trim().equals(""))
                {
                    if(!chr.equals(nextToken.trim()))
                    {
                        tokens[count] = new String[]{nextToken.trim(), "UNKNOWN", "", ""};
                        nextToken = "";
                        count++;
                    }
                }

                tokens[count] = tmpString;
                count++;
                continue;
            }

            nextToken += chr;
        }

        return tokens;
    }

}
