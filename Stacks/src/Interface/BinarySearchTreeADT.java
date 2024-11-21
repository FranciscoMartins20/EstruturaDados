package Interface;

import Data_Structure.EmptyCollectionException;

public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {

    public void addElement(T element);

    public T removeElement(T targetElement) throws EmptyCollectionException;

    public void removeAllOccurrences(T targetElement) throws EmptyCollectionException;

    public T removeMin() throws EmptyCollectionException;

    public T removeMax() throws EmptyCollectionException;

    public T findMin() throws EmptyCollectionException;

    public T findMax() throws EmptyCollectionException;


}
