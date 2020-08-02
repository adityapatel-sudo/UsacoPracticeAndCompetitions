package USACOTraining;

/*
ID: adityap12
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main (String [] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));


        String lineOne = f.readLine();
        String lineTwo = f.readLine();
        int lineOneNum = 1;
        int lineTwoNum = 1;

        out.println("word 1: "+ lineOne);

        for(int i = 0; i<lineOne.length(); i ++){
            char ch = lineOne.charAt(i);
            int position = (int)ch - (int)'A' + 1;
            lineOneNum =  lineOneNum * position;
            out.println("position: "+ position);

        }
        out.println("word 2: "+ lineTwo);

        for(int i = 0; i<lineTwo.length(); i ++){
            char ch = lineTwo.charAt(i);
            int position = (int)ch - (int)'A' + 1;
            lineTwoNum = lineTwoNum * position;
            out.println("position: "+ position);
        }

        if(lineOneNum%47 == lineTwoNum%47){
            out.println("GO");
        }else{
            out.println("STAY");
        }
        out.println(lineOneNum + "\n" + lineTwoNum);
        out.close();



    }
}