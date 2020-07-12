import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import lang.*;

public class main {

    public static void main(String[] args) throws Exception {
        String fileName = "code.ld";
        String code = delComments.del(readFile(fileName));

        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        Translator translator = new Translator();

        String[][] lexeme = lexer.getLexeme(code);
        String[][] parse = parser.parse(lexeme);
        String cppCode = translator.translate(parse);

        putCode(cppCode);

/*        for (String[] strings : parse)
            if (strings[0] != null)
                System.out.println(Arrays.toString(strings));*/

    }

    private static void putCode(String code) throws IOException {
        FileWriter fw = new FileWriter("cpp/code.cpp");
        fw.write(code);
        fw.close();

        Runtime runTime = Runtime.getRuntime();
        Process process = runTime.exec("mingw64/bin/g++.exe cpp/code.cpp");

        System.out.println(process.getInputStream().read());
    }

    private static String readFile(String fileName) throws Exception {
        StringBuilder s = new StringBuilder();

        try {
            BufferedReader br = null;
            String line = "";

            br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine()) != null)
            {
                s.append(line).append("\n");
            }

            br.close();
        } catch (IOException e) {
            throw new Exception("file not found!");
        }


        return s.toString();
    }

}
