package OldContestProblems;

/*
ID: adityap12
LANG: JAVA
TASK: socdist1
*/

import java.io.*;
import java.util.Arrays;


public class socdist1 {
    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));

        f.readLine();

        int[] order = toArray(f.readLine());
        System.out.println("first value of 0:"+findLargest(order)[0]+"\nsize:"+findLargest(order)[1]);
        System.out.println("left 0s: "+ findLeft(order)+"\nright 0s: "+ findRight(order)+"\n\n\n");

        System.out.println(Arrays.toString(order));
        order = addOne(order);
        System.out.println(Arrays.toString(order));
        int smallest = Math.min(findSmallest(order),findLeft(order));
        smallest = Math.min(smallest,findRight(order));
        out.print(smallest);
        out.close();
    }

    public static int[] addOne(int[] before){
        int left = findLeft(before);
        int right = findRight(before);
        int largestSize = findLargest(before)[1];
        int largest = findLargest(before)[0];
        largestSize = largestSize - (largestSize/2);

        if(true){

        }else if(largestSize>=left&&largestSize>=right){
            before[largest+largestSize] = 1;
            before = doAgain(before);
        }else if(left>=right){
            before[0] = 1;
            before = doAgain(before);
        }else if(right>left){
            before[before.length-1] = 1;
            before = doAgain(before);
        }


        /*
        System.out.println("first value of 0:"+findLargest(before)[0]+"\nsize:"+findLargest(before)[1]);
        System.out.println("left 0s: "+ findLeft(before)+"\nright 0s: "+ findRight(before)+"\n\n\n");*/



        return before;
    }
    public static int[] doAgain(int[] before){
        int left = findLeft(before);
        int right = findRight(before);
        int largestSize = findLargest(before)[1];
        int largest = findLargest(before)[0];
        largestSize = largestSize - (largestSize/2);

        if(largestSize>=left&&largestSize>=right){
            before[largest+largestSize] = 1;
        }else if(left>=right){
            before[0] = 1;
        }else{
            before[before.length-1] = 1;
        }
        return new int[5];
    }
    public static int findLeft(int[] before){
        int i = 0;
        for(; i < before.length;i++){
            if(before[i]==1){
                return i;
            }
        }
        return i;
    }
    public static int findRight(int[] before){
        int i = before.length-1;
        for(; i >= 0;i--){
            if(before[i]==1){
                return (before.length-i-1);
            }
        }
        return i;
    }
    public static int[] findLargest(int[] before){
        //size is second value
        //place is first value(place is index of 1 before series)
        int largest = 0;
        int counterSoFar = 0;
        int cursor = 0;
        int[] toReturn= new int[2];
        int location = 0;

        while(0 == before[cursor]){
            cursor++;
        }

        for(; cursor <before.length-findRight(before);cursor++, counterSoFar++){
            if(before[cursor]==1){
                counterSoFar=0;
                location = cursor;
            }
            if(counterSoFar>largest){
                toReturn[0] = location;
                largest = counterSoFar;
            }
        }
        toReturn[1] = largest;
        return toReturn;
    }
    public static int findSmallest(int[] before){
        //size is second value
        //place is first value(place is index of 1 before series)
        int smallest = 1000000000;
        int counterSoFar = -1;
        int cursor = 0;

        while(0 == before[cursor]){
            cursor++;
        }

        boolean beforeIsOne = true;

        for(; cursor <before.length-findRight(before);cursor++, counterSoFar++){
            System.out.println("cursor: "+cursor+"countersofar: "+counterSoFar+"smallest; "+smallest);
            if(before[cursor]==1){
                if(counterSoFar<smallest&& !beforeIsOne){
                    smallest = counterSoFar;
                }
                beforeIsOne = true;
                counterSoFar=-1;
            }else {
                beforeIsOne = false;
            }
        }
        return smallest;
    }

    public static int[] toArray(String temp) {
        int[] order = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            order[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
        }
        return order;
    }
}
