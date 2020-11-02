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
            {"break", "INDET"},
            {"define", "INDET"},

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
            {"Str", "TYPE"},
            {"str", "TYPE"},
            {"boolean", "TYPE"},
            {"char", "TYPE"},
            {"empty", "TYPE"},
            {"short", "TYPE"},
            {"NULL", "TYPE"},

            {"-", "OPERATOR"},
            {"^", "OPERATOR"},
            {"+", "OPERATOR"},
            {"!", "OPERATOR"},
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
            {"Str", "string"},
            {"str", "string"},

            {"import", "#include"},
            {"define", "#define"},
            {"empty", "void"}

    };

}
