package Data_Structure;

public class BinaryTreeNode<T> {

    protected T element;
    protected BinaryTreeNode<T> left;
    protected BinaryTreeNode<T> right;

    BinaryTreeNode(T object) {
        element = object;
        left = null;
        right = null;
    }

    public int numChildren() {
        int children = 0;
        if (left != null) children = 1 + left.numChildren();
        if (right != null) children = 1 + right.numChildren();
        return children;

    }


}
