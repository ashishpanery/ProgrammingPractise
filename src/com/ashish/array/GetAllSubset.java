package com.ashish.array;

import java.util.ArrayList;

public class GetAllSubset {
	
	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<>();
		set.add(1);
		set.add(2);
		set.add(3);
		ArrayList<ArrayList<Integer>> subsets =getSubSet(set, 0);
		subsets.forEach(sublist->{
			System.out.println(sublist);
		});
		
	}
	


	public static ArrayList<ArrayList<Integer>> getSubSet(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSubSet = new ArrayList<>();
		
		if(set.size() == index){
			allSubSet.add(new ArrayList<Integer>());
		}else{
			allSubSet = getSubSet(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allSubSet){
				ArrayList<Integer> newSubSet = new ArrayList<>();
				newSubSet.addAll(subset);
				newSubSet.add(item);
				moreSubSets.add(newSubSet);
			}
			allSubSet.addAll(moreSubSets);
		}
		System.out.println("index:"+index+", set:"+set+", allSubset:"+allSubSet);
		return allSubSet;
	}
}
