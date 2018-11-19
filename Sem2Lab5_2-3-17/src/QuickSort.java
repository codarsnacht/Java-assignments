
/** QuickSort.java: 
 *  Based on code from Goodrich & Tamassia, “Data Structures and Algorithms in Java”
 *  With some simplifications for clarity, and test code at the end.
 */

import javax.swing.JOptionPane;
import java.util.Comparator;
import java.util.Random;


public class QuickSort
{
    /** QuickSort method:
	  * Sorts the elements of array arr in nondecreasing order according
	  * to comparator c, using the quick-sort algorithm. Most of the work
	  * is done by the auxiliary recursive method quickSortStep.
	  **/
	public static void quickSort (Object[] arr, Comparator c) {
	    if (arr.length < 2) return; // the array is already sorted in this case
	    quickSortStep(arr, c, 0, arr.length-1); // call the recursive sort method
	}
	  
	/** QuickSortStep method: 
	  * Method called by QuickSort(), which sorts the elements of array s between
	  * indices leftBound and rightBound, using a recursive, in-place,
	  * implementation of the quick-sort algorithm.
	 **/
	private static void quickSortStep (Object[] s, Comparator c,
	                              int leftBound, int rightBound ) 
	{
	   if (leftBound >= rightBound) return; // the indices have crossed
	   Object temp;  // temp object used for swapping
	    
	   // Set the pivot to be the last element
	 //  Object pivotValue = s[rightBound];
	   
	// Set the pivot to be the last element edited for assignment
	   Object pivotValue = s[(rightBound+leftBound )/2];//for middle value
	    
	   //swapping pivot with right bound 
	   temp = s[(rightBound+leftBound )/2];
	   s[(rightBound+leftBound )/2] = s[rightBound];
	   s[rightBound] = temp;
	   
	   
	   // Now partition the array 
	   int upIndex = leftBound;     // will scan rightward, 'up' the array
	   int downIndex = rightBound-1; // will scan leftward, 'down' the array
	   while (upIndex <= downIndex) 
	   { 
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
	       }
	   } // the loop continues until the indices cross
	    
	   int pivotIndex = upIndex;
	   temp = s[rightBound]; // swap pivot with the element at upIndex
	   s[rightBound] = s[pivotIndex]; 
	   s[pivotIndex] = temp; 
	 
	   // the pivot is now at upIndex, so recursively quicksort each side
	   quickSortStep(s, c, leftBound, pivotIndex-1);
	   quickSortStep(s, c, pivotIndex+1, rightBound);
	}

	
	/** Main method to test QuickSort */
	public static void main(String[] args)
	{
		//random array
		String arr[] = {"f", "g", "h", "i", "j", "k", "l", "a", "b", "c", "d", "e", "m", "n", "o", "p"};
		
		//in assending order
	 //  String arr[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"};
		
		//in decending order
	//	String arr[] = {"p", "o", "n", "m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b","a"};
		
	//	String arr[] = {"This", "is","yet", "another", "Boring","Array", "Sorting", "test"};
		
	
		System.out.println("Array before sorting:\n" + array2String(arr));
		// quickSort method's first parameter is just the array; 
		// second is a newly created string comparator object (class defined later in this file)
		//timing start
		long startTime = System.nanoTime();
		quickSort(arr, new StringComparator());
		long endTime = System.nanoTime() - startTime;

		System.out.println( "Array after sorting:\n" + array2String(arr));
		System.out.println("Time for shell sort is " + endTime + " nanoseconds");
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

/** Comparator class for case-insensitive comaprison of strings */
class StringComparator implements Comparator
{
	public int compare(Object ob1, Object ob2)
	{
		String s1 = (String)ob1;
		String s2 = (String)ob2;
		//return s1.compareTo(s2); // use compareTo for case-sensitive comparison
		return s1.compareToIgnoreCase(s2);
	}
}