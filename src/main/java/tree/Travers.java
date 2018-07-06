package tree;

public class Travers {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.value = 5;

        Tree left = new Tree();
        left.value = 4;
        Tree right = new Tree();
        right.value = 7;

        tree.left = left;
        tree.right = right;

        System.out.println(checkOne(tree, 5, 1));
    }

    private static int checkOne(Tree tree, int root, int currentVisibleCount) {
        if (tree.left != null) {
            if (tree.left.value > root) {
                currentVisibleCount = currentVisibleCount + 1;
            }
            currentVisibleCount = checkOne(tree.left, root, currentVisibleCount);
        }

        if (tree.right != null) {
            if (tree.right.value > root) {
                currentVisibleCount = currentVisibleCount + 1;
            }
            currentVisibleCount = checkOne(tree.right, root, currentVisibleCount);
        }
        return currentVisibleCount;
    }

}
