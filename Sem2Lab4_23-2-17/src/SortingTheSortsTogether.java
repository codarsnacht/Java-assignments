import java.util.Comparator;
import java.math.*;


import javax.swing.JOptionPane;

public class SortingTheSortsTogether {
	static int shellCounterMove=0;// move counter for task.2
	static int ShellCounterCompare=0;//compare counter for task. 2
	static int insertCounterMove=0;// move counter for task.2
	static int insertCounterCompare=0;//compare counter for task. 2
	static int quickCounterMove=0;// move counter for task.2
	static int quickCounterCompare=0;//compare counter for task. 2
	
	
	
	//shell sort
	public static void shellSort (Comparable[] arr)   
	{
		int last = arr.length-1; 
		long startTime = System.nanoTime();
		// Begin with gap = half length of array; reduce by half each time.
		for (int gap = arr.length/2; gap > 0; gap = gap/2)
		{
			ShellCounterCompare++;//Compare counter
			
			//comment out for part7
		if (gap % 2 == 0) gap++; // if gap is even, move to next largest odd number
			
			// Apply Insertion Sort to the subarrays defined by the gap distance
			for (int first = 0; first < gap; first++) {
				insertionSort (arr, first, last, gap);
				shellCounterMove++;//move counter 
			}
		} // end for
		long endTime = System.nanoTime() - startTime;
		System.out.println("Time for shell sort is " + endTime + " nanoseconds");
	} // end shellSort
	
	//insertion sort
	public static void insertionSort(Comparable arr[])
	{
		insertionSort(arr, 0, arr.length-1, 1);
	}
	
	private static void insertionSort(Comparable[] a, int first, int last, int gap)                                             
	{
		int index;     // general index for keeping track of a position in array
		int toSort;  // stores the index of an out-of-place element when sorting.

		// NOTE: Instead of considering a full array of adjacent elements, we are considering 
		// a sub-list of elements from 'first' to 'last, separated by 'gap'. All others are ignored.
		//
		// Work forward through the list, starting at 2nd element, 
		// and sort each element relative to the ones before it.
		
		long startTime = System.nanoTime();
		
		for (toSort = first+gap; toSort <= last; toSort += gap)
		{
			Comparable toSortElement = a[toSort];
			insertCounterCompare++;
			// Go back through the list to see how far back (if at all)
			// this element should be moved.
			// Note: we assume all elements before this are sorted relative to each other.
			boolean moveMade = false;
			index = toSort - gap;
			while ((index >= first) && (toSortElement.compareTo(a[index]) < 0))
			{
				// Shuffle elements over to the right, put firstUnsorted before them 
				a[index+gap] = a[index];
				index = index - gap;
				moveMade = true;
				insertCounterMove++;
			} 
			if (moveMade) {
				//System.out.println("Inserting " + toSortElement + " at pos " + (index+1));
				a[index+gap] = toSortElement;
				
			}
		} 
		//timing code
		long endTime = System.nanoTime() - startTime;
		System.out.println("Time for insert sort is " + endTime + " nanoseconds");
	} 
	
	
	
	//quickSort
	public static void quickSort (Object[] arr, Comparator c) {
	    if (arr.length < 2) return; // the array is already sorted in this case
	    quickSortStep(arr, c, 0, arr.length-1); // call the recursive sort method
	}
	private static void quickSortStep (Object[] s, Comparator c,
								int leftBound, int rightBound ) 
{
		//start time zone
		long startTime = System.nanoTime();
		
		if (leftBound >= rightBound) return; // the indices have crossed
		Object temp;  // temp object used for swapping

		// Set the pivot to be the last element
		Object pivotValue = s[rightBound];

		// Now partition the array 
		int upIndex = leftBound;     // will scan rightward, 'up' the array
		int downIndex = rightBound-1; // will scan leftward, 'down' the array
		while (upIndex <= downIndex) 
		{ 
			quickCounterCompare++;
			// scan right until larger than the pivot
			while ( (upIndex <= downIndex) && (c.compare(s[upIndex], pivotValue)<=0) )
				upIndex++; 
			// scan leftward to find an element smaller than the pivot
			while ( (downIndex >= upIndex) && (c.compare(s[downIndex], pivotValue)>=0))
				downIndex--;
			if (upIndex < downIndex) { // both elements were found
				temp = s[downIndex]; 
				s[downIndex] = s[upIndex]; // swap these elements
				s[upIndex] = temp;
				quickCounterMove++;
			}
		} // the loop continues until the indices cross

		int pivotIndex = upIndex;
		temp = s[rightBound]; // swap pivot with the element at upIndex
		s[rightBound] = s[pivotIndex]; 
		s[pivotIndex] = temp; 

		// the pivot is now at upIndex, so recursively quicksort each side
		quickSortStep(s, c, leftBound, pivotIndex-1);
		quickSortStep(s, c, pivotIndex+1, rightBound);
		
		//time code
		long endTime = System.nanoTime() - startTime;
		System.out.println("Time for quick sort is " + endTime + " nanoseconds");
	}
	
	//main for testing
	public static void main(String[] args){
		
		//8
		String[] arr = {"a", "b", "c", "i","d", "e", "f", "g"};
		
		//250
	/*	String arr[] = {"a", "hello", "x", "w", "q", "h", "d", "p", "a1", "x2", "w2", "q1", "2h", "2d", "3p", "1a",
				"3x", "2w", "3q", "h4", "d4", "4p", "3a", "3x", "5w", "q5", "h5", "d5", "p5",
				"n3x", "2bw", "n3q", "nh4", "nd4", "n4p", "b3a", "b3x", "c5w", "xq5", "kh5", "dj5", "jp5",
				"3x", "2w", "3q", "h4", "d4", "4p", "3a", "3x", "5w", "q5", "h5", "d5", "p5",
				"q3x", "q2w", "3qq", "qh4", "ad4", "4ap", "3aa", "3ax", "a5w", "q5", "fh5", "fd5", "fp5",
				"n3x", "2bw", "n3q", "nh4", "nd4", "n4p", "b3a", "b3x", "c5w", "xq5", "kh5", "dj5", "jp5",
				"3x", "2w", "3q", "h4", "d4", "4p", "3a", "3x", "5w", "q5", "h5", "d5", "p5",
				"n3x", "2bw", "n3q", "nh4", "nd4", "n4p", "b3a", "b3x", "c5w", "xq5", "kh5", "dj5", "jp5",
				"q3x", "q2w", "3qq", "qh4", "ad4", "4ap", "3aa", "3ax", "a5w", "q5", "fh5", "fd5", "fp5",
				"n3x", "2bw", "n3q", "nh4", "nd4", "n4p", "b3a", "b3x", "c5w", "xq5", "kh5", "dj5", "jp5",
				"3x", "2w", "3q", "h4", "d4", "4p", "3a", "3x", "5w", "q5", "h5", "d5", "p5",
				"n3x", "2bw", "n3q", "nh4", "nd4", "n4p", "b3a", "b3x", "c5w", "xq5", "kh5", "dj5", "jp5",
				"3x", "2w", "3q", "h4", "d4", "4p", "3a", "3x", "5w", "q5", "h5", "d5", "p5",
				"q3x", "q2w", "3qq", "qh4", "ad4", "4ap", "3aa", "3ax", "a5w", "q5", "fh5", "fd5", "fp5",
				"n3x", "2bw", "n3q", "nh4", "nd4", "n4p", "b3a", "b3x", "c5w", "xq5", "kh5", "dj5", "jp5",
				"n3x", "2bw", "n3q", "nh4", "nd4", "n4p", "b3a", "b3x", "c5w", "xq5", "kh5", "dj5", "jp5",
				"3x", "2w", "3q", "h4", "d4", "4p", "3a", "3x", "5w", "q5", "h5", "d5", "p5",
				"3x", "2w", "3q", "h4", "d4", "4p", "3a", "3x", "5w", "q5", "h5", "d5", "p5",
				"g3x", "g2w", "f3q", "fh4", "gd4", "f4p", "f3a", "d3x", "s5w", "sq5", "sh5", "dd5", "sp5"};
        
		
		//String[] arr = {"1", "3", "2", "7","2", "5", "012", "42"};
		
		
	/*	//part 3/4
		 String[] array = null;//creates new array 
		 int size = (int)(100 * Math.random());  // new array is of a random size
		 int[] val = new int[size];
		 
		 for ( int i =0;i<size;i++)//for loop to add random srtings into array
		 {
			 val[i] = (int)(100 * Math.random()); //gets random int number
		        array[i] = String.valueOf(val[i]);// converts to string and puts it in array
			 
			 
		 }
		*/
		//3 copies//part4
			//String copy1[] = array.clone();
			//String copy2[] = array.clone();
		//	String copy3[] = array.clone();
		
		
		
		//3 copies
		String copy1[] = arr.clone();
		String copy2[] = arr.clone();
		String copy3[] = arr.clone();
		
		
		//calling each methods with their respective copies of arr
		//insert
		JOptionPane.showMessageDialog(null, "Array length is "+ copy2.length);

		JOptionPane.showMessageDialog(null, "Array before sorting with InsertionSort\n" + array2String(copy2));

		insertionSort(copy2);
		JOptionPane.showMessageDialog(null, "After Sorting with InsertionSort:\n " + array2String(copy2));
		JOptionPane.showMessageDialog(null,  "Total moves in insert sort are : " + insertCounterMove);
		JOptionPane.showMessageDialog(null,  "Total Compares in insert sort are : " + insertCounterCompare);
		
		//shell
		JOptionPane.showMessageDialog(null, "Array before sorting with Shell Sort:\n" + array2String(copy1));

		shellSort(copy1);
		JOptionPane.showMessageDialog(null,  "After Shell Sort" + array2String(copy1));
		//prints out the counters for total moves and compares
		JOptionPane.showMessageDialog(null,  "Total moves in Shell sort are : " + shellCounterMove);
		JOptionPane.showMessageDialog(null,  "Total Compares in Shell sort are : " + ShellCounterCompare);
		
		
		
		//quick
		JOptionPane.showMessageDialog(null, "Array before sorting:\n" + array2String(copy3));
		
		// quickSort method's first parameter is just the array; 
		// second is a newly created string comparator object (class defined later in this file)
		quickSort(copy3, new StringComparator());

		JOptionPane.showMessageDialog(null, "Array after sorting:\n" + array2String(copy3));
		JOptionPane.showMessageDialog(null,  "Total moves in quick sort are : " + quickCounterMove);
		JOptionPane.showMessageDialog(null,  "Total Compares in quick sort are : " + quickCounterCompare);
		
		
		//exit message box
		System.exit(0);
		
		
		
		
	}
	
	/** utility method to return string representation of array of strings */
	private static String array2String(String[] a)
	{
		String text="[";
		for (int i=0; i<a.length; i++) {
			text += a[i];
			if (i<a.length-1)
				text += ",";
		}
		text += "]";
		return text;
	}
}
	
	
	
	
	
	


