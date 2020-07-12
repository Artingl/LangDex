import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import lang.*;

public class main {

    public static void main(String[] args) throws Exception {
        String fileName = "code.ld";
        String code = delComments.del(readFile(fileName));

        Lexer lexer = new Lexer();

        String[][] lexeme = lexer.getLexeme(code);

        for (String[] strings : lexeme)
            if (strings[0] != null)
                System.out.println(Arrays.toString(strings));

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
