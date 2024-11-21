import Data_Structure.ArrayBinaryTree;
import Data_Structure.ElementNotFoundException;
import Data_Structure.EmptyCollectionException;
import Data_Structure.LinkedBinaryTree;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayBinaryTreeMain {

    public static void main(String[] args) throws EmptyCollectionException {

        ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>(1);

        tree.addElementAt(1, 1);
        tree.addElementAt(2, 2);
        tree.addElementAt(3, 3);

        // Testando o método getRoot()
        System.out.println("Raiz da árvore: " + tree.getRoot());

        // Testando o método isEmpty()
        System.out.println("A árvore está vazia? " + tree.isEmpty());

        // Testando o método size()
        System.out.println("Tamanho da árvore: " + tree.size());

        // Testando o método contains()
        System.out.println("A árvore contém o elemento 3? " + tree.contains(3));
        System.out.println("A árvore contém o elemento 10? " + tree.contains(10));

        // Testando o método find()
        try {
            System.out.println("Elemento encontrado: " + tree.find(4));
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Testando a iteração InOrder
        System.out.println("Elementos em ordem (InOrder):");
        Iterator<Integer> iteratorInOrder = tree.iteratorInOrder();
        while (iteratorInOrder.hasNext()) {
            System.out.print(iteratorInOrder.next() + " ");
        }
        System.out.println();

        // Testando a iteração PreOrder
        System.out.println("Elementos em pré-ordem (PreOrder):");
        Iterator<Integer> iteratorPreOrder = tree.iteratorPreOrder();
        while (iteratorPreOrder.hasNext()) {
            System.out.print(iteratorPreOrder.next() + " ");
        }
        System.out.println();

        // Testando a iteração PostOrder
        System.out.println("Elementos em pós-ordem (PostOrder):");
        Iterator<Integer> iteratorPostOrder = tree.iteratorPostOrder();
        while (iteratorPostOrder.hasNext()) {
            System.out.print(iteratorPostOrder.next() + " ");
        }
        System.out.println();

        // Testando a iteração LevelOrder
        System.out.println("Elementos em nível (LevelOrder):");
        Iterator<Integer> iteratorLevelOrder = tree.iteratorLevelOrder();
        while (iteratorLevelOrder.hasNext()) {
            System.out.print(iteratorLevelOrder.next() + " ");
        }
        System.out.println();
    }
}
