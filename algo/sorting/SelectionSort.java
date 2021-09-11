package algo.sorting;

import algo.util.Results;

public class SelectionSort {
	/** The method for sorting the numbers */
	public static Results selectionSort(int[] list) { //int[] list?
		long comparisons = 0;
		long movements = 0;
		long start = System.currentTimeMillis();
		for (int i = 0; i < list.length -1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			movements ++;
			
			for (int j = i+1; j < list.length; j++) {
				if (currentMin > list[j]) {
					comparisons ++;
					currentMin = list[j];
					currentMinIndex = j;
					movements ++;
				}
			}
			
			//	Swap list[i] wiht list[currentMinIndex[ if necessary
			if (currentMinIndex != i) {
				comparisons ++;
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
				movements ++;
			}
		}
		long stop = System.currentTimeMillis();
		Results results = new Results();
		results.setSort("Selection sort");
		results.setComparisons(comparisons);
		results.setMovements(movements);
		results.setDuration(stop - start);
		results.setN(list.length);
		return results;
	}
}