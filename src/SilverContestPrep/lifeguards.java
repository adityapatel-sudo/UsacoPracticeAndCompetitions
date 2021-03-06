package SilverContestPrep;

import java.io.*;
import java.util.*;

public class lifeguards {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("lifeguards.in"));
        PrintWriter out = new PrintWriter(new FileWriter("lifeguards.out"));

        int n = scanner.nextInt();

        List<Timing> timings = new ArrayList<>();

        for(int i =0 ;i<n;i++){
            timings.add(new Timing(scanner.nextInt(),scanner.nextInt()));
        }

        Collections.sort(timings);
        if(checkSame(timings))out.println("0");

        out.println();
        for(Timing i : timings){
            out.println(i.toString());
        }
        out.close();
    }
    public static boolean checkSame(List<Timing> timings){
        for(int i = 0; i< timings.size()-1;i++){
            if(timings.get(i).start==timings.get(i+1).start)return true;
        }
        return false;
    }

}
class Timing implements Comparable<Timing>{
    int start;
    int end;
    int notOverlapped;
    public Timing(int start, int end){
        this.start=start;
        this.end=end;
    }

    @Override
    public String toString() {
        return start+" "+end+" "+notOverlapped;
    }

    @Override
    public int compareTo(Timing o) {
        if(this.start==o.start) return Integer.compare(this.end,o.end);
        else return Integer.compare(this.start,o.start);
    }
}
