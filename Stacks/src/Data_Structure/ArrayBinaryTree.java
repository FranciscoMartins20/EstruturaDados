package Data_Structure;

import Interface.BinaryTreeADT;

import java.util.Iterator;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {
    private final int capacity = 50;
    protected int count;
    public T[] tree;

    public ArrayBinaryTree() {
        count = 0;
        tree = (T[]) new Object[capacity];
    }

    public ArrayBinaryTree(T element) {
        count = 1;
        tree = (T[]) new Object[capacity];
        tree[0] = element;

    }

    protected void expandCapacity() {
        T[] temp = (T[]) new Object[tree.length * 2];
        for (int ct = 0; ct < tree.length; ct++)
            temp[ct] = tree[ct];
        tree = temp;
    }

    @Override
    public T getRoot() {
        return tree[0];
    }

    @Override
    public boolean isEmpty() {

        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(T targetElement) {
        boolean found = false;

        for (int ct = 0; ct < count && !found; ct++)
            if (targetElement.equals(tree[ct]))
                found = true;

        return found;
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        T temp = null;
        boolean found = false;

        for (int ct = 0; ct < count && !found; ct++)
            if (targetElement.equals(tree[ct])) {
                found = true;
                temp = tree[ct];
            }

        if (!found)
            throw new ElementNotFoundException("binary tree");

        return temp;
    }

    public String toString() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
        inorder(0, templist);
        return templist.toString();
    }


    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
        inorder(0, templist);
        return templist.iterator();
    }

    protected void inorder(int node, ArrayUnorderedList<T> templist) {
        if (node < tree.length)
            if (tree[node] != null) {
                inorder((node + 1) * 2 - 1, templist);
                templist.addToRear(tree[node]);
                inorder((node + 1) * (2 + 1) - 1, templist);
            }
    }


    @Override
    public Iterator<T> iteratorPreOrder() {

        ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
        preorder(0, templist);
        return templist.iterator();
    }

    protected void preorder(int node, ArrayUnorderedList<T> templist) {
        if (node < tree.length)
            if (tree[node] != null) {
                templist.addToRear(tree[node]);
                inorder((node + 1) * 2 - 1, templist);
                inorder((node + 1) * (2 + 1) - 1, templist);
            }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
        postorder(0, templist);
        return templist.iterator();
    }

    protected void postorder(int node, ArrayUnorderedList<T> templist) {
        if (node < tree.length)
            if (tree[node] != null) {
                inorder((node + 1) * 2 - 1, templist);
                inorder((node + 1) * (2 + 1) - 1, templist);
                templist.addToRear(tree[node]);

            }


    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
        for (int ct = 0; ct < count; ct++)
            templist.addToRear(tree[ct]);
        return templist.iterator();
    }


//como tinha problemas a instanciar criei um addElement at em que vai buscar o index e coloca o element
    public void addElementAt(int index, T element) {
        if (index >= tree.length) {
            expandCapacity();
        }
        tree[index] = element;
        count++;
    }
}


