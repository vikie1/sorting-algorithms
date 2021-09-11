package algo.sorting;

import algo.util.Results;

public class InsertionSort {
	/**The method for sorting the numbers */
	public static Results insertionSort(int[] list) {
		long comparisons = 0;
		long movements = 0;
		long start = System.currentTimeMillis();
		for (int i = 1; i < list.length; i++) {
			/** Insert list[i] into a sorted sublist list[0..i-1] so that 
			 * 	list[0..i] is sorted
			 */
			comparisons ++;
			int currentElement = list[i];
			int k;
			for (k = i-1; k>= 0 && list[k] > currentElement; k--) {
				list[k+1] = list[k];
				movements ++;
			}
			
			//insert the current element into list[k + 1]
			list[k + 1] = currentElement;
			
		}
		long end = System.currentTimeMillis();
		Results results = new Results();
		results.setMovements(movements);
		results.setComparisons(comparisons);
		results.setDuration(end - start);
		results.setN(list.length);
		results.setSort("Insertion sort");
		return results;
	}
}