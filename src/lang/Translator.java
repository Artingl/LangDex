package lang;

import lang.*;

import java.util.Arrays;

public class Translator {

    public String translate(String[][] tokens)
    {
        StringBuilder result = new StringBuilder();
        int skip = 0;
        StringBuilder bof = new StringBuilder();
        StringBuilder code = new StringBuilder();
        StringBuilder eof = new StringBuilder();
        String namespace = "using namespace std;";

        bof.append("#include <string>\n").append(namespace).append("\n");

        for(int i = 0; i < tokens.length; i++)
        {
            if(skip != 0)
            {
                skip--;
                continue;
            }
            String[] token = tokens[i];
            if(token[1] == null) continue;

            if(token[1].equals("SIGN") || token[1].equals("OPERATOR") || token[1].equals("UNKNOWN"))
            {
                code.append(token[0]);
            }

            if(token[1].equals("TYPE"))
            {
                if(i != tokens.length - 1)
                {
                    if(tokens[i + 1][0].equals("funct"))
                    {
                        continue;
                    }
                }

                String[] checkResult = checkSymbols.check(dictionary.translate, token[0]);
                if(!checkResult[0].equals(""))
                {
                    code.append(" ").append(checkResult[1]).append(" ");
                }
                else {
                    code.append(" ").append(token[0]).append(" ");
                }

            }

            if(token[1].equals("INDET"))
            {
                if(token[0].equals("funct"))
                {

                    for(int j = i + 1; j < tokens.length; j++)
                    {
                        String[] token1 = tokens[j];
                        if(token1[1] == null) continue;

                        if(token1[1].equals("TYPE"))
                        {
                            if(!checkSymbols.check(dictionary.translate, token1[0])[1].equals(""))
                                token1[0] = checkSymbols.check(dictionary.translate, token1[0])[1];
                        }

                        if(j == i + 1)
                        {
                            if(i != 0)
                            {
                                String type = checkSymbols.check(dictionary.translate, tokens[i - 1][0])[1];
                                if(type.trim().equals("")) type = "void";

                                eof.append(" ").append(type).append(" ");
                            }
                            else {
                                eof.append(" void ");
                            }
                        }

                        eof.append(" ").append(token1[0]).append(" ");

                        skip++;
                    }

                    skip++;
                }
                else if(token[0].equals("import")) {
                    bof.append(" ").append(checkSymbols.check(dictionary.translate, token[0])[1]).append(" ");
                    String lastToken = "";
                    for(int j = i + 1; j < tokens.length; j++)
                    {
                        String[] token1 = tokens[j];
                        if(token1[1] == null) continue;

                        if(token1[0].equals(";")) break;
                        bof.append(token1[0]);


                        lastToken = token1[0];
                        skip++;
                    }

                    skip++;
                    if(lastToken.startsWith("\""))
                    {
                        bof = new StringBuilder(bof.toString().substring(0, bof.toString().length() - 1));
                        bof.append(".cpp\"\n");
                    }
                }
                else {
                    code.append(" ").append(token[0]).append(" ");
                }


            }


        }

        bof.append("\n").append(eof).append("\n");
        result.append(bof).append("\nint main(){ \n").append(code).append("\nreturn 0;\n }\n");

        return result.toString();
    }

}
