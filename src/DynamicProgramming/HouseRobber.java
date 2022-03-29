package DynamicProgramming;

import java.util.HashMap;

public class HouseRobber {
    /**
     * first we need to decide on state variables. state variables should be fully capable of describing a scenario. the
     * state variable here is an integer, to represent the index of the house you are currently at.
     */
    /*
    Top Down - Memoization
     */
    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private int[] nums;

    private int dp(int i) {
        // Base cases
        if (i == 0) return nums[0];
        if (i == 1) return Math.max(nums[0], nums[1]); // return the highest of either values
        if (!memo.containsKey(i)) {
            memo.put(i, Math.max(dp(i - 1), dp(i - 2) + nums[i])); // Recurrence relation
        }
        return memo.get(i);
    }

    public int robMemo(int[] nums) {
        this.nums = nums;
        return dp(nums.length - 1);
    }

    /*
    Bottom up - Tabulation
     */
    public int robTabu(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]); // Recurrence relation
        }

        return dp[nums.length - 1];
    }
}
