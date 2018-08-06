package com.ashish.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    // Complete the closestColor function below.
    static List<String> closestColor(List<String> pixels) {
        List<String> result = new ArrayList<>();
        pixels.forEach(pixel->{
            int r = getIntValue(pixel.substring(0,7));
            int g = getIntValue(pixel.substring(8,15));
            int b = getIntValue(pixel.substring(16,23));
            result.add(getPixelColorValue(r,g,b));
            
        });
        return result;
    }
    static String getPixelColorValue(int r, int g, int b){
        
    //     Pure Black: d = ((0 -   0)2 + (255 -   0)2 + (6 -   0)2)1/2 =  650611/2 = 255.0705785
    // Pure White: d = ((0 - 255)2 + (255 - 255)2 + (6 - 255)2)1/2 = 1270261/2 = 356.4070706
    // Pure Red:   d = ((0 - 255)2 + (255 -   0)2 + (6 -   0)2)1/2 = 1300861/2 = 360.6743684
    // Pure Green: d = ((0 -   0)2 + (255 - 255)2 + (6 -   0)2)1/2 =     361/2 = 6 
    // Pure Blue:  d = ((0 -   0)2 + (255 -   0)2 + (6 - 255)2)1/2 = 1270261/2 = 356.4070706
        int d1 = (int) Math.sqrt(Math.pow(r-0, 2) + Math.pow(g-0, 2) + Math.pow(b-0, 2));
        int d2 = (int) Math.sqrt(Math.pow(r-255, 2) + Math.pow(g-255, 2) + Math.pow(b-255, 2));
        int d3 = (int) Math.sqrt(Math.pow(r-255, 2) + Math.pow(g-0, 2) + Math.pow(b-0, 2));
        int d4 = (int) Math.sqrt(Math.pow(r-0, 2) + Math.pow(g-255, 2) + Math.pow(b-0, 2));
        int d5 = (int) Math.sqrt(Math.pow(r-0, 2) + Math.pow(g-0, 2) + Math.pow(b-255, 2));
        System.out.println("d1="+d1+"d2="+d2+"d3="+d3+"d4="+d4+"d5="+d5);
        if(d1 <= d2 && d1 <= d3 && d1 <= d4 && d1 <= d5 ){
            return "Black";
        }else if(d2 <= d1 && d2 <= d3 && d2 <= d4 && d2 <= d5 ){
            return "White";
        }else if(d3 <= d1 && d3 <= d2 && d3 <= d4 && d3 <= d5 ){
            return "Red";
        }else if(d4 <= d1 && d4 <= d3 && d4 <= d2 && d4 <= d5 ){
            return "Green";
        }else if(d5 <= d1 && d5 <= d3 && d5 <= d4 && d5 <= d2 ){
            return "Blue";
        }
        System.out.println("d1="+d1+"d2="+d2+"d3="+d3+"d4="+d4+"d5="+d5);
        return "Ambiguous";
        
    }
    static int getIntValue(String str){
    	Integer.parseInt(str, 2);
        int val = Integer.parseInt(str, 2);;
        System.out.println(val);
        return val;
    }
    public static void main2(String[] args) {
		String pixel = "000000001111111111111111";
    	int r = getIntValue(pixel.substring(0,8));
        int g = getIntValue(pixel.substring(8,16));
        int b = getIntValue(pixel.substring(16,24));
        System.out.println(getPixelColorValue(r,g,b));
	}
    
    public static void main (String[] args)
    {
       
    	Scanner sc = new Scanner(System.in);
    	String string = sc.nextLine();
    	
        int chunksRequired = string.length() > 30 ? splitSMSIn10Chunks(string) : 1;
        if(chunksRequired==-1){
            System.out.println(splitSMSIn99Chunks(string));
        }else{
        	System.out.println(chunksRequired);
        }
    }
    
    

static String[] sortTheString(String[] strArr){

    for(int i=0; i< strArr.length-1; i++){
        for(int j=i+1; j< strArr.length; j++){
        
       if (strcmp(strArr[i], strArr[j]) > 0)
       {
             swap(strArr[i], strArr[j]);
       }
      }
    }
    return strArr;
}

static int strcmp(String a, String b){

    for(int i=0; i<a.length() && i<b.length(); i++){
        if(a.charAt(i) != b.charAt(i))
        return a.charAt(i) < b.charAt(i) ? -1 : 1;
    }
    return a.length() < b.length() ? -1 : a.length() == b.length() ? 0 : 1;

}

static void swap(String a, String b){
    String temp = a;
    a = b;
    b = temp;
}

static String[] splitTheString(String str){
        String[] sa = new String[100];

        // declare temporary string variable 
        StringBuffer token = new StringBuffer();
        // loop through string fetching one char at a time
        int index = 0;
        for(int i = 0; i< str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                if(token.length()>1){
                    sa[index++] = token.toString();
                    token.setLength(0);
                }

            } else {
                token.append(ch);
            }
        }
        return sa;
       
 }
	static int countSubarrays(int a[], int n, int m) {
		int count1=0;
		int[] dp = new int[n];
		  for(int i=0; i<n; i++){
            if(a[i]%2==1) {
                count1++;
            }

            dp[i] =count1;
        }

        int prev;
        int count=0;

        for(int i=0; i<n; i++) {
            prev= i==0 ? 0:dp[i-1];
            for(int j=i; j<n; j++) {
                if((dp[j] - prev) == m){
                    count++;
                }

                if(dp[j] - prev > m){
                    break;
                }
            }
        }
        return count;
       }
	
	static int splitSMSIn10Chunks(String string){
	    String parts[] = string.split(" ");
	    String suffix = "(x/y)";
	    int chunks = 0;
	    String currentChunk = "";
	    for(int i=0;i<parts.length;i++){ 

	        if((currentChunk.length()+1+parts[i].length()+suffix.length())<=30){
	            currentChunk = currentChunk + parts[i] + " ";
	        }else{            
	            currentChunk = currentChunk + suffix;
	            currentChunk = parts[i]+" " ;
	            chunks++;
	        }        
	        if(i==parts.length-1){
	            //Last chunk
	            currentChunk = currentChunk + suffix;
	            chunks++;
	        }
	        if(chunks==10) return -1;
	    }
	    return chunks;
	}
	static int splitSMSIn99Chunks(String string){

		String parts[] = string.split(" ");
	    String suffix = "(x/y)";
	    int chunks = 0;
	    String currentChunk = "";
	    for(int i=0;i<parts.length;i++){ 

	        if((currentChunk.length()+1+parts[i].length()+suffix.length())<=30){
	            currentChunk = currentChunk + parts[i] + " ";
	        }else{            
	            currentChunk = currentChunk + suffix;
	            currentChunk = parts[i]+" " ;
	            chunks++;
	            if(chunks==9){
	                suffix = "(xx/yy)";
	            }
	        }        

	        if(i==parts.length-1){
	            //Last chunk
	            currentChunk = currentChunk + suffix;
	            chunks++;
	        }
	    }
	    return chunks;
	}
	

}
