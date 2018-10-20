package leetcode;

import java.util.Arrays;

public class Coin_change_322 {
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		int ret = function(coins, amount);
		System.out.println(ret);
	}

	private static int function(int[] coins, int amount) {
		int[][] dp = new int[coins.length+1][amount+1];
		for(int i = 0;i<coins.length+1;i++){
			for(int j = 0; j < amount+1;j++){
				if(j != 0){
					dp[i][j] = Integer.MAX_VALUE-1;
				}
			}
		}
		for(int i = 1;i<coins.length+1;i++){
			for(int j = 1; j < amount+1;j++){
				if (j <coins[i-1]){
					dp[i][j] = dp[i-1][j];
				}else{
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
				}
			}
		}
		System.out.println(Arrays.toString(dp[coins.length]));
		if(dp[coins.length][amount] == Integer.MAX_VALUE-1){
			return -1;
		}else{
			return dp[coins.length][amount];
		}
	}

}
