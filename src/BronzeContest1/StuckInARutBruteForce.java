package BronzeContest1;

//hardest problem in my first contest!!
//solved most test cases, but the three longest ones were unsuccessful
//http://www.usaco.org/index.php?page=viewproblem&cpid=1049

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class StuckInARutBruteForce{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int num = scanner.nextInt();
        StringBuilder direc = new StringBuilder();
        int[][] locations = new int[num][2];
        int[] numberMoves = new int[num];
        int yToCross = 0;
        int xToCross = 0;

        HashMap<Integer, int[]> eastMovingTracksHash = new HashMap<>();
        HashMap<Integer,int[]> northMovingTracksHash = new HashMap<>();
        int[] hashmapAnswers = new int[num];

        for(int i = 0;i< num;i++){
            direc.append(scanner.next().charAt(0));
            locations[i][0] = scanner.nextInt();
            locations[i][1] = scanner.nextInt();
            if(direc.charAt(direc.length()-1)=='E'&&locations[i][1]>yToCross) yToCross = locations[i][1];
            if(direc.charAt(direc.length()-1)=='N'&&locations[i][0]>xToCross) xToCross = locations[i][0];


            if(direc.charAt(direc.length()-1)=='E'){
                eastMovingTracksHash.put(locations[i][1],new int[]{locations[i][0],locations[i][0]});
                hashmapAnswers[i] = locations[i][1];
            }else{
                northMovingTracksHash.put(locations[i][0],new int[]{locations[i][1],locations[i][1]});
                hashmapAnswers[i] = locations[i][0];
            }
        }

/*
        out.println(direc.toString());
        out.println(Arrays.deepToString(locations));
        out.println(Arrays.deepToString(locations));

        out.println("x to cross is "+ xToCross);
        out.println("y to cross is "+ yToCross);

        out.println(Arrays.toString(eastMovingTracksHash.get(4)));
        out.println(Arrays.toString(eastMovingTracksHash.get(5)));
        out.println(Arrays.toString(eastMovingTracksHash.get(6)));
        out.println();
        out.println(Arrays.toString(northMovingTracksHash.get(5)));
        out.println(Arrays.toString(northMovingTracksHash.get(8)));
        out.println(Arrays.toString(northMovingTracksHash.get(11)));

*/



        for(int moves =0; moves == returnHighest(numberMoves) ;moves++){
            increaseLocations(locations,direc.toString(),numberMoves);



            //check tracks

            for(int i = 0;i<locations.length;i++){
                if(direc.charAt(i)=='E'
                        &&northMovingTracksHash.containsKey(locations[i][0])
                        &&northMovingTracksHash.get(locations[i][0])[1]>=locations[i][1]
                        &&northMovingTracksHash.get(locations[i][0])[0]<=locations[i][1]){
                    direc.delete(i,i+1);
                    direc.replace(i,i,"F");
                }else if(direc.charAt(i)=='N'
                        && eastMovingTracksHash.containsKey(locations[i][1])
                        && eastMovingTracksHash.get(locations[i][1])[1]>=locations[i][0]
                        && eastMovingTracksHash.get(locations[i][1])[0]<=locations[i][0]){
                    direc.delete(i,i+1);
                    direc.replace(i,i,"F");
                }
            }

            //checks infinity
            for(int i = 0;i< locations.length;i++){
                if(direc.charAt(i)=='E'&&locations[i][0]>xToCross){
                    numberMoves[i]=-1;
                    direc.delete(i,i+1);
                    direc.replace(i,i,"I");
                }
                else if(direc.charAt(i)=='N'&&locations[i][1]>yToCross){
                    numberMoves[i]=-1;
                    direc.delete(i,i+1);
                    direc.replace(i,i,"I");
                }
            }

            //increase tracks

            increaseTracks(eastMovingTracksHash,northMovingTracksHash, direc.toString(),hashmapAnswers);

        }

        for(int i = 0; i< numberMoves.length;i++){
            if(direc.charAt(i)=='F')
                out.println(numberMoves[i]);
            if(direc.charAt(i)=='I')
                out.println("Infinity");
        }

        out.close();
    }
    static void increaseLocations(int[][] locations, String direc,int[] numberMoves){
        for(int i = 0; i< locations.length;i++){
            if(direc.charAt(i)=='E'){
                locations[i][0] += 1;
                numberMoves[i] +=1;
            }
            else if(direc.charAt(i)=='N') {
                locations[i][1] += 1;
                numberMoves[i] +=1;
            }
        }
    }
    static void increaseTracks(HashMap<Integer, int[]> eastMovingTracksHash,HashMap<Integer,int[]> northMovingTracksHash, String direc,int[] hashmapAnswers){

        for(int i = 0; i< direc.length();i++){
            if(direc.charAt(i)=='E'){
                int[] temp = eastMovingTracksHash.get(hashmapAnswers[i]);
                temp[1] += 1;
                eastMovingTracksHash.replace(hashmapAnswers[i],temp);
            }
            else if(direc.charAt(i)=='N') {
                int[] temp = northMovingTracksHash.get(hashmapAnswers[i]);
                temp[1] += 1;
                northMovingTracksHash.replace(hashmapAnswers[i],temp);
            }
        }
    }

    static int returnHighest(int[] numberMoves){
        int max = 0;
        for(int i = 0; i< numberMoves.length;i++){
            if(numberMoves[i]>max) max = numberMoves[i];
        }
        return max;
    }
}