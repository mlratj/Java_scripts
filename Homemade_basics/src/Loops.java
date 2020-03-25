import java.util.Random;

public class Loops {
    public static void main(String[] args) {
        for (int x = 20; x > 0; x=x-calc(x))
                {
            System.out.println(x);
        }
    }

    private static int calc(int x) {
        Random random = new Random();
        return random.ints(0, 5).findFirst().getAsInt();
    }
}
