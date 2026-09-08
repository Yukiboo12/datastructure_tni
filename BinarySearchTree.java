import java.net.SecureCacheResponse;

public class BinarySearchTree {

	private Node root;
	private Node parent;
	private Node deleteNode;

	public boolean isEmpty() {
		return root == null;
	}
	
	public void sampleTree1() {
		int[] nums = {20,10,60,7,11,30,65,3,40};
		
		for (int num : nums) {
			insert(num);
		}
	}
	
	public void printTree(Node node, int depth) {
		if (node != null) {
			printTree(node.right, depth + 1);
			System.out.println("    ".repeat(depth) + node.data);
			printTree(node.left, depth + 1);
		}
	}
	
	public Node getRoot() {
		return root;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public Node getDeleteNode() {
		return deleteNode;
	}
	
	public void insert(int new_data) {
		if (root == null) {
			root = new Node(new_data);
		} else {
			Node current_node = root;
			while (true) {
				if (new_data < current_node.data) {
					if (current_node.left == null) {
						current_node.left = new Node(new_data);
						break;
					}
					current_node = current_node.left;
				}
				else if (new_data > current_node.data) {
					if (current_node.right == null) {
						current_node.right = new Node(new_data);
						break;
					}
					current_node = current_node.right; 
				}
				
			} //end while
		} //end if
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	//ข้อ 1) findMinimum()
	public Node findMinimum(Node root) {
		if (isEmpty()) {
			return null;
		}
		Node current_node = root;
		if (current_node.left == null) {
			return root;
		} else {
		    while (current_node != null) {
			  current_node =current_node.left; // MOVE current_node TO THE LEFT
			  if (current_node.left == null) {
				  return current_node;
			  }
		  }
	  }
	  return null;
  }
	
	//ข้อ 2,3)
	public Node findMaximum(Node root) {
		if (root == null) {
			return null;
		}
		Node current_node = root;
		
		if (current_node.right == null) {
			return root;
		}else {
			while (true) {
				 current_node =current_node.right; 
				 if (current_node.right == null) {
					 return current_node;
				 }
			}
		}
  }
	
	//ข้อ 4,5,6)
	public boolean findSpecificData(int target) {
		Node current_node = root;
		while (current_node != null) {
		   if (current_node.data == target) {
		       return true;
		}
		if (target < current_node.data) {
		    current_node = current_node.left;
		} else {
		    current_node = current_node.right;
		}
	}
	return false;
 }

	//ข้อ 6,7)
	public void searchDeleteNode(int target) {
		parent = root;
		Node current_node = root;
		while (current_node != null) {
		     if (target == current_node.data) {
		         deleteNode = current_node;
		         break;
		}
		parent = current_node;
		if (target < current_node.data) {
			current_node = current_node.left;
		} else {
			current_node = current_node.right;
		}
	 }
 }

	//ข้อ 8)
	public void delete(int target) {
		searchDeleteNode(target);
		
		if (isEmpty()) {
			System.out.print("Empty BST");
		} else if (deleteNode == null) {
			System.out.print("Cannot found the delete Node");
		} else {
			
			// case1:Delete Leaf Node
			if (deleteNode.left == null && deleteNode.right == null) {
				if (target < parent.data) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
			
			//case2: delete node with 2 children
			else if (deleteNode.left != null && deleteNode.right != null ) {
				deleteByLeftSubtree();
			}
			
			//case3: delete the node with 1 child
			else {
				if (deleteNode.left != null) {
					if (target < parent.data) {
						parent.left = deleteNode.left;
					} else {
						parent.right = deleteNode.left;
					}
				} else {
					if (target < parent.data) {
						parent.left = deleteNode.right;
					} else {
						parent.right = deleteNode.right;
			 	}
			 }
		 }
			
	  } // end outter-else
	} //end method
    
	//ข้อ 9)
	public void deleteByLeftSubtree() {
		Node Parent = deleteNode;
		Node Node = deleteNode.left;
		
		 if (Node.right == null) {
			 deleteNode.data = Node.data;
			 Parent.left = Node.left; // ขยับลูกซ้ายของตัวแทนขึ้นมาแทนที่
		 } else {
			// เดินทางขวาสุดของ Subtree ฝั่งซ้ายเรื่อยๆ เพื่อหาค่ามากที่สุด
			 while (Node.right != null) {
				 Parent = Node;
		         Node = Node.right;
			 }
			// นำค่าของโหนดที่มากที่สุดมาใส่แทนโหนดที่ต้องการลบ
			 deleteNode.data = Node.data;
			 
			 // ตัดโหนดตัวแทนทิ้ง โดยนำลูกซ้ายของตัวแทน (ถ้ามี) มาต่อเข้ากับ parent ฝั่งขวา
			 Parent.right = Node.left;
		 }
	}
	
}











