package GoldContest1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ModernArt3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] pattern = new int[n];
        for(int i =0 ; i < n;i++){
            pattern[i] = scanner.nextInt();
        }
        int[] vals = new int[n];
        checker(pattern,vals);
        System.out.println(Arrays.toString(vals));

    }
    public static void checker(int[] array,int[] vals){
        HashSet<Integer> usedNums = new HashSet<>();
        int count=0;
        for(int i =0 ;i < array.length;i++){
            if(usedNums.contains(array[i])){
                if(array[i]>array[i-1])count++;
                else
                    for(int j = i-1;j>=0;j--){
                        if(array[j]<array[i]) {
                            count++;
                            break;
                        }
                        if(array[j]==array[i]){
                            break;
                        }
                    }
            }else{
                usedNums.add(array[i]);
                count++;
            }
            vals[i] = count;
        }
    }
}
