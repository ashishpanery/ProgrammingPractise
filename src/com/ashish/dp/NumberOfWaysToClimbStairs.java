package com.ashish.dp;

public class NumberOfWaysToClimbStairs {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(countWays(24));
		System.out.println("Time1:"+(System.currentTimeMillis()-startTime));
		startTime = System.currentTimeMillis();
		System.out.println(countWaysDP(24, new int[36]));
		System.out.println("Time2:"+(System.currentTimeMillis()-startTime));
	}
	
	public static int countWays(int n){
		if(n < 0){
			return 0;
		}else if(n == 0){
			return 1;
		}else{
			return countWays(n-1)+ countWays(n-2)+ countWays(n-3);
		}
	}
	
	public static int countWaysDP(int n, int[] map){
		
		if(n < 0){
			return 0;
		}else if(n == 0){
			return 1;
		}else if(map[n]>0){
			return map[n];
		}else{
			return countWaysDP(n-1, map)+ countWaysDP(n-2, map)+ countWaysDP(n-3, map);
		}
	}
}
