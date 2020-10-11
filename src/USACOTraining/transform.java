package USACOTraining;

/*
ID: adityap12
LANG: JAVA
TASK: transform
*/

import java.io.*;
public class transform {
    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        f.readLine();
        String necklace = f.readLine();
        int largestCombo = 0;




        out.println(largestCombo);
        out.close();                                  // close the output file
    }
}
