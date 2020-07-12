package lang;

public class delComments {

    public static String del(String code)
    {
        StringBuilder result = new StringBuilder();
        boolean skipChar = false;

        for(int i = 0; i < code.split("\n").length; i++)
        {
            for(int j = 0; j < code.split("\n")[i].length(); j++)
            {
                String chr = String.valueOf((char ) code.split("\n")[i].getBytes()[j]);

                if(chr.equals("\"") || chr.equals("'"))
                {
                    skipChar = !skipChar;
                }

                if(skipChar)
                {
                    result.append(chr);
                    continue;
                }

                if(chr.equals("#")) break;

                result.append(chr);
            }

            result.append("\n");
        }

        return result.toString();
    }

}
