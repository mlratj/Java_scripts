import java.util.Scanner;

public class Switching {
    public static void main(String[] args) {
        Scanner dayNum = new Scanner(System.in);
        System.out.print("Could you remind me how many days passed since Monday? \n");
        int input = dayNum.nextInt();
        String dayName = null;
    switch (input) {
        case 0:
            dayName = "Monday";
            break;
        case 1:
            dayName = "Tuesday";
            break;
        case 2:
            dayName = "Wednesday";
            break;
        case 3:
            dayName = "Thursday";
            break;
        default:
            System.out.println("It can't be!");
    }
    if (dayName != null) {
        System.out.println("Thanks, it must be " + dayName +" today.");
    }
    }
}
