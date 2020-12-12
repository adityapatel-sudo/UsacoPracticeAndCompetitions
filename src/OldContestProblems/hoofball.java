package OldContestProblems;

import java.io.*;
import java.net.Inet4Address;
import java.util.*;
import java.util.List;

public class hoofball {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("hoofball.in"));
        PrintWriter out = new PrintWriter(new FileWriter("hoofball.out"));
        long start = System.currentTimeMillis();

        int max = scanner.nextInt();
        int[] cowLocations = new int[max];

        for(int i = 0; i<max;i++){
            cowLocations[i] = scanner.nextInt();
        }
        Arrays.sort(cowLocations);
        System.out.println(Arrays.toString(cowLocations));

        HashMap<Integer,List<Integer>> distances = findPasses(cowLocations);
        HashMap<Integer,Integer> cowLocationsMap = new HashMap<>();
        for(int i = 0; i< cowLocations.length;i++){
            cowLocationsMap.put(cowLocations[i],i);
        }
/*
        System.out.println(distances.toString());
        System.out.println(cowLocationsMap.toString());
        System.out.println("\n"+findLowestBalls(distances,cowLocationsMap));*/
        out.print(findLowestBalls(distances,cowLocationsMap));
        out.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static int findLowestBalls(HashMap<Integer,List<Integer>> distances,HashMap<Integer,Integer> cowLocationsMap){
        for(int i = 0; i < 100;i++) {
            if (checkBallWorks(i, distances, new boolean[distances.size()], 0, cowLocationsMap)) return i;
        }

        return -1;
    }

    public static boolean checkBallWorks(int balls, HashMap<Integer,List<Integer>> distances, boolean[] passedTo, int cursor,HashMap<Integer,Integer> cowLocationsMap){
        balls--;


        for(; cursor<distances.size(); cursor++){
            boolean[] notComplete = Arrays.copyOf(passedTo,passedTo.length);

            for(int i = 0; i<distances.get(cursor).size();i++){
                notComplete[cowLocationsMap.get(distances.get(cursor).get(i))] = true;
/*                System.out.println(Arrays.toString(notComplete)+" balls = "+ balls + " cursor = "+ cursor);
                System.out.printf("%1$-10s %2$10d      ",balls,cursor);*/
            }
            if(balls==0 && areAllTrue(notComplete)){
                return areAllTrue(notComplete);
            }
            if(balls>0 && checkBallWorks(balls,distances, notComplete,cursor+1, cowLocationsMap)) return true;
            if(cursor == distances.size()-1) return false;
        }
        return false;
    }

    public static boolean areAllTrue(boolean[] array) {
        for(boolean b : array) if(!b) return false;
        return true;
    }
    public static HashMap<Integer,List<Integer>> findPasses(int[] locs){
        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();
        for(int i = 0;i<locs.length;i++){
            hashMap.put(i,checkLeftAndRight(locs,i));
        }
        return hashMap;
    }
    public static List<Integer> checkLeftAndRight(int[] cowLocations, int x){
        if(checkLeft(cowLocations, x)>checkRight(cowLocations, x)){
            return numberRight(cowLocations, x);
        }else
            return numberLeft(cowLocations, x);
    }
    public static List<Integer> numberRight(int[] cowLocations, int x){
        List<Integer> list = new ArrayList<>();
        list.add(cowLocations[x]);
        if(x==cowLocations.length-1) return list;


        while(checkLeft(cowLocations, x)>checkRight(cowLocations,x)){
            x++;
            list.add(cowLocations[x]);

        }
        return list;
    }
    public static List<Integer> numberLeft(int[] cowLocations, int x){
        List<Integer> list = new ArrayList<>();
        list.add(cowLocations[x]);

        if(x==0) return list;
        while(checkLeft(cowLocations, x)<=checkRight(cowLocations,x)){
            x--;
            list.add(cowLocations[x]);

        }
        return list;
    }

    public static int checkRight(int[] cowLocations, int x){
        if (!isRight(cowLocations, x)) return Integer.MAX_VALUE;
        return cowLocations[x+1]-cowLocations[x];
    }
    public static int checkLeft(int[] cowLocations, int x){
        if(!isLeft(x)) return Integer.MAX_VALUE;
        return cowLocations[x]-cowLocations[x-1];
    }

    public static boolean isRight(int[] cowLocations, int x){
        return cowLocations.length >( x + 1);
    }
    public static boolean isLeft(int x){
        return x > 0;
    }

}
