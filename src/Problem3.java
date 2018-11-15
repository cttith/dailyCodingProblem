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
 * need to traverse the tree, pre, in, or post [choose one]*/
public class Problem3 {

	public class Node{
		private Node left;
		private Node right;
		private String val;
		
		public Node(String val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	// left node right
	public static StringBuilder inOrder(Node node, StringBuilder res) {
		if (node == null) return res;
		
		res.append(inOrder(node.left, res));
		
		res.append(node.val);
		
		res.append(inOrder(node.right, res));
		
		return res;
		
	}
	
	public static StringBuilder serialize(Node node) {
		StringBuilder res = null;
		
		res = inOrder(node, res);
		
		return res;
	
	}
	
	
	
	
	public static void main(String args[]) {
		Node node = Node("root", Node("left", Node("left.left")), Node("right"));
		
	}

}
