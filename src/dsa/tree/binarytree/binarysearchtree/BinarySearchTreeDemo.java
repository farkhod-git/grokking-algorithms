package dsa.tree.binarytree.binarysearchtree;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BinarySearchTreeDemo {
    static void main() {
        BinarySearchTree bst = new BinarySearchTree();
        Set<Integer> set = new HashSet<>();

        Random random = new Random();
        int n = 1_000_000;
        for (int i = 0; i < n; i++) {
            int val = random.nextInt(n / 1000);
            if (bst.insert(val) != set.add(val)) {
                System.out.println("Wrong insert");
                break;
            }
        }

        for (Integer i : set) {
            if (bst.search(i) == null) {
                System.out.println("Wrong search");
                break;
            }
        }

        for (int i = 0; i < 500_000; i++) {
            if (bst.delete(i) != set.remove(i)) {
                System.out.println("Wrong delete");
                break;
            }
        }

        for (Integer i : set) {
            if (bst.search(i) == null) {
                System.out.println("Wrong search");
                break;
            }
        }
    }
}
