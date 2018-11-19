/** * A class that implements the ADT binary tree.
 *  * @author Frank M. Carrano * @version 2.0 */
//importsimport java.util.LinkedList;import java.util.Queue;import javax.swing.tree.TreeNode;import java.util.ArrayList;
public class BinaryTree<T> implements BinaryTreeInterface<T>, java.io.Serializable{
	private static final long serialVersionUID = -1932834476575953631L;
	private BinaryNodeInterface<T> root;			//part2	public void breadthFirstTraversal(){			breadthFirstTraversal(root);	}		private void breadthFirstTraversal(BinaryNodeInterface<T> node) {				if (node == null)	// check if Nodes exist				return;					Queue<BinaryNodeInterface<T>> queue = new LinkedList<BinaryNodeInterface<T>>();	// create a Queue 				queue.add((BinaryNodeInterface<T>) node);// add all Nodes to this Queue above				while (!queue.isEmpty())	// start popping the nodes from the Queue and print them out.			{			node = queue.remove();			System.out.println(node.getData())		;					if (node.getLeftChild() != null)// if a Child on the left side of the Node exists ?			queue.add(node.getLeftChild());// add this child to the Queue if above is true					if (node.getRightChild() != null)// if a Child on the right side of the Node exists ?			queue.add(node.getRightChild());	// then add this child to the Queue if above is true		}			}	
	public BinaryTree()	{		root = null;
	} 

	public BinaryTree(T rootData)	{
		root = new BinaryNode<T>(rootData);	} 

	public BinaryTree(T rootData, BinaryTree<T> leftTree,			BinaryTree<T> rightTree)	{		privateSetTree(rootData, leftTree, rightTree);	} 

	public void setTree(T rootData)
	{
		root = new BinaryNode<T>(rootData);
	} 

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
			BinaryTreeInterface<T> rightTree)
	{
		privateSetTree(rootData, (BinaryTree<T>)leftTree,
 				(BinaryTree<T>)rightTree);
	} 

	private void privateSetTree(T rootData, BinaryTree<T> leftTree,
 			BinaryTree<T> rightTree)
	{
		root = new BinaryNode<T>(rootData);

		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);

		if ((rightTree != null) && !rightTree.isEmpty())
		{
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		} 

		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();

 		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	}

	private BinaryNode<T> copyNodes() // not essential
	{
		return (BinaryNode<T>)root.copy();
	} 

	public T getRootData()
	{
		T rootData = null;
		if (root != null)
			rootData = root.getData();
		return rootData;
	} 

	public boolean isEmpty()
	{
		return root == null;
	} 

	public void clear()
	{
		root = null;
	} 

	protected void setRootData(T rootData)
	{
		root.setData(rootData);
	} 

	protected void setRootNode(BinaryNodeInterface<T> rootNode)
	{
		root = rootNode;
	} 

	protected BinaryNodeInterface<T> getRootNode()
	{
		return root;
	} 

	public int getHeight()
	{
		return root.getHeight();
	} 

	public int getNumberOfNodes()
	{
		return root.getNumberOfNodes();
	} 			//part 1 	public void postorderTraverse()	 	{		postorderTraverse(root);	}	//part 1 	private void postorderTraverse(BinaryNodeInterface<T> node)	{		if (node != null)//checks to see if node is not null 		{						postorderTraverse(node.getLeftChild());//travels to left child			postorderTraverse(node.getRightChild());//travels to right child			System.out.println(node.getData());//prints out data		} 	} 					//part 1 	public void preorderTraverse()	 	{		preorderTraverse(root);	}	//part 1 	private void preorderTraverse(BinaryNodeInterface<T> node)	{		if (node != null)//checks to see if node is not null 		{			System.out.println(node.getData());//prints out data			preorderTraverse(node.getLeftChild());//travels to left child			preorderTraverse(node.getRightChild());//travels to right child		} 	} 

	public void inorderTraverse()
 	{		inorderTraverse(root);	}	private void inorderTraverse(BinaryNodeInterface<T> node)	{
		if (node != null)		{
			inorderTraverse(node.getLeftChild());			System.out.println(node.getData());			inorderTraverse(node.getRightChild());		} 	}		//taken from MMExtra 	//part 3 	private static int counter = 0;	public static BinaryTree<String> createRecursiveTree(int height)	{		counter++;		String txt = "N:" + counter + " H:" + height; 		BinaryTree<String> tree;				if (height <= 1) {			tree = new BinaryTree<String>(txt, null, null);		}		else {			tree = new BinaryTree<String>(txt, 					createRecursiveTree(height-1), createRecursiveTree(height-1));		}		System.out.println(tree);		return tree;	}	 

} 