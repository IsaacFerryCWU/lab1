class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }

		/**
		 *
		 * @param root
		 * pre-order traversal
		 * Prints the value of every node in preorder
		 */
		public void preOrderTraversal(Node root){
			if (root == null){
				return;
			}
			System.out.println(root.value + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);

		}



		/**
		 *
		 * @param root
		 * in-order traversal
		 * Prints the value of every node in order
		 */
		public void inOrderTraversal(Node root){
			if(root == null){
				return;
			}
			inOrderTraversal(root.left);
			System.out.println(root.value + " ");
			inOrderTraversal(root.right);
		}



		/**
		 * @param root
		 * post-order traversal
		 * Prints the value of every node in post-Order
		 */
		public void postOrderTraversal(Node root){
			if (root == null){
				return;
			}
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.value);
		}



		/**
		 *
		 * @param root
		 * @param key
		 * @return true or false
		 * A method to find the node a tree
		 * with a specific value.
		 */
		public boolean find(Node root, int key){
			while( root != null){
				if(root.value == key){
					return true;
				}
				if(key < root.value){
					root = root.left;
				}else{
					root = root.right;
				}
			}
			return false;
		}



		/**
		 * @param root
		 * @return min value in tree
		 * A method to find and return the
		 * smallest value in the tree.
		 */
		public int getMin(Node root){
			if (root == null){
				return Integer.MAX_VALUE;
			}

			int res = root.value;
			int lres = getMin(root.left);
			int rres = getMin(root.right);

			if(lres < res){
				res = lres;
			}
			if(rres < res){
				res = rres;
			}
			return res;
		}
	  
		

		/**
		 *
		 * @param root
		 * @return the max value in a tree
		 * A method to fine the smallest value
		 * in a tree
		 */
	   public int getMax(Node root){
		   if (root == null){
			   return Integer.MIN_VALUE;
		   }

		   int res = root.value;
		   int lres = getMax(root.left);
		   int rres = getMax(root.right);

		   if(lres > res){
			   res = lres;
		   }
		   if(rres > res){
			   res = rres;
		   }
		   return res;
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();


	           
	      
	   }  
	}
