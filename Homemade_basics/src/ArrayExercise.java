public class ArrayExercise {
    public static void main(String[] args) {
        int[] myArray = new int[10]; // an empty array
        myArray = new int[]{3, 4, 56, 23};
        String[] myGoods = {"Table", "Knife", "Fridge", "Chair", "Chair"};
        System.out.println(myGoods[0]);
        System.out.println("Your array length is : " + myArray.length);
        int sum = 0;
        for(int x=0; x<myArray.length; x++) {
            sum += myArray[x];
        }
        System.out.println("Sum of elements is: "+sum);
    }
}
