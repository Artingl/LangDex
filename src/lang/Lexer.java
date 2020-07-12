package lang;

import lang.*;

public class Lexer {

    public String[][] tokens;

    public String[][] getLexeme(String code)
    {
        tokens = new String[code.length()][4];
        String[] tmpString;
        StringBuilder nextToken = new StringBuilder();
        StringBuilder sAdd = new StringBuilder();
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
                    sAdd = new StringBuilder();
                    continue;
                }
            }

            if(skips)
            {
                sAdd.append(chr);
                continue;
            }

            tmpString = checkSymbols.check(dictionary.symbols, nextToken.toString().trim());
            if(!tmpString[0].equals(""))
            {
                tokens[count] = tmpString;
                nextToken = new StringBuilder();
                count++;
                continue;
            }

            tmpString = checkSymbols.check(dictionary.symbols, chr);
            if(!tmpString[0].equals(""))
            {
                if(!nextToken.toString().trim().equals(""))
                {
                    if(!chr.equals(nextToken.toString().trim()))
                    {
                        tokens[count] = new String[]{nextToken.toString().trim(), "UNKNOWN", "", ""};
                        nextToken = new StringBuilder();
                        count++;
                    }
                }

                tokens[count] = tmpString;
                count++;
                continue;
            }

            nextToken.append(chr);
        }

        return tokens;
    }

}
