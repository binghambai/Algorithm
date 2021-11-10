package Tree.BinaryTree;

public class BinaryTreeInt {
    int val;
    BinaryTreeInt right;
    BinaryTreeInt left;
    public BinaryTreeInt() {

    }

    public BinaryTreeInt(int val, BinaryTreeInt right, BinaryTreeInt left) {
        this.val = val;
        this.right = right;
        this.left = left;
    }

    public BinaryTreeInt(int val){
        this.val = val;
        this.right = null;
        this.left = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BinaryTreeInt getRight() {
        return right;
    }

    public void setRight(BinaryTreeInt right) {
        this.right = right;
    }

    public BinaryTreeInt getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeInt left) {
        this.left = left;
    }
}
