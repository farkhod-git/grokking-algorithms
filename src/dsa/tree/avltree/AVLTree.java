package dsa.tree.avltree;


public class AVLTree {
    Node root;

    void insert(int key) {
        root = insert(root, key);
    }

    private static Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        // insert recursion
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        node.height = recalcHeight(node);

        int bf = getBalanceFactor(node);

        // LL
        if (bf > 1 && key < node.left.key) {
            return rightRotation(node);
        }

        // RR
        if (bf < -1 && key > node.right.key) {
            return leftRotation(node);
        }

        // LR
        if (bf > 1 && key > node.left.key) {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }

        // RL
        if (bf < -1 && key < node.right.key) {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        return node;
    }

    private static Node rightRotation(Node node) {
        Node l = node.left;
        node.left = l.right;
        l.right = node;

        node.height = recalcHeight(node);
        l.height = recalcHeight(l);

        return l;
    }

    private static Node leftRotation(Node node) {
        Node r = node.right;
        node.right = r.left;
        r.left = node;

        node.height = recalcHeight(node);
        r.height = recalcHeight(r);

        return r;
    }

    private static int recalcHeight(Node node) {
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private static int getBalanceFactor(Node node) {
        return node == null ? 0 : (height(node.left) - height(node.right));
    }

    private static class Node {
        int key;
        Node left;
        Node right;
        int height = 1;

        Node(int key) {
            this.key = key;
        }
    }
}
