package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Correct_kuohao_20 {
	public static void main(String[] args) {
		boolean ret = function("(())");
		System.out.println(ret);
	}
	public static boolean function(String s){
		ArrayList<Character> stack = new ArrayList<Character>();
		stack.add('1');
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		for (int i =0;i<s.length();i++){
			char ss = s.charAt(i);
			if (stack.get(stack.size()-1)== map.get(ss)){
				stack.remove(stack.size()-1);
			}else{
				stack.add(ss);
			}
		}
		return stack.size() == 1;
	}

}
