package Data_Structure;

import Interface.BinarySearchTreeADT;

public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

    public LinkedBinarySearchTree() {
        super();
    }

    public LinkedBinarySearchTree(T element) {
        super(element);
    }


    @Override
    public void addElement(T element) {

        BinaryTreeNode<T> temp = new BinaryTreeNode<>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty()) {
            root = temp;
        } else {
            BinaryTreeNode<T> current = root;
            boolean added = false;

            while (!added) {
                if (comparableElement.compareTo(current.element) < 0) {
                    if (current == null) {
                        current.left = temp;
                        added = true;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current == null) {
                        current.right = temp;
                        added = true;
                    } else {
                        current = current.right;
                    }

                }

            }

        }

        count++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;

        if (isEmpty()) {
            if (((Comparable) targetElement).equals(root.element)) {
                result = root.element;
                root = replacement(root);
                count--;
            } else {
                BinaryTreeNode<T> current, parent = root;
                boolean found = false;

                if (((Comparable) targetElement).compareTo(root.element) < 0) {
                    current = root.left;
                } else {
                    current = root.right;
                }

                while (current != null && !found) {
                    if (targetElement.equals(current.element)) {
                        found = true;
                        count--;
                        result = current.element;
                    }
                    if (current == parent.left) {
                        parent.left = replacement(current);
                    }
                    if (current == parent.right) {
                        parent.right = replacement(current);
                    } else {
                        parent = current;
                        if (((Comparable) targetElement).compareTo(current.element) < 0) {
                            current = current.left;
                        } else {
                            current = current.right;
                        }
                    }
                }
                if (!found) {
                    throw new ElementNotFoundException("Element not found");
                }


            }

        }

        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException {
        removeElement(targetElement);

        try {
            while (contains(targetElement)) {
                removeElement(targetElement);
            }
        } catch (Exception ElementNotFoundException) {
            throw new ElementNotFoundException("Element not found");
        }

    }

    @Override
    public T removeMin() throws EmptyCollectionException {
        T result = null;
        if (isEmpty()) {
            throw new EmptyCollectionException("Collection is empty");
        } else {
            if (root.left != null) {
                result = root.element;
                root = root.right;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;
                while (current != null) {
                    parent = current;
                    current = current.left;
                }
                result = current.element;
                parent.left = current.right;
            }
            count--;
        }


        return result;
    }

    @Override
    public T removeMax() throws EmptyCollectionException {
        T result = null;
        if (isEmpty()) {
            throw new EmptyCollectionException("Collection is empty");
        } else {
            if (root.right != null) {
                result = root.element;
                root = root.left;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;
                while (current.right != null) {
                    parent = current;
                    current = current.right;
                }
                result = current.element;
                parent.right = current.left;
            }
            count--;
        }

        return result;
    }

    @Override
    public T findMin() throws EmptyCollectionException {
        T result = null;

        if (isEmpty()) throw new EmptyCollectionException("binary tree");
        else {
            BinaryTreeNode<T> current = root;

            while (current.left != null) current = current.left;

            result = current.element;
        } //else

        return result;


    }

    @Override
    public T findMax() throws EmptyCollectionException {
        T result = null;

        if (isEmpty()) throw new EmptyCollectionException("binary tree");
        else {
            BinaryTreeNode<T> current = root;

            while (current.right != null) current = current.right;

            result = current.element;
        } //else

        return result;
    }

    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;

        if ((node.left == null) && (node.right == null)) result = null;
        else if ((node.left != null) && (node.right == null)) result = node.left;
        else if ((node.left == null) && (node.right != null)) result = node.right;
        else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;

            while (current.left != null) {
                parent = current;
                current = current.left;
            }

            if (node.right == current) current.left = node.left;
            else {
                parent.left = current.right;
                current.right = node.right;
                current.left = node.left;
            }
            result = current;
        }//else
        return result;


    }

}
