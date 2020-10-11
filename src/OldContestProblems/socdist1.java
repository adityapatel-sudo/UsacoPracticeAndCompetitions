package OldContestProblems;

/*
ID: adityap12
LANG: JAVA
TASK: socdist1
*/

import java.io.*;


public class socdist1 {
    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("socdist1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));

        int length = Integer.parseInt(f.readLine());

        int[] order = toArray(f.readLine());
        int largest = 0;
        int secondLargest = 0;

        ReturnThing returnThing = (smallestDist(order));
        largest = returnThing.largest;
        secondLargest = returnThing.secondLargest;
        int smallestAfter = returnThing.smallest;

        //finds first edge size
        int firstEdge = 0;
        while(firstEdge<order.length){
            if(order[firstEdge]==1) {
                break;
            }
            firstEdge++;
        }
        //finds last edge size
        int lastEdge = 0;
        while (lastEdge<order.length){
            if(order[order.length-1-lastEdge]==1){
                break;
            }
            lastEdge++;
        }

        System.out.print("firstEdge = "+ firstEdge+
                "\nlargest = "+ largest+
                "\nsecondLargest = "+ secondLargest+
                "\nlastEdge = "+ lastEdge);

        firstEdge = firstEdge * 3 / 2;
        lastEdge = lastEdge * 3 / 2;

        if(firstEdge>largest){
            secondLargest = largest;
            largest = firstEdge;
        }else if(firstEdge>secondLargest){
            secondLargest = firstEdge;
        }
        if(lastEdge>largest){
            secondLargest = largest;
            largest = lastEdge;
        }else if(lastEdge>secondLargest){
            secondLargest = lastEdge;
        }



        if(largest/2>=secondLargest){
            secondLargest = largest/3;
        }else if(secondLargest/2<smallestAfter){
            smallestAfter = secondLargest/2;
        }
        System.out.print("\n\nfirstEdge = "+ firstEdge+
                "\nlargest = "+ largest+
                "\nsecondLargest = "+ secondLargest+
                "\nlastEdge = "+ lastEdge);

        out.print(smallestAfter+1);
        out.close();
    }

    public static int[] toArray(String temp) {
        int[] order = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            order[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
        }
        return order;
    }

    public static ReturnThing smallestDist(int[] order) {
        int smallest = Integer.MAX_VALUE;
        int temp = 0;
        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < order.length; i++) {
            if (i == 0 && order[i] == 1) {
                continue;
            }
            if (order[i] == 0) {
                temp++;
            } else {

                if (smallest > temp) {
                    smallest = temp;
                }

                if (temp > largest) {
                    secondLargest = largest;
                    largest = temp;
                }else if(temp>secondLargest){
                    secondLargest = temp;
                }


                temp = 0;
            }
        }
        ReturnThing returnThing = new ReturnThing(smallest, largest, secondLargest);
        return returnThing;
    }

    public static class ReturnThing {
        public int smallest;
        public int largest;
        public int secondLargest;

        public ReturnThing(int smallest, int largest, int secondLargest) {
            this.smallest = smallest;
            this.largest = largest;
            this.secondLargest = secondLargest;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("smallest = " + smallest);
            sb.append("\nlargest = " + largest);
            sb.append("\nsecondLargest = " + secondLargest);

            return sb.toString();
        }
    }
}
