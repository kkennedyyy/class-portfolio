//Written by Kennedy Poag
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class LinkedBST <Shape extends Comparable <Shape>> {
	//represent a node in the binary search tree
	public static String fileName = "./output.txt";
	private class Node{
		Shape data;
		Node leftChild;
		Node rightChild;
		//constructor
		public Node(Shape aData) {
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root; //head
	//constructor to create an empty binary search tree
	public LinkedBST() {
		root = null;
	}
	//add data to tree
	public void add(Shape aData) {
		if(root == null) {
			root = new Node(aData);
		}else {
			add(root, aData);
		}
	}
	//recursive method to add data to tree
	private Node add(Node aNode, Shape aData) {
		if(aNode == null) {
			aNode = new Node(aData);
		}else {
			int compareVal = aData.compareTo(aNode.data);
			if(compareVal<0) {
				aNode.leftChild = add(aNode.leftChild, aData);
			}else if(compareVal>0 && compareVal<1999) {
				aNode.rightChild = add(aNode.rightChild, aData);
			}
		}return aNode;
	}
	//print binary search tree preorder
	public void printPreorder() {
		printPreorder(root);
	}
	public void printPreorder(Node aNode) {
		if(aNode == null) {
			return;
		}
		System.out.println(aNode.data);
		printPreorder(aNode.leftChild);
		printPreorder(aNode.rightChild);
	}
	//print binary search tree in order
	public void printInorder() {
		printInorder(root);
	}
	private void printInorder(Node aNode) {
		if(aNode == null) {
			return;
		}printInorder(aNode.leftChild);
		System.out.println(aNode.data);
		printInorder(aNode.rightChild);
	}
	//print binary search tree in post order
	public void printPostorder() {
		printPostorder(root);
	}
	private void printPostorder(Node aNode) {
		if(aNode == null) {
			return;
		}printPostorder(aNode.leftChild);
		printPostorder(aNode.rightChild);
		System.out.println(aNode.data);
	}
	//breadth first search
	public void printBFS() {
		printBFS(root);
	}
	private void printBFS(Node aNode) {
		if(aNode == null) {
			return;
		}
	}
	//search method for binary search tree
	public boolean search(Shape aData) {
		return search(root, aData);
	}
	private boolean search(Node aNode, Shape aData) {
		if(aNode == null) {
			return false;
		}else {
			int compareVal = aData.compareTo(aNode.data);
			if(compareVal <0) {
				return search(aNode.leftChild, aData);
			}else if(compareVal>0){
				return search(aNode.rightChild, aData);
			}else {
				return true;
			}
		}
	}
	//remove method for tree
	public boolean remove(Shape aData) {
		root = remove(root, aData);
		boolean removed = false;
		if(root.data == null) {
			removed = false;
		}else {
			removed = true;
		}return removed;
	}
	private Node remove(Node aNode, Shape aData) {
		if(aNode == null) {
			return null;
		}else if(aData.compareTo(aNode.data)<0)
			aNode.leftChild = remove(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)
			aNode.rightChild = remove(aNode.rightChild,aData);
		else{
			if(aNode.rightChild == null) {
				return aNode.leftChild;
			}else if(aNode.leftChild == null) {
				return aNode.rightChild;
			}
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}return aNode; 
	}
	public void removeAboveArea(Double aData) {
		root = removeAboveArea(root, aData);
	}
	private Node removeAboveArea(Node in, Double aData) {
		Node aNode = in;
		double nodeArea =-1;
		
		if(aNode==null) {
			return null;
		}
		if(aNode.data instanceof Rectangle) {
			nodeArea = ((Rectangle)aNode.data).getArea();
		}else if(aNode.data instanceof Circle) {
			nodeArea = ((Circle)aNode.data).getArea();
		}else if(aNode.data instanceof RightTriangle) {
			nodeArea = ((RightTriangle)aNode.data).getArea();
		}
		
		aNode.leftChild = removeAboveArea(aNode.leftChild, aData);
		aNode.rightChild = removeAboveArea(aNode.rightChild, aData);
		
		if(nodeArea>aData) {
			return deleteNode(aNode);
		}return aNode;
	}	
	private Node deleteNode(Node root) {
		if(root.leftChild == null) {
			Node child = root.rightChild;
			root = null;
			return child;
		}
		else if(root.rightChild == null) {
			Node child = root.leftChild;
			root = null;
			return child;
		}
		Node next = leftMost(root.rightChild);
		root.data = next.data;
		root.rightChild = deleteNode(root.rightChild);
		return root;
	}
	private Node leftMost(Node Root) {
		if(root==null) {
			return null;
		}while(root.leftChild != null) {
			root = root.leftChild;
		}return root;
	}
	//find min value in tree
	private Node findMinInTree(Node aNode) {
		if(aNode == null) {
			return null;
		}else if(aNode.leftChild == null) {
			return aNode;
		}else {
			return findMinInTree(aNode.leftChild);
		}
	}
	public Shape findMaxInTree() {
		Node aNode = root;
		Node temp = findMaxInTree(aNode);
		Shape ret = temp.data;
		return ret;
	}
	private Node findMaxInTree(Node aNode) {
		if(aNode == null) {
			return null;
		}else if(aNode.rightChild == null) {
			return aNode;
		}else {
			return findMaxInTree(aNode.rightChild);
		}
	}
	public void writeTreeInorder(String outFile) throws IOException {
		fileName = outFile;
		Node aNode = root;
		writeTreeInorder(aNode);
	}
	public void writeTreeInorder(Node root) throws IOException {
		try {
			FileWriter output = new FileWriter(fileName);
			BufferedWriter writer = new BufferedWriter(output);
			writeInorder(root, writer);
			writer.close();
		}
		catch(FileNotFoundException e) {
			System.err.println(e);
		}
	}
	public void writeInorder(Node mainNode, BufferedWriter writer) throws IOException {
		if(mainNode == null) {
			return;
		}
		writeInorder(mainNode.leftChild, writer);
		if(mainNode.data instanceof Rectangle) {
			Rectangle frontNode = (Rectangle)mainNode.data;
			writer.write((frontNode).toFile());
		}
		if(mainNode.data instanceof Circle) {
			Circle frontNode = (Circle)mainNode.data;
			writer.write((frontNode).toFile());
		}
		if(mainNode.data instanceof RightTriangle) {
			RightTriangle frontNode = (RightTriangle)mainNode.data;
			writer.write((frontNode).toFile());
		}
		writeInorder(mainNode.rightChild, writer);
	}
	public void writeTreePreorder(String outFile) throws IOException {
		fileName = outFile;
		Node aNode = root;
		writeTreePreorder(aNode);
	}
	public void writeTreePreorder(Node root) throws IOException {
		try {
			FileWriter output = new FileWriter(fileName);
			BufferedWriter writer = new BufferedWriter(output);
			writePreorder(root, writer);
			writer.close();
		}
		catch(FileNotFoundException e) {
			System.err.println(e);
		}
	}
	public void writePreorder(Node mainNode, BufferedWriter writer) throws IOException {
		if(mainNode == null) {
			return;
		}
		if(mainNode.data instanceof Rectangle) {
			Rectangle frontNode = (Rectangle)mainNode.data;
			writer.write((frontNode).toFile());
		}
		if(mainNode.data instanceof Circle) {
			Circle frontNode = (Circle)mainNode.data;
			writer.write((frontNode).toFile());
		}
		if(mainNode.data instanceof RightTriangle) {
			RightTriangle frontNode = (RightTriangle)mainNode.data;
			writer.write((frontNode).toFile());
		}
		writePreorder(mainNode.leftChild, writer);
		writePreorder(mainNode.rightChild, writer);
	}
	public void writeTreePostorder(String outFile) throws IOException {
		fileName = outFile;
		Node aNode = root;
		writeTreePostorder(aNode);
	}
	 public void writeTreePostorder(Node root) throws IOException
	    {
	        try
	        {
	            //setting up the output printwriter
	            FileWriter output = new FileWriter(fileName);
	            BufferedWriter bw = new BufferedWriter(output);
	            writePostorder(root, bw);
	            bw.close();
	        }
	        catch(FileNotFoundException e)
	        {
	            System.err.println(e);
	        }
	    }
	 public void writePostorder(Node mainNode, BufferedWriter writer) throws IOException {
			if(mainNode == null) {
				return;
			}
			writePostorder(mainNode.leftChild, writer);
			writePostorder(mainNode.rightChild, writer);
			if(mainNode.data instanceof Rectangle) {
				Rectangle frontNode = (Rectangle)mainNode.data;
				writer.write((frontNode).toFile());
			}
			if(mainNode.data instanceof Circle) {
				Circle frontNode = (Circle)mainNode.data;
				writer.write((frontNode).toFile());
			}
			if(mainNode.data instanceof RightTriangle) {
				RightTriangle frontNode = (RightTriangle)mainNode.data;
				writer.write((frontNode).toFile());
			}
			
		}

}


