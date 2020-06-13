import java.util.Scanner;

public class RateUs {
    public static void main(String[] args) throws Exception {
        Scanner myNum = new Scanner(System.in);
        System.out.println("Please rate our services: \n");
        String input = myNum.nextLine();
        int counter = 5;
            do {
                try {
                    int grade = Integer.parseInt(input);
                    System.out.println("You gave us: " + grade + " points!");
                    break;
                } catch (Exception e) {
                    if (counter == 5) {
                        System.out.println("Invalid input :(");
                    }
                    System.out.println("Shutting app down in " +counter);
                    counter--;
                }
            }
            while (counter > 0);
        System.out.println("Thank you for using our app!");
        }

    }