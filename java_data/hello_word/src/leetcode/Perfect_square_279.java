package leetcode;

import java.util.Arrays;

public class Perfect_square_279 {
	public static void main(String[] args) {
		int n = 12;
		int ret = function(n);
		System.out.println(ret);
	}

	private static int function(int n){
		int[] dp = new int[n+1];
		for (int i = 0;i < dp.length; i++){
			dp[i] = Integer.MAX_VALUE-1;
		}
		for (int i = 1; i < n+1; i++){
			for(int j =0;j*j<i; j++){
				if (is_square(i)){
					dp[i] = 1;
				}else{
					int c = Math.min(1+dp[i-j*j], dp[i]);
					dp[i] = c;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}

	private static boolean is_square(int i) {
		int c = (int) Math.sqrt(i);
		return c*c == i;
	}

}
