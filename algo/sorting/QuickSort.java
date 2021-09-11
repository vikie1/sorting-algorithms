package algo.sorting;

import algo.util.Results;

public class QuickSort {
	long comparisons;
	long movements;
	public static Results quickSort(int[] list) {
		QuickSort quickSort = new QuickSort();
		long start = System.currentTimeMillis();
		quickSort(list, 0, list.length-1, quickSort);
		long end = System.currentTimeMillis();
		Results results = new Results();
		results.setN(list.length);
		results.setComparisons(quickSort.getComparisons());
		results.setDuration(end - start);
		results.setMovements(quickSort.getMovements());
		results.setSort("Quick sort");
		return results;
	}
	
	public static void quickSort(int[] list, int first, int last, QuickSort qs) {
		qs.incComparisons();
		if (last > first) {
			int pivotIndex = partition(list, first, last, qs);
			qs.incMovements();
			quickSort(list, first, pivotIndex -1, qs);
			quickSort(list, pivotIndex + 1, last, qs);
		}
	}
	
	/** Partition the array list[first..last] */
	public static int partition(int[] list, int first, int last, QuickSort quickSort) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		while (high > low) {
			quickSort.incComparisons();
			// Search forward from left
			while (low <= high && list[low] <= pivot){
				low++;
				quickSort.incComparisons();
			}
			
			// Search backward from right
			while (low <= high && list[high] > pivot){
				high--;
				quickSort.incComparisons();
			}
			
			//	Swap two elements in the list
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
				quickSort.incMovements();
			}
		}
		
		while (high > first && list[high] >= pivot){
			high--;
			quickSort.incComparisons();
		}
		
		//	Swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot; 
			quickSort.incMovements();
			return high;
		}
		else {
			return first;
		}
	}
	void incComparisons(){
		comparisons ++;
	}
	void incMovements(){
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
}