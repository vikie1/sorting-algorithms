package algo.sorting;

import java.util.Arrays;

import algo.util.Results;

public class RadixSort {
	long comparisons;
	long movements;

	static int getMax(int arr[], int n, RadixSort sort) {
		int mx = arr[0];
		for (int i = 1; i < n; i++){
			sort.incComparisons();
			if (arr[i] > mx){
				mx = arr[i];
				sort.incMovements();
			}
		}
		return mx;
	}

	static void countSort(int arr[], int n, int exp, RadixSort radixsort) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++){
			count[(arr[i] / exp) % 10]++;
			radixsort.incMovements();
		}
		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++){
			count[i] += count[i - 1];
			radixsort.incMovements();
		}
		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
			radixsort.incMovements();
		}
		for (i = 0; i < n; i++){
			arr[i] = output[i];
			radixsort.incMovements();
		}
	}

	public static Results radixsort(int arr[]) { // Find the maximum number to know number of digits
		RadixSort radixsort = new RadixSort();
		int n = arr.length;
		long start = System.currentTimeMillis();
		int m = getMax(arr, n, radixsort);
		for (int exp = 1; m / exp > 0; exp *= 10){
			countSort(arr, n, exp, radixsort);
			radixsort.incComparisons();
		}
		long stop = System.currentTimeMillis();
		Results results = new Results();
		results.setSort("Radix Sort");
		results.setComparisons(radixsort.getComparisons());
		results.setMovements(radixsort.getMovements());
		results.setDuration(stop - start);
		results.setN(n);
		return results;
	}

	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// public static void main(String[] args) {
	// 	int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
	// 	int n = arr.length;
	// 	radixsort(arr);
	// 	print(arr, n);
	// }

	void incMovements(){
		movements ++;
	}
	void incComparisons(){
		comparisons ++;
	}

	/**
	 * @return the movements
	 */
	public long getMovements() {
		return movements;
	}
	/**
	 * @return the comparisons
	 */
	public long getComparisons() {
		return comparisons;
	}
}