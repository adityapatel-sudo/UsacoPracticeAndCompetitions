package OldContestProblems;

import java.io.*;
import java.util.Scanner;

public class angry {
    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        Scanner scanner = new Scanner(new File("herding.in"));
        PrintWriter out = new PrintWriter(new FileWriter("angry.out"));

        boolean[] blocks = new boolean[100000001];
        int numBlocks = scanner.nextInt(), maxChanged=0, temp,maxBales=0;
        for(int i = 0;i<numBlocks;i++){
            temp = scanner.nextInt();
            if(temp>maxChanged){
                maxChanged = temp;
            }
            blocks[temp] = true;
        }

        for(int i = 0; i<=maxChanged;i++){
            if(blocks[i]){
                temp = checkLeft(blocks,i) + checkRight(blocks,i)+1;
                if(temp>maxBales){
                    maxBales = temp;
                }
            }
        }

        out.print(maxBales);

        out.close();
        long finish = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println((long)(finish-start)/1000000000.0);
        System.out.println(afterUsedMem-beforeUsedMem);
    }

    public static int checkRight(boolean[] array, int rightmostBlock){
        int boom = 1, numberBlown = 0,temp=0;
        boolean blockExists = true;

        while(blockExists){
            blockExists=false;
            for(int i =1; i<=boom && i+rightmostBlock<=100000001; i++){
                if(array[i+rightmostBlock]){
                    numberBlown++;
                    blockExists = true;
                    temp = i+rightmostBlock;
                }
            }
            rightmostBlock = temp;
            boom++;
        }
        return numberBlown;
    }


    public static int checkLeft(boolean[] array, int leftmostBlock){
        int boom = -1, numberBlown = 0,temp=0;
        boolean blockExists = true;

        while(blockExists){
            blockExists=false;
            for(int i = -1; i>=boom && i+leftmostBlock>=0; i--){
                if(array[i+leftmostBlock]){
                    numberBlown++;
                    blockExists = true;
                    temp = i+leftmostBlock;
                }
            }
            leftmostBlock = temp;
            boom--;
        }
        return numberBlown;
    }
}
