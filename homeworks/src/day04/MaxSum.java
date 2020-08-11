package day04;

/**
 * 배열의 연속합 최대 구하기
 *
 * 정수 배열에서 연속된 값의 합의 최대값을 구하시오.
 *
 * ex1) {1, 45, -2, 5, -6} => 1 + 45 + (-2) + 5 = 49
 * ex2) {-4, 5, 12, -7, 52, -5, 7} => 5 + 12 + (-7) + 52 + (-5) + 7 = 64
 *
 *
 * 인자
 * integers: 정수 배열
 */

public class MaxSum {
    public static void main(String[] args) {
        int[] integers = {-4, 7, 14, 9, -5, 4, 16, -22, 31};

        System.out.println(getMaxSum(new int[]{1, 45, -2, 5, -6}));
        System.out.println(getMaxSum(new int[]{-4, 5, 12, -7, 52, -5, 7}));
        System.out.println(getMaxSum(integers));


    }

    // O(N^2)
    private static int getMaxSum(int[] nums) {
        int max = 0, total = 0;

        for (int i : nums)
            total += i;

        // i = outer iteration
        // j = left ptr, k = right ptr
        for (int i = 0, k = nums.length - 1; i <= k; i++ ){
            int acc = 0;
            for (int j = i; j <= k; j++) {
                acc += nums[j];
                max = max > acc ? max : acc;
                if (total < total - nums[k]) {
                    total = total - nums[k];   // update total value
                    k--;                       // reduce right ptr
                }
            }
        }

        return max;
    }

    // O(N)
    private static int sum(int[] integers) {
        int maxSum = 0;
        int currSum = 0;
        for (int elem : integers) {
            currSum += elem;
            currSum = Math.max(currSum, elem);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
