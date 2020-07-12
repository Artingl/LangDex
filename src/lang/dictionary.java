package lang;

public class dictionary {

    public static String[][] symbols = {
            {"funct", "INDET"},
            {"while", "INDET"},
            {"for", "INDET"},
            {"if", "INDET"},
            {"else", "INDET"},
            {"return", "INDET"},
            {"import", "INDET"},
            {"do", "INDET"},

            {"[", "SIGN"},
            {"]", "SIGN"},
            {"(", "SIGN"},
            {")", "SIGN"},
            {"{", "SIGN"},
            {"}", "SIGN"},
            {".", "SIGN"},
            {";", "SIGN"},
            {",", "SIGN"},

            {"int", "TYPE"},
            {"String", "TYPE"},
            {"boolean", "TYPE"},
            {"char", "TYPE"},
            {"NULL", "TYPE"},

            {"-", "OPERATOR"},
            {"^", "OPERATOR"},
            {"+", "OPERATOR"},
            {"=", "OPERATOR"},
            {"*", "OPERATOR"},
            {"/", "OPERATOR"},
            {"%", "OPERATOR"},
            {"<", "OPERATOR"},
            {">", "OPERATOR"},
            {":", "OPERATOR"},
    };

    public static String[][] translate = {

            {"boolean", "bool"},
            {"int", "int"},
            {"String", "string"},
            {"import", "#include"},

    };

}
