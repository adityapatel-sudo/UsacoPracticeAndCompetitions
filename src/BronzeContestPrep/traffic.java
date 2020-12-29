package BronzeContestPrep;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class traffic {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("traffic.in"));
        PrintWriter out = new PrintWriter(new FileWriter("traffic.out"));


        int n = scanner.nextInt();
        ArrayList<Integer> sensorLocation = new ArrayList<Integer>(n);
        ArrayList<ArrayList<Integer>> speedsList = new ArrayList<>(n);

        String temp = "";

        for(int i =0;i< n; i++){
            temp =scanner.next();
            if(temp.equals("on")) sensorLocation.add(0);// if on ramp, loc is 0
            else if(temp.equals("none")) sensorLocation.add(1);// if betwee on ramps, loc is 1
            else if(temp.equals("off")) sensorLocation.add(2);//if off ramp, loc is 2


            ArrayList<Integer> speeds = new ArrayList<>(2);
            speeds.add(scanner.nextInt());
            speeds.add(scanner.nextInt());
            speedsList.add(speeds);
        }
        out.println(sensorLocation.toString());
        out.println(speedsList.toString());



        //find lower limit for start

        out.close();
    }
    static void simplifyArray(ArrayList<ArrayList<Integer>> speedsList, ArrayList<Integer> sensorLocation){
        boolean previousIsRoad = false;
        int min=0,max=0;
        for(int i= 0; i< sensorLocation.size();i++){
            if(!previousIsRoad&&sensorLocation.get(i)==1){
                previousIsRoad = true;
                min = speedsList.get(i).get(0);
                max = speedsList.get(i).get(1);
            }else if(previousIsRoad&&sensorLocation.get(i)==1){
                min = Math.max(min, speedsList.get(i).get(0));
                max = Math.min(max, speedsList.get(i).get(1));
                speedsList.remove(i-1);
                i--;
            }else if(previousIsRoad&&sensorLocation.get(i)!=1){

                min=0;max=0;previousIsRoad = false;
            }

        }
    }
}
