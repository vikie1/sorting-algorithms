package algo.sorting;

import algo.util.Results;

public class HeapSort {
	/** Heap sort method */
	public static <E extends Comparable<E>> Results heapSort(int[] list) {
		//	Create a Heap of integers
		Heap<E> heap = new Heap<>();
		
		long startTime = System.currentTimeMillis();
		//	Add elements to the heap
		for (int i = 0; i < list.length; i++){
			heap.add(list[i]);
		}
		
		//	Remove elements from the heap
		for (int i = list.length -1; i >= 0; i--){
			list[i] = (int) heap.remove();
		}
		long endTime = System.currentTimeMillis();
		Results results = heap.getResults();
		results.setN(list.length);
		results.setSort("HeapSort");
		results.setDuration(endTime - startTime);
		return results;
	}
	
	/**
 	/**	A test method 
	// */
	// public static void main(String[] args) {
	// 	Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
	// 	heapSort(list);
	// 	for(int i = 0; i < list.length; i++)
	// 		System.out.println(list[i] + " ");
	// }
}