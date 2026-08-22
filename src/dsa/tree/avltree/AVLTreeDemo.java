package dsa.tree.avltree;

// AVL is the very first self-balancing binary search tree
// G.M Adelson-Velsky, E.M Landis were Soviet mathematicians and computer scientists
//         who invented AVL tree in 1962

// In AVL tree, the balance factor of each node is always between -1 and 1
// Balance factor = height(left subtree) - height(right subtree)
public class AVLTreeDemo {
    static void main() {
        AVLTree avl = new AVLTree();
        avl.insert(10);
        avl.insert(5);
        avl.insert(15);
        avl.insert(3);
        avl.insert(1);
        avl.insert(13);
        avl.insert(20);
        avl.insert(25);
        avl.insert(67);
    }
}
