import java.util.LinkedList;
import java.util.Queue;
public class BinarySearchTree
{
	private class BST
	{
		BST left;
		int data;
		BST right;
		BST(int data)
		{
			this.data=data;
			left=null;
			right=null;
		}
	}
	private BST root;
	private int height;
	private int c_height;
	private int no_of_vertices;
	BinarySearchTree()
	{
		root=null;
		height=0;
		no_of_vertices=0;
	}
	BinarySearchTree(int ele)
	{
		root=new BST(ele);
		height=0;
		no_of_vertices=1;
	}
	int height()
	{
		return height;
	}
	int no_of_vertices()
	{
		return no_of_vertices;
	}
	void insert(int ele)
	{
		if(root==null)
			root=new BST(ele);
		else
		{
			c_height=0;
			add(root,ele);
		}
		no_of_vertices++;
	}
	private void add(BST root,int ele)
	{
		c_height++;
		if(root.data>=ele)
		{
			if(root.left==null)
				root.left=new BST(ele);
			else
				add(root.left,ele);
		}
		else if(root.data<=ele)
		{
			if(root.right==null)
				root.right=new BST(ele);
			else
				add(root.right,ele);
		}
		if(c_height>height)
			height=c_height;
	}
	int findMin()
	{
		if(root==null)
			throw new NullPointerException("No Element found");
		 return min(root);
	}
	int findMax()
	{
		if(root==null)
			throw new NullPointerException("No Element found");
		return max(root);
	}
	int findHeight()
	{
		if(root==null)
			return 0;
		return height(root);
	}
	private int min(BST root)
	{
		if(root.left==null)
			return root.data;
		return min(root.left);
	}
	private int max(BST root)
	{
		if(root.right==null)
			return root.data;
		return max(root.right);
	}
	private int height(BST root)
	{
		if(root==null)
			return -1;
		int leftdepth=height(root.left);
		int rightdepth=height(root.right);
		return (leftdepth>rightdepth?leftdepth:rightdepth)+1;
	}
	int[] preorderTraversal()
	{
		LinkedList<Integer> ll=new LinkedList<Integer>();
		preorder(root,ll);
		int x[]=new int[no_of_vertices];
		for(int i=0;i<ll.size();i++)
			x[i]=ll.get(i);
		return x;
	}
	private void preorder(BST root,LinkedList<Integer> out)
	{
		if(root==null)
			return;
		out.add(root.data);
		preorder(root.left,out);
		preorder(root.right,out);
	}
	int[] inorderTraversal()
	{
		LinkedList<Integer> ll=new LinkedList<Integer>();
		inorder(root,ll);
		int x[]=new int[no_of_vertices];
		for(int i=0;i<ll.size();i++)
			x[i]=ll.get(i);
		return x;
	}
	private void inorder(BST root,LinkedList<Integer> out)
	{
		if(root==null)
			return;
		inorder(root.left,out);
		out.add(root.data);
		inorder(root.right,out);
	}
	int[] postorderTraversal()
	{
		LinkedList<Integer> ll=new LinkedList<Integer>();
		postorder(root,ll);
		int x[]=new int[no_of_vertices];
		for(int i=0;i<ll.size();i++)
			x[i]=ll.get(i);
		return x;
	}
	private void postorder(BST root,LinkedList<Integer> out)
	{
		if(root==null)
			return;
		postorder(root.left,out);
		postorder(root.right,out);
		out.add(root.data);
	}
	int[] levelorderTraversal()
	{
		if(root==null)
			return null;
		int x[]=new int[no_of_vertices];
		Queue<BST> q=new LinkedList<BST>();
		q.add(root);
		int ind=0;
		while(!(q.isEmpty()))
		{
			x[ind++]=q.peek().data;
			if(q.peek().left!=null)
				q.add(q.peek().left);
			if(q.peek().right!=null)
				q.add(q.peek().right);
			q.remove();
		}
		return x;
	}
	boolean is_bst()
	{
		return is_binary_search_tree(root);
	}
	private boolean is_binary_search_tree(BST root)
	{
		if(root==null)
			return true;
		if(is_binary_lesser_subtree(root.left,root.data)&&is_binary_greater_subtree(root.right,root.data)&&
				is_binary_search_tree(root.left)&&is_binary_search_tree(root.right))
			return true;
		return false;
		
	}
	private boolean is_binary_lesser_subtree(BST root,int value)
	{
		if(root==null)
			return true;
		if(root.data<=value&&is_binary_lesser_subtree(root.left,value)&&is_binary_lesser_subtree(root.right,value))
			return true;
		return false;
	}
	private boolean is_binary_greater_subtree(BST root,int value)
	{
		if(root==null)
			return true;
		if(root.data>=value&&is_binary_greater_subtree(root.left,value)&&is_binary_greater_subtree(root.right,value))
			return true;
		return false;
	}
	boolean isBinarySearchTree()
	{
		return is_binary_search_tree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private boolean is_binary_search_tree(BST root,int min_value,int max_value)
	{
		if(root==null)
			return true;
		if(root.data>=min_value&&root.data<=max_value&&is_binary_search_tree(root.left,min_value,root.data)&&
				is_binary_search_tree(root.right,root.data,max_value))
			return true;
		return false;
	}
	boolean contains(int data)
	{
		return contain(root,data);
	}
	private boolean contain(BST root,int data)
	{
		if(root==null)
			return false;
		if(root.data==data)
			return true;
		if(root.data>data)
			return contain(root.left,data);
		else if(root.data<data)
			return contain(root.right,data);
		return false;
	}
	void delete_node(int data)
	{
		if(root==null)
			return;
		if(root.data==data)
		{
			if(root.left==null&&root.right==null)
				root=null;
			if(root.left!=null)
			{
				BST temp=leftmost(root.left);
				deletenode(root,temp.data);
				temp.left=root.left;
				temp.right=root.right;
				root=temp;
			}
			else
			{
				BST temp=rightmost(root.right);
				deletenode(root,temp.data);
				temp.left=root.left;
				temp.right=root.right;
				root=temp;
			}
			no_of_vertices--;
		}
		else if(contains(data))
		{
			deletenode(root,data);
			no_of_vertices--;
		}
	}
	private void deletenode(BST root,int data)
	{
		if(root.left==null&&root.right==null)
			return;
		if(root.data>data)
		{
			if(root.left.data==data)
			{
				if(root.left.left==null&&root.left.right==null)
					root.left=null;
				else if(root.left.left!=null)
				{
					BST temp=leftmost(root.left.left);
					deletenode(root.left,temp.data);
					temp.left=root.left.left;
					temp.right=root.left.right;
					root.left=temp;
				}
				else
				{
					BST temp=rightmost(root.left.right);
					deletenode(root.left,temp.data);
					temp.left=root.left.left;
					temp.right=root.left.right;
					root.left=temp;
				}
			}
			else
				deletenode(root.left,data);
		}
		else if(root.data<data)
		{
			if(root.right.data==data)
			{
				if(root.right.left==null&&root.right.right==null)
					root.right=null;
				else if(root.right.left!=null)
				{
					BST temp=leftmost(root.right.left);
					deletenode(root.right,temp.data);
					temp.left=root.right.left;
					temp.right=root.right.right;
					root.right=temp;
				}
				else
				{
					BST temp=rightmost(root.right.right);
					deletenode(root.right,temp.data);
					temp.left=root.right.left;
					temp.right=root.right.right;
					root.right=temp;
				}
			}
			else
				deletenode(root.right,data);
		}
	}
	private BST leftmost(BST root)
	{
		if(root.right==null)
			return root;
		return leftmost(root.right);
	}
	private BST rightmost(BST root)
	{
		if(root.left==null)
			return root;
		return rightmost(root.left);
	}
	void balance()
	{
		//to be continued
	}
}
