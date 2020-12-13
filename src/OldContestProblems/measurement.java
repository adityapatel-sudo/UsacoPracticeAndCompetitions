package OldContestProblems;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class measurement {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("herding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        int[][] cows = new int[3][100];
        int totalChanges = scanner.nextInt(), billboardSwitch = 0,startInclusive,changeBy,tempCow;


        /* Mildred is 0
        Elsie is 1
        Bessie is 2
         */
        cows[0] = changeVals(cows[0], 1,7);
        cows[1] = changeVals(cows[1], 1,7);
        cows[2] = changeVals(cows[2], 1,7);

        for(; totalChanges>0; totalChanges--){
            startInclusive = scanner.nextInt();
            tempCow = getCow(scanner.next());
            changeBy = parseString(scanner.nextLine());

            cows[tempCow] = changeVals(cows[tempCow],startInclusive,changeBy);
            print2DArray(cows);
        }

        if(checkChanged(new int[]{cows[0][0],cows[1][0],cows[2][0]},new int[]{7,7,7}))
            billboardSwitch++;
        for(int i = 1; i<100;i++){
            int[] before = new int[]{cows[0][i],cows[1][i],cows[2][i]};
            int[] after = new int[]{cows[0][i-1],cows[1][i-1],cows[2][i-1]};
            if(checkChanged(before,after)){
                billboardSwitch++;
                System.out.println("changed on : "+(i-1));
            }
        }
        out.print(billboardSwitch);


        out.close();
    }
    public static Boolean checkChanged(int[] before, int[] after){

        if(!Arrays.equals(checkValOnDay(before), checkValOnDay(after))){
            return true;
        }
        return false;
    }

    public static int[] checkValOnDay(int[] array){
        int max = -1;
        int[] toReturn = new int[3];
        for(int i =0;i<3;i++){
            if(array[i]>max){
                max = array[i];
                toReturn = new int[3];
                toReturn[i] = 1;
            }else if(array[i] == max){
                toReturn[i] = 1;
            }
        }
        return toReturn;
    }

    public static int[] changeVals(int[] array, int startInclusive , int changeBy){
        for(int i = startInclusive-1; i< array.length;i++){
            array[i] = array[i] + changeBy;
        }
        return array;
    }
    public static int getCow(String name){

        if(name.equals("Mildred")){
            return 0;
        }else if(name.equals("Elsie"))
            return 1;
        else //Bessie
            return 2;
    }
    public static void print2DArray(int[][] array){
        for(int i = 0; i< array.length;i++){
            for(int j = 0; j < array[0].length;j++){
                System.out.printf("%3d ",array[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
    public static int parseString(String n){
        int i = Integer.parseInt(n.substring(2,n.length()));
        if(n.charAt(1)=='-')
            i *= -1;
        return i;
    }
}
