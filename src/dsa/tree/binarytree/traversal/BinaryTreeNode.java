package dsa.tree.binarytree.traversal;

// 1. Full or Strict Binary Tree
// Each node has either 0 or 2 children
// Internal nodes have two children
// Leaf nodes have no children

// 2. Complete Binary Tree
// All levels are completely filled except the last level.
// The last level has all nodes as left as possible

// 3. Perfect Binary Tree
// All levels are completely filled

// 4. Degenerate Binary Tree
// All nodes have only one child

// 5. Balanced Binary Tree
// Height of the left subtree is no more than
//      the height of the right subtree
// AVL and Red-Black tree are examples of the balanced binary tree
public class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;
    }
}
