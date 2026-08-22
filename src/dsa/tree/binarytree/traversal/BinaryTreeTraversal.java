package dsa.tree.binarytree.traversal;

import java.util.*;

public class BinaryTreeTraversal {
    // ======= Preorder Traversal =======
    // Depth First Search (DFS).
    // it visits the root node first
    //      before going to the left and right subtree
    public static List<Integer> preorderRecursive(BinaryTreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preorderRecursive(root, list);
        return list;
    }

    private static void preorderRecursive(BinaryTreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.data);
        preorderRecursive(root.left, list);
        preorderRecursive(root.right, list);
    }

    public static List<Integer> preorderIterative(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode pop = stack.pop();
            list.add(pop.data);
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.left);
        }

        return list;
    }


    // ======= Inorder Traversal =======
    // DFS
    // it visits the left subtree first
    //      before going to the root and right subtree
    public static List<Integer> inorderRecursive(BinaryTreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderRecursive(root, list);
        return list;
    }

    private static void inorderRecursive(BinaryTreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorderRecursive(root.left, list);
        list.add(root.data);
        inorderRecursive(root.right, list);
    }

    public static List<Integer> inorderIterative(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        var stack = new ArrayDeque<BinaryTreeNode>();

        while (root != null || !stack.isEmpty()) {
            for (; root != null; root = root.left)
                stack.push(root);

            list.add((root = stack.pop()).data);
            root = root.right;
        }

        return list;
    }


    // ======= Postorder Traversal =======
    // DFS
    // left subtree -> right subtree -> root node
    public static List<Integer> postorderRecursive(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderRecursive(root, list);
        return list;
    }

    private static void postorderRecursive(BinaryTreeNode root, List<Integer> list) {
        if (root == null)
            return;
        postorderRecursive(root.left, list);
        postorderRecursive(root.right, list);
        list.add(root.data);
    }

    //

    public static List<Integer> postorderIterative(BinaryTreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> list = new ArrayList<>();

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode pop = stack.pop();
            list.add(pop.data);
            if (pop.left != null)
                stack.push(pop.left);
            if (pop.right != null)
                stack.push(pop.right);
        }

        list = list.reversed();

        return list;
    }

}
