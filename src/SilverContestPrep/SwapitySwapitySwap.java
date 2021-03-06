package SilverContestPrep;

import java.util.ArrayList;
import java.util.Arrays;

public class SwapitySwapitySwap {
    public static void main(String[] args){

        ArrayList<String> list = new ArrayList<>(5);
        list.add("It");
        list.add("was");
        list.add("a");
        list.add("stormy");
        list.add("night");
        System.out.println(list);
    }
    public static boolean vasuRetarded(int x, int y,String[][] map, boolean[][] backCheck){
        if(backCheck[y][x])return false;
        backCheck[y][x] = true;

        if(map[y][x].equals("E")){
            return true;
        }

        if(x>0 && vasuRetarded(x-1,y,map, backCheck))
            return  true;
        if(x<map.length-1 && vasuRetarded(x+1,y,map, backCheck))
            return true;
        if(y>0 && vasuRetarded(x,y-1,map, backCheck))
            return true;
        if(y<map.length-1 && vasuRetarded(x,y+1,map, backCheck))
            return true;


        return false;
    }
}
