package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permution_46 {
	public static List<List<Integer>> ret = new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		int[] nums = {1};
		List<List<Integer>> ret = permute(nums);
		System.out.println(ret);
	}

	public static List<List<Integer>> permute(int[] nums) {
		dfs(nums, 0, nums.length);
		return ret;
	}

	public static void dfs(int[] nums, int p, int q){
		if(q==p){
//			ret.add(System.arraycopy(nums, q, q, q, q));
			List<Integer> nums2 = new ArrayList<Integer>();
			for(int i=0;i<nums.length;i++){
				nums2.add(nums[i]); 
			}
			ret.add(nums2);
		}else{
			for (int i=p;i<q;i++){
				int temp = nums[i];
				nums[i] = nums[p];
				nums[p] = temp;
				dfs(nums,p+1, q);
				int temp2 = nums[i];
				nums[i] = nums[p];
				nums[p] = temp2;
			}
		}
	}
}