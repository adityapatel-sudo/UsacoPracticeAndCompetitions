package USACOTraining;


/*
ID: adityap12
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.StringTokenizer;
public class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        f.readLine();
        String necklace = f.readLine();
        int largestCombo = 0;


        for(int i = 0;i<necklace.length();i++){
            if(checkBefore(necklace,i)+checkAfter(necklace,i)>largestCombo){
                largestCombo = checkBefore(necklace,i)+checkAfter(necklace,i);
                System.out.println(largestCombo);
            }

        }

        out.println(largestCombo);
        out.close();                                  // close the output file
    }


    public static int checkBefore(String necklace, int cutPoint){
        int counter = 0;
        char color = necklace.charAt(cutPoint);

        while(counter < necklace.length()){

            if(necklace.charAt(cutPoint) != color&&necklace.charAt(cutPoint) != 'w' ){
                break;
            }

            if(cutPoint==0){
                cutPoint=necklace.length()-1;
            }else{
                cutPoint--;
            }
            counter++;
        }

        return counter;
    }

    public static int checkAfter(String necklace, int cutPoint){
        if(cutPoint>necklace.length()-2){
            cutPoint=0;
        }else{
            cutPoint++;
        }
        int counter = 0;
        char color = necklace.charAt(cutPoint);

        while(counter < necklace.length()){

            if(necklace.charAt(cutPoint) != color&&necklace.charAt(cutPoint) != 'w' ){
                break;
            }

            if(cutPoint>necklace.length()-2){
                cutPoint=0;
            }else{
                cutPoint++;
            }
            counter++;
        }

        return counter;
    }
}
