import java.io.*;
import java.util.Arrays;

import lang.*;

public class main {

    public static void main(String[] args) throws Exception {
        String fileName = getArg(args, "-f");
        String code = delComments.del(readFile(fileName));
        String m = getArg(args, "-nm");

        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        Translator translator = new Translator();

        String[][] lexeme = lexer.getLexeme(code);
        String[][] parse = parser.parse(lexeme);
        String cppCode = translator.translate(parse, m);

        putCode(cppCode);

/*        for (String[] strings : parse)
            if (strings[0] != null)
                System.out.println(Arrays.toString(strings));*/

    }

    private static String getArg(String[] args, String arg)
    {
        for(int i = 0; i < args.length; i++)
        {
            if(args[i].equals(arg))
                return "true";
            else if(args[i].split("=")[0].equals(arg))
                return args[i].split("=")[1];
        }

        return "";
    }

    private static void putCode(String code) throws IOException, InterruptedException {
        FileWriter fw = new FileWriter("cpp/code.cpp");
        fw.write(code);
        fw.close();

        //Runtime runTime = Runtime.getRuntime();
        //Process process = runTime.exec("mingw64/bin/g++.exe cpp/code.cpp");

        ProcessBuilder   ps=new ProcessBuilder("mingw64/bin/g++.exe","cpp/code.cpp");
        ps.redirectErrorStream(true);

        Process pr = ps.start();

        BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line, res = "";
        while ((line = in.readLine()) != null) {
            res += line + "\n";
        }
        pr.waitFor();
        in.close();

        if (!res.equals(""))
        {
            System.out.println("CPP ERROR: -->");
            System.out.print(res);
            System.out.println("<--");
        }
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
