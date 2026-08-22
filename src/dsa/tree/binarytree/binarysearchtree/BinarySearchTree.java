package dsa.tree.binarytree.binarysearchtree;

public class BinarySearchTree {

    /**
     * In a Binary Search Tree (BST),
     * left node < root node < right node.
     * The root node must be greater than all nodes in the left subtree
     * The root node must be less than all nodes in the right subtree
     */
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public boolean insert(int data) {
        if (root == null) {
            root = new Node(data);
            return true;
        }

        Node node = root;
        while (true) {
            if (data < node.data) {
                if (node.left == null) {
                    node.left = new Node(data);
                    return true;
                } else {
                    node = node.left;
                }
            } else if (data > node.data) {
                if (node.right == null) {
                    node.right = new Node(data);
                    return true;
                } else {
                    node = node.right;
                }
            } else {
                return false;
            }
        }
    }

    public boolean delete(int data) {
        // 1. Find the node to be removed
        Node parent = null, node = root;
        while (node != null) {
            if (node.data == data)
                break;
            parent = node;
            if (data < node.data)
                node = node.left;
            else
                node = node.right;
        }

        if (node == null) {
            return false;
        }

        // 2. Node has at most one child
        if (node.left == null || node.right == null) {
            Node child = node.left != null ? node.left : node.right;
            node.left = node.right = null;

            if (parent == null)
                root = child;
            else if (parent.left == node)
                parent.left = child;
            else
                parent.right = child;

            return true;
        }

        // Successor is the rightmost (largest) node in the left subtree
        // Predecessor is the leftmost (smallest) node in the right subtree

        // 3. node has two children
        Node predecessorParent = node;
        Node predecessor = node.left;

        while (predecessor.right != null) {
            predecessorParent = predecessor;
            predecessor = predecessor.right;
        }

        // left subtree has no right child
        if (predecessorParent == node) {
            predecessor.right = node.right;
            node.left = node.right = null;

            if (parent == null)
                root = predecessor;
            else if (parent.left == node)
                parent.left = predecessor;
            else
                parent.right = predecessor;
        } else {
            node.data = predecessor.data;
            predecessorParent.right = predecessor.left;
        }

        return true;
    }

    public Node search(int data) {
        Node node = root;

        while (node != null && node.data != data)
            if (data < node.data)
                node = node.left;
            else
                node = node.right;

        return node;
    }

}
