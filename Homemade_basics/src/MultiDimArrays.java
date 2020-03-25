public class MultiDimArrays {
    public static void main(String[] args) {
        int[][] someSample = {{1,2,3},{9,8,7}};
        someSample[0][0]=someSample[1][0];
        for (int[] y:someSample) {
            for (int z:y) {
                System.out.println(z);
            }
        }
      }
    }
