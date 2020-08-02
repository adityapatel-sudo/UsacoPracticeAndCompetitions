package USACOTraining;

/*
ID: adityap12
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;
class friday {
    public static void main (String [] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);//Saturday
        map.put(1,0);//Sunday
        map.put(2,0);//Monday
        map.put(3,0);//Tuesday
        map.put(4,0);//Wednesday
        map.put(5,0);//Thursday
        map.put(6,0);//Friday

        int years = Integer.parseInt(f.readLine());
        int day = 0;//saturday
        System.out.println(0);

        for(int month = 0; month < years*12-1; month++){
             day = day + numberOfDays(month%12, 1900+(month/12));
             day=day%7;
             int temp = map.get(day);
             map.put(
                     day,
                     temp+1
             );
             System.out.println(day);
        }
        out.print(map.get(0)+" "+
                map.get(1)+" "+
                map.get(2)+" "+
                map.get(3)+" "+
                map.get(4)+" "+
                map.get(5)+" "+
                map.get(6)+" ");
        out.close();

    }


    public static int numberOfDays(int month, int year){
        return switch (month) {
            case 0, 2, 4, 6, 7, 9, 11 -> 31;
            case 3, 5, 8, 10 -> 30;
            case 1 -> isLeapYear(year) ? 29 : 28;
            default -> -1;
        };
    }


    public static boolean isLeapYear(int year){
        if(year%400==0){
            return true;
        }
        if(year%100==0){
            return false;
        }
        if(year%4==0){
            return true;
        }
        return false;
    }
}
