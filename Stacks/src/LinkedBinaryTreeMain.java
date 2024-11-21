import Data_Structure.EmptyCollectionException;
import Data_Structure.LinkedBinaryTree;

import java.util.Iterator;

public class LinkedBinaryTreeMain {

    public static void main(String[] args) {
        // Cria uma árvore com um nó raiz com o valor 10
        LinkedBinaryTree<Integer> rootTree = new LinkedBinaryTree<>(10);

        // Adiciona subárvores com valores 5 e 15
        LinkedBinaryTree<Integer> leftSubtree = new LinkedBinaryTree<>(5);
        LinkedBinaryTree<Integer> rightSubtree = new LinkedBinaryTree<>(15);

        LinkedBinaryTree<Integer> fullTree = new LinkedBinaryTree<>(10, leftSubtree, rightSubtree);

        // Testa o método getRoot
        System.out.println("Raiz da árvore: " + fullTree.getRoot());

        // Testa o método isEmpty
        System.out.println("A árvore está vazia? " + fullTree.isEmpty());

        // Testa o método size
        System.out.println("Tamanho da árvore: " + fullTree.size());

        // Testa o método contains
        System.out.println("Contém o elemento '5'? " + fullTree.contains(5));
        System.out.println("Contém o elemento '20'? " + fullTree.contains(20));

        // Testa o método iteratorInOrder
        System.out.println("Percurso em ordem:");
        Iterator<Integer> inOrderIterator = fullTree.iteratorInOrder();
        while (inOrderIterator.hasNext()) {
            System.out.print(inOrderIterator.next() + " ");
        }
        System.out.println();

        // Testa o método iteratorPreOrder
        System.out.println("Percurso em pré-ordem:");
        Iterator<Integer> preOrderIterator = fullTree.iteratorPreOrder();
        while (preOrderIterator.hasNext()) {
            System.out.print(preOrderIterator.next() + " ");
        }
        System.out.println();

        // Testa o método iteratorPostOrder
        System.out.println("Percurso em pós-ordem:");
        Iterator<Integer> postOrderIterator = fullTree.iteratorPostOrder();
        while (postOrderIterator.hasNext()) {
            System.out.print(postOrderIterator.next() + " ");
        }
        System.out.println();

        // Testa o método iteratorLevelOrder
        System.out.println("Percurso em nível (Level-order):");
        try {
            Iterator<Integer> levelOrderIterator = fullTree.iteratorLevelOrder();
            while (levelOrderIterator.hasNext()) {
                System.out.print(levelOrderIterator.next() + " ");
            }
            System.out.println();
        } catch (EmptyCollectionException e) {
            System.out.println("Erro: Coleção vazia.");
        }
    }
}
