
public class Main {
    public static void main(String[] args) {

        if(numberOfDays(1,1904)==29)
            System.out.println("yes");
        else
            System.out.println("no");
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
