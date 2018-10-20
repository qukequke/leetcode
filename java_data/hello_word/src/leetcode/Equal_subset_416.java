package leetcode;

public class Equal_subset_416 {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 5, 11, 4};
		boolean ret = function(nums);
		System.out.println(ret);
	}

	public static boolean function(int[] nums) {
		int target = 0;
		for (int i:nums){
			target += i;
		}
		if (target % 2 == 1){
			return false;
		}else{
			target /= 2;
			int [][] dp = new int[nums.length+1][target+1];
			for(int i= 1;i<nums.length+1;i++){
				for (int j = 1;j<target+1;j++){
					if (nums[i-1] > j){
						dp[i][j] = dp[i-1][j];
					}else{
						dp[i][j] = Math.max(dp[i-1][j-nums[i-1]]+nums[i-1], dp[i-1][j]);
					}
				}
			}
			return dp[nums.length][target] == target;
		}
		
	}

}
