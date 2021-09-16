package maxSubArray;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSub(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    private static int maxSub(int[] arr) {
        int bestSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if (bestSum < currentSum) {
                bestSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return bestSum;
    }
}
