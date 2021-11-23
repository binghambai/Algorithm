package Tree.BinaryTree;

public class BinaryTreeInt {
    public int val;
    public BinaryTreeInt right;
    public BinaryTreeInt left;
    public BinaryTreeInt() {

    }

    public BinaryTreeInt(int val, BinaryTreeInt left, BinaryTreeInt right) {
        this.val = val;
        this.left = left;
        this.right = right;
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
