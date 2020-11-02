package lang;

public class checkSymbols {

    public static String[] check(String[][] symbols, String str)
    {
        for (String[] symbol : symbols)
            if (symbol[0].equals(str))
            {
                return symbol;
            }

        return new String[]{"", ""};
    }

}
