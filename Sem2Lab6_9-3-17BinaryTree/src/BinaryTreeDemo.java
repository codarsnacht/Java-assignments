import java.util.Scanner;

/** Class to demonstrate the use of BinaryTree code. 
 * Based on code by Carrano & Savitch.
 */

public class BinaryTreeDemo 
{
	public static void main(String[] args) 
	{
		// Create a tree
		System.out.println("Constructing a test tree ...");
		BinaryTree<String> testTree = new BinaryTree<String>();
		createTree1(testTree);
		
	//BinaryTree<String> testTree = MMExtra.createRecursiveTree(3);
		
		// Display some statistics about it
		System.out.println("\nSome statistics about the test tree ...");
		displayStats(testTree);
		
		// Perform in-order traversal
		System.out.println("\nIn-order traversal of the test tree, printing each node when visiting it ...");
		
		//part 1 
		System.out.println("\nPre order:");
		testTree.preorderTraverse();//calls method
		System.out.println("\nPost order: ");
		testTree.postorderTraverse();//calls method
		
		//part 2 
		
		System.out.println("\nBreadth First Traversal:");
		testTree.breadthFirstTraversal();//calls method
		
	
	
	} // end of main
	

	//part 3 -- ask for input and make tree of that height 
	//works when put into main / here for convience 
	// When printing the tree , address values are printed instead of numbers/letters 
	public static void userInput(int s){
		Scanner reader = new Scanner(System.in);  
		System.out.println("Enter height of tree: ");//asking for height 
		int n = reader.nextInt();
		
		//move to main to work
	//	testTree.createRecursiveTree(n);
		
		
	}
	
	
	
	
	
	public static void createTree1(BinaryTree<String> tree)
	{
		// To create a tree, build it up from the bottom:
		// create subtree for each leaf, then create subtrees linking them,
		// until we reach the root.
		
	  	System.out.println("\nCreating a treee that looks like this:\n");
	  	System.out.println("     A      ");
	        System.out.println("   /   \\   "); // '\\' is the escape character for backslash
	        System.out.println("  B     C   ");
	        System.out.println(" / \\   / \\");
	        System.out.println("D   E  F  G ");
	        System.out.println();
	        
	    /*    
	        //part 4 tree output 
	        // to finish last level 
	         * 
	    	System.out.println("     1      ");
	        System.out.println("   /   \\   "); // '\\' is the escape character for backslash
	        System.out.println("  2     3   ");
	        System.out.println(" / \\   / \\");
	        System.out.println("4   5  6  7 ");
	        System.out.println("/n");//splitting tree to make tree easier to read and build
	        System.out.println("  4      5       6        7   "); 
	        System.out.println(" / \\    /  \\    / \\      / \\");
	        System.out.println("8   9  10  11 12   13  14  15 ");
	         System.out.println("/n");//splitting tree to make tree easier to read and build
	         System.out.println("  8      9       10       11   "); 
	        System.out.println(" / \\    /  \\    / \\      / \\");
	        System.out.println("16 17 18   19  20  21   22  23 ");
	         System.out.println("/n");//splitting tree to make tree easier to read and build
	         System.out.println("  12     13      14       15   "); 
	        System.out.println(" / \\    /  \\    /  \\     /  \\");
	        System.out.println("24 25  26  27  28  29   30  31 ");
	       */ 

    	        // First the leaves
	        //height of 3 
	        
		BinaryTree<String> dTree = new BinaryTree<String>();
		dTree.setTree("D");
		// neater to use the constructor the initialisation ...
		BinaryTree<String> eTree = new BinaryTree<String>("E");
		BinaryTree<String> fTree = new BinaryTree<String>("F");
		BinaryTree<String> gTree = new BinaryTree<String>("G");
		
		// Now the subtrees joining leaves:
		BinaryTree<String> bTree = new BinaryTree<String>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<String>("C", fTree, gTree);
		
		// Now the root
				tree.setTree("A", bTree, cTree);
		

	
	/*	
		//part 4 ,tree of height  
		BinaryTree<String> aTree = new BinaryTree<String>();
		aTree.setTree("31");
		// neater to use the constructor the initialisation ...
				BinaryTree<String> bTree = new BinaryTree<String>("30");
				BinaryTree<String> cTree = new BinaryTree<String>("29");
				BinaryTree<String> dTree = new BinaryTree<String>("28");
				BinaryTree<String> eTree = new BinaryTree<String>("27");
				BinaryTree<String> fTree = new BinaryTree<String>("26");
				BinaryTree<String> gTree = new BinaryTree<String>("25");
				BinaryTree<String> hTree = new BinaryTree<String>("24");
				BinaryTree<String> iTree = new BinaryTree<String>("23");
				BinaryTree<String> jTree = new BinaryTree<String>("22");
				BinaryTree<String> kTree = new BinaryTree<String>("21");
				BinaryTree<String> lTree = new BinaryTree<String>("20");
				BinaryTree<String> mTree = new BinaryTree<String>("19");
				BinaryTree<String> nTree = new BinaryTree<String>("18");
				BinaryTree<String> oTree = new BinaryTree<String>("17");
				BinaryTree<String> pTree = new BinaryTree<String>("16");
				
				// Now the subtrees joining leaves:
				BinaryTree<String> qTree = new BinaryTree<String>("15", aTree, bTree);
				BinaryTree<String> rTree = new BinaryTree<String>("14", cTree, dTree);
				BinaryTree<String> sTree = new BinaryTree<String>("13", eTree, fTree);
				BinaryTree<String> tTree = new BinaryTree<String>("12", gTree, hTree);
				BinaryTree<String> uTree = new BinaryTree<String>("11", iTree, jTree);
				BinaryTree<String> vTree = new BinaryTree<String>("10", kTree, lTree);
				BinaryTree<String> wTree = new BinaryTree<String>("9", mTree, nTree);
				BinaryTree<String> xTree = new BinaryTree<String>("8", oTree, pTree);
				
				
				// Now the subtrees joining the  subtrees joining leaves:
				BinaryTree<String> yTree = new BinaryTree<String>("7", qTree, rTree);
				BinaryTree<String> zTree = new BinaryTree<String>("6", sTree, tTree);
				BinaryTree<String> ATree = new BinaryTree<String>("5", uTree, vTree);
				BinaryTree<String> BTree = new BinaryTree<String>("4", wTree, xTree);
				
				
				// Now the subtrees joining subtrees joining the  subtrees joining leaves:
				BinaryTree<String> CTree = new BinaryTree<String>("3", yTree, zTree);
				BinaryTree<String> DTree = new BinaryTree<String>("2", ATree, BTree);
				
				// Now the root
				tree.setTree("1", CTree, DTree);
				
				
	//	*/		
	} // end createTree1
	
	public static void displayStats(BinaryTree<String> tree)
	{
		if (tree.isEmpty())
			System.out.println("The tree is empty");
		else
			System.out.println("The tree is not empty");
		
		System.out.println("Root of tree is " + tree.getRootData());
		System.out.println("Height of tree is " + tree.getHeight());
		System.out.println("No. of nodes in tree is " + tree.getNumberOfNodes());
	} // end displayStats 
}
