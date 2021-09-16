package maxSubArray;

public class MaxSubArray {
    public static void main(String[] args) {
//        System.out.println(maxSubArrayBF(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArrayDnC(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }

    private static int maxSubArrayBF(int[] arr) {
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

    private static int maxSubArrayDnC(int[] arr) {
        return maxSub(arr, 0, arr.length - 1);
    }

    private static int maxSub(int[] arr, int low, int high) {
//        base condition
        if (low > high) return Integer.MIN_VALUE;

        int mid = (low + high) / 2;

        int curr = 0;
        int bestLeftHalf = 0;
        for (int i = mid - 1; i >= low; i--) {
            curr += arr[i];
            bestLeftHalf = Math.max(bestLeftHalf, curr);
        }
        curr = 0;
        int bestRightHalf = 0;
        for (int i = mid + 1; i <= high; i++) {
            curr += arr[i];
            bestRightHalf = Math.max(bestRightHalf, curr);
        }

        int combined = bestLeftHalf + arr[mid] + bestRightHalf;

        int leftSubArray = maxSub(arr, 0,mid -1);
        int rightSubArray = maxSub(arr, mid+1, high);

        return Math.max(combined, Math.max(leftSubArray,rightSubArray));
    }


}
