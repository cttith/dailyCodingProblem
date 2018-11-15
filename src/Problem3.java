import java.util.List;

/*
 Given the root to a binary tree, implement serialize(root), 
 which serializes the tree into a string, and deserialize(s), 
 which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'

 */

/* 
 * StringBuilder = single thread, and mutable
 * StringBuffer = multiple threads and mutable
 * need to traverse the tree, pre, in, or post 
 * 
 * create a traversal list
 *  - use pre-order(N,L,R)
 * deserialize list
 *  - create tree by reading traversal list (in-order fashion)
 * 
 * 
 * */
public class Problem3 {

	public class Node{
		public Node left;
		public Node right;
		public String val;
		
		
		public Node(String val) {
			this(val,null,null);
		}
		
		public Node(String val, Node left, Node right) {
			this.val = val;
			this.left =  left != null ? left : null;
			this.right = right != null ? right : null;
		}
		
	}
	
	// left node right
	public static List<String> inOrder(Node node, List<String> res) {
		if (node == null) return res;
		
		inOrder(node.left, res);
		res.add(node.val);
		inOrder(node.right, res);
		
		return res;
		
	}
	
	public static List<String> serialize(Node node) {
		StringBuilder res = null;
		
		res = inOrder(node, res);
		
		return res;
	
	}
	
	
	
	
	public static void main(String args[]) {
		Node node = new Node("root", Node("left", Node("left.left"), Node("right")));
		
	}

	

	

	

}
