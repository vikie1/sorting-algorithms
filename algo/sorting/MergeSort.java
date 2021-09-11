package algo.sorting;

import algo.util.Results;

public class MergeSort {
	long comparisons;
	long movements;
	
	/**	The method for sorting the numbers */
	public static Results mergeSort(int[] list) {
		MergeSort mergeSort = new MergeSort();
		mergeSort.incrementComparisons();
		long start = System.currentTimeMillis();
		if (list.length > 1) {
			//	Merge sort the first half
			int [] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort.incrementMovements();
			mergeSort(firstHalf);
			
			//Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			mergeSort.incrementMovements();
			System.arraycopy(list, list.length / 2, 
				secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			
			//	Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list, mergeSort);
		}
		long end = System.currentTimeMillis();
		Results results = new Results();
		results.setSort("Merge sort");
		results.setComparisons(mergeSort.getComparisons());
		results.setMovements(mergeSort.getMovements());
		results.setDuration(end - start);
		results.setN(list.length);
		return results;
	}
	
	/** Merge two sorted list */
	public static void merge(int[] list1, int[] list2, int[] temp,MergeSort mergeSort) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp
		
		while (current1 < list1.length && current2 < list2.length) {
			mergeSort.incrementComparisons();
			mergeSort.incrementMovements();
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
				
		}
		
		while (current1 < list1.length){
			temp[current3++] = list1[current1++];
			mergeSort.incrementMovements();
		}
		
		while (current2 < list2.length){
			temp[current3++] = list2[current2++];
			mergeSort.incrementMovements();
		}

	}

	void incrementComparisons(){
		comparisons ++;
	}
	void incrementMovements(){
		movements ++;
	}
	
	/**
	 * @return the comparisons
	 */
	public long getComparisons() {
		return comparisons;
	}
	/**
	 * @return the movements
	 */
	public long getMovements() {
		return movements;
	}
	/**
	/** A test method *
	public static void main(String[] args) {
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		mergeSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.println(list[i] + " ");
	}
	*/
}