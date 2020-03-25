public class returnExercise {
    static int sum(int val1, int val2) {
        return val1 + val2;
    }
    public static void main(String[] args) {
        int added = 0;
        for(int i=0; i<5; i++) {
            System.out.println(added);
            added = sum(added, i);
        }
        System.out.println(added);
    }
}
