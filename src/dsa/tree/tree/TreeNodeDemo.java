package dsa.tree.tree;

import java.util.List;

public class TreeNodeDemo {
    static void main() {
        TreeNode root = new TreeNode(1);
        root.children = List.of(
                new TreeNode(2),
                new TreeNode(3),
                new TreeNode(4),
                new TreeNode(5)
        );

        root.children.getFirst().children = List.of(
                new TreeNode(6),
                new TreeNode(7)
        );
    }
}
