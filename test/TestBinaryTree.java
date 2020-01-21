import binaryTree.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TestBinaryTree<T> {

    BinaryTree tree = new BinaryTree();
    List<T> list = new ArrayList<T>();
    List<T> trv = new ArrayList<T>();

    /**
     * create a Binary Tree for the tests.
      */
    void createTree() throws NullPointerException {
        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(-1);
        tree.insert(-2);
        tree.insert(-3);
        tree.insert(-4);
        tree.insert(-5);
        tree.inOrderTraverse(trv);
    }

    /**
     * test the getValue method.
     */
    @Test
    void getValueTest() {
        createTree();
        assertTrue(tree.getValue().compareTo(0) == 0);
        assertFalse(tree.getValue().compareTo(1) == 0);
    }

    /**
     * test for the insert method
     */
    @Test
    void insetTest() {
        createTree();
        tree.insert(-6);
        tree.insert(6);
        assertTrue(tree.contains(-6));
        assertTrue(tree.contains(6));
    }

    /**
     * test for the setValue method
     */
    @Test
    void setValueTest() {
        createTree();
        assertTrue(tree.getValue().compareTo(0) == 0);
        tree.setValue(42);
        assertTrue(tree.getValue().compareTo(42) == 0);
        assertFalse(tree.getValue().compareTo(0) == 0);
    }

    /**
     * test the contains method.
     */
    @Test
    void containsTest() {
        createTree();
        assertTrue(tree.contains(-5));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(0));
        assertFalse(tree.contains(6));
        assertFalse(tree.contains(-6));
        assertFalse(tree.contains(10));
    }

    /**
     * test the traverse test
     */
    @Test
    void inOrderTraverseTest() {
        createTree();
        tree.inOrderTraverse(list);
        assertTrue(trv.equals(list));
        assertTrue(list.contains(0));
        assertTrue(list.contains(-5));
        assertTrue(list.contains(5));
    }
}
