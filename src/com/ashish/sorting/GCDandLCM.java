package com.ashish.sorting;

public class GCDandLCM {

	public static void main(String[] args) {
		int[] arr = {2,4,6,8};
		int n = arr.length;
		System.out.println(findGCD(arr, n));
		System.out.println(findLCM(arr, n));
		
	}
	
	public static int gcd(int a, int b){
		if(a == 0)
			return b;
		
		return gcd(b%a, a);
	}
	public static int findGCD(int[] arr, int n){
		
		int result = arr[0];
		for(int i=1; i<n; i++){
			result = gcd(arr[i], result);
		}
		return result;
	}
	
	public static int findLCM(int[] arr, int n){
		
		int result = arr[0];
		for(int i = 1; i < arr.length; i++){
			result = arr[i]*result/gcd(arr[i],result);
		}
		return result;
	}
}
