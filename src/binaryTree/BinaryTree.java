package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * A partial implementation of sorted binary trees.
 * <p>
 * The three constructors (construct an empty tree ({@link #BinaryTree()}, or a tree with a root value but no subtrees
 * ({@link #BinaryTree(Comparable)}, or a tree with a root value and left and right subtrees
 * ({@link #BinaryTree(Comparable, BinaryTree, BinaryTree)}), as well as the {@link #isEmpty()} method are already implemented.
 * <p>
 * For the remaining methods specified in the {@link BTree} interface ({@link #insert(Comparable)}, {@link #getValue()},
 * {@link #setValue(Comparable)}, {@link #getLeft()}, {@link #setLeft(BTree)}, {@link #getRight()}, {@link #setRight(BTree)},
 * {@link #contains(Comparable)}, and {@link #traverse()}) only a "stub" is provided.  For the logbook exercise you
 * should implement these methods.
 * <p>
 * Don't forget to test your implementation!
 *
 * @param <T> the type of value stored in the tree.
 *
 * @author Hugh Osborne.
 * @version December 2019.
 */
public class BinaryTree<T extends Comparable<? super T>> implements BTree<T> {

    /**
     * The root node of this tree.
     */
    private TreeNode<T> root;
    private Object NullPointerException;

    /**
     * Construct an empty tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a singleton tree.
     * A singleton tree contains a value in the root, but the left and right subtrees are
     * empty.
     * @param value the value to be stored in the tree.
     */
    public BinaryTree(T value) {
        root = new TreeNode<>(value);
    }

    /**
     * Construct a tree with a root value, and left and right subtrees.
     * @param value the value to be stored in the root of the tree.
     * @param left the tree's left subtree.
     * @param right the tree's right subtree.
     */
    public BinaryTree(T value,BinaryTree<T> left,BinaryTree<T> right) {
        root = new TreeNode<>(value,left,right);
    }

    /**
     * Check if the tree is empty.
     * @return true iff the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insert a new value in the binary tree at a position determined by the current contents
     * of the tree, and by the ordering on the type T.
     * @param value the value to be inserted into the tree.
     */
    public void insert(T value) {
        // implement insert(T value) here

        if (isEmpty()) {
            root = new TreeNode<>(value);
        } else if (value.compareTo(getValue()) < 0) {
            getLeft().insert(value);
        } else {
            getRight().insert(value);
        }
    }

    /**
     * Get the value stored at the root of the tree.
     * @return the value stored at the root of the tree.
     */
    public T getValue() throws NullPointerException {
        // Note: it might make sense to define getValue() to throw a (custom) exception if an attempt
        // is made to access a value from an empty tree.
        // However, since a tree is empty iff its root node is null, it is also acceptable to rely
        // on Java's NullPointerException.
        // This comment also applies to the other get and set methods defined in this interface.

        // placeholder return value below - replace with implementation of getValue()

        if (!isEmpty()) {
            return  root.getValue();
        } else throw new NullPointerException();
    }

    /**
     * Change the value stored at the root of the tree.
     * @param value the new value to be stored at the root of the tree.
     */
    public void setValue(T value) throws NullPointerException {
        // implement setValue(T value) here

        if (!isEmpty()) {
            root.setValue(value);
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Get the left subtree of this tree.
     * @return  This tree's left subtree.
     */
    public BTree<T> getLeft() throws NullPointerException {
        // placeholder return value below - replace with implementation of getLeft()

        if (!isEmpty()) {
           return root.getLeft();
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Change the left subtree of this tree.
     * @param tree the new left subtree.
     */
    public void setLeft(BTree<T> tree) throws NullPointerException {
        // implement setLeft(BTree<T> tree) here

        if (tree.getValue().compareTo(getValue()) > 0) {
            throw new NullPointerException();
        } else root.setLeft(tree);
    }

    /**
     * Get the right subtree of this tree.
     * @return this tree's right subtree.
     */
    public BTree<T> getRight() {
        // placeholder return value below - replace with implementation of getRight()

        if (!isEmpty()) {
            return root.getRight();
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Change the right subtree of this tree.
     * @param tree the new right subtree.
     */
    public void setRight(BTree<T> tree) {
        // implement setRight(BTree<T> tree) here

        if (tree.getValue().compareTo(getValue()) > 0) {
            throw new NullPointerException();
        } else root.setRight(tree);
    }

    /**
     * Check if the tree contains a given value.
     * @param value the value to be checked.
     * @return true iff the value is in the tree.
     */
    public boolean contains(T value) {
        // placeholder return value below - replace with implementation of contains(T value)

        if (isEmpty()) {
            return false;
        } else if (getValue().compareTo(value) == 0) {
            return true;
        } else if (value.compareTo(getValue()) < 0) {
            return getLeft().contains(value);
        } else if (value.compareTo(getValue()) > 0) {
            return getRight().contains(value);
        }

        return false;
    }

    /**
     * Traverse the tree, producing a list of all the values contained in the tree.
     * @return a list of all the values in the tree.
     */
    public List<T> traverse() {
        // placeholder return value below - replace with implementation of traverse()

        List<T> trv = new ArrayList<T>();
        inOrderTraverse(trv);
        return trv;
    }

    /**
     * Recursive method for the traverse method.
     * @param list
     */
    public void inOrderTraverse(List<T> list) {

        if (isEmpty()) {
            return;
        }
        ((BinaryTree<T>)getLeft()).inOrderTraverse(list);
        list.add(getValue());
        ((BinaryTree<T>)getRight()).inOrderTraverse(list);
    }
}
