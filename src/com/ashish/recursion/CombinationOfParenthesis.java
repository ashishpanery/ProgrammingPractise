package com.ashish.recursion;

import java.util.HashSet;
import java.util.Set;

public class CombinationOfParenthesis {
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	public static Set<String> generateParenthesis(int remaining){
		Set<String> set = new HashSet<>();
		if(remaining == 0){
			set.add("");
		}else{
			Set<String> prev = generateParenthesis(remaining-1);
			System.out.println(prev.size());
			for(String str : prev){
				for(int i =0; i< str.length(); i++){
					if(str.charAt(i) == '('){
						String s = insertInside(str, i);
						set.add(s);
					}
				}
				if(!set.contains("()"+str)){
					set.add("()"+str);
				}
			}
		}
		return set;
	}
	
	public static String insertInside(String s, int index){
		String start = s.substring(0, index+1);
		String end = s.substring(index+1);
		return start+"()"+end;
	}
}
