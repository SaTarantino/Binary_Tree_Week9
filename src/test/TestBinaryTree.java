package test;
import binaryTree.BinaryTree;
import org.junit.jupiter.api.Test;

class TestBinaryTree {

    BinaryTree tree = new BinaryTree();

    void createTree() throws NullPointerException {
        tree.insert("a");
        tree.insert("b");
        tree.insert("c");
        tree.insert("d");
        tree.insert("e");
        tree.insert("f");
        tree.insert("g");
        tree.insert("h");
        tree.insert("i");
    }

}
