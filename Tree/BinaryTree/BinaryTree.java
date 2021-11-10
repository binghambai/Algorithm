package Tree.BinaryTree;

public class BinaryTree {
    String val;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree() {
    }

    public BinaryTree(String val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public BinaryTree(String val, BinaryTree left, BinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }
}
