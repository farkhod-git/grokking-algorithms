package dsa.tree.binarytree.traversal;


public class BinaryTreeTraversalDemo {
    static void main() {
        BinaryTreeNode bt = new BinaryTreeNode(1);
        bt.left = new BinaryTreeNode(2);
        bt.right = new BinaryTreeNode(3);
        bt.left.left = new BinaryTreeNode(4);
        bt.left.right = new BinaryTreeNode(5);
        bt.right.left = new BinaryTreeNode(6);
        bt.right.right = new BinaryTreeNode(7);

        System.out.println("Preorder:");
        System.out.println(BinaryTreeTraversal.preorderRecursive(bt));
        System.out.println(BinaryTreeTraversal.preorderIterative(bt));

        System.out.println("Inorder:");
        System.out.println(BinaryTreeTraversal.inorderRecursive(bt));
        System.out.println(BinaryTreeTraversal.inorderIterative(bt));

        System.out.println("Postorder:");
        System.out.println(BinaryTreeTraversal.postorderRecursive(bt));
        System.out.println(BinaryTreeTraversal.postorderIterative(bt));
    }
}
