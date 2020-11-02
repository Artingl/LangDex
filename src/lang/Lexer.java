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
        boolean op = false;
        int skip = 0;

        for(int i = 0; i < code.length(); i++)
        {
            if(skip != 0)
            {
                skip--;
                continue;
            }
            String chr = String.valueOf((char ) code.getBytes()[i]);

            if(nextToken.toString().trim().equals("CPP"))
            {
                nextToken = new StringBuilder();
                String cpp = "";
                boolean start = false;
                int s = 0;
                for(int j = i; j < code.length(); j++)
                {
                    String c = String.valueOf((char ) code.getBytes()[j]);
                    if(c.equals("{") && !start)
                    {
                        start = true;
                        continue;
                    }

                    if(start)
                    {
                        if(c.equals("{")) s++;

                        if(c.equals("}") && s <= 0)
                        {
                            break;
                        }
                        else if(c.equals("}")) {
                            s--;
                        }

                        cpp += c;
                    }

                    skip++;
                }

                tokens[count] = new String[]{cpp.substring(0, cpp.length() - 1), "CPP"};
                count++;

                skip++;

                continue;
            }

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

           // boolean tmpB = false;
            tmpString = checkSymbols.check(dictionary.symbols, nextToken.toString().trim());
            if(!tmpString[0].equals(""))
            {
                tokens[count] = tmpString;
                nextToken = new StringBuilder();
                count++;
                //tmpB = true;
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
            //else if(tmpB) {
            //    continue;
            //}

            nextToken.append(chr);
        }

        return tokens;
    }

}
