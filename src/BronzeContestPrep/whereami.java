package BronzeContestPrep;
//messed up on some test cases... Solution more simple than this: http://www.usaco.org/current/data/sol_whereami_bronze_dec19.html
//http://www.usaco.org/index.php?page=viewproblem2&cpid=964#
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class whereami {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("lifeguards.in"));
        PrintWriter out = new PrintWriter(new FileWriter("whereami.out"));

        int n = scanner.nextInt();
        String letter = scanner.next();
        int max = 0;
        int repeatLoc = 0;
        int temp = 0;

        HashMap<Character,Integer> repeats= new HashMap<>();

        for(int i = 0; i < letter.length();i++){
            if(repeats.containsKey(letter.charAt(i))){
                repeatLoc = repeats.get(letter.charAt(i));
                temp = findLength(letter,i,repeatLoc);
                if(temp>max) max = temp;
            }

            repeats.put(letter.charAt(i),i);
        }
        out.print(max+1);
        out.close();
    }
    static int findLength(String letters,int i,int repeatLoc){
        int sameLength =0;
        for(; sameLength< letters.length()-i&&sameLength<letters.length()-repeatLoc;sameLength++){
            if(letters.charAt(i+sameLength)!=letters.charAt(repeatLoc+sameLength)) break;
        }
        System.out.println("i is "+i+" and repeatLoc is "+repeatLoc+" and sameLength is "+sameLength);
        return sameLength;
    }
}
