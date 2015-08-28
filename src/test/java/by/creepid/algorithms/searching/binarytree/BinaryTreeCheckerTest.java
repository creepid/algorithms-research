/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.binarytree;

import by.creepid.algorithms.searching.binarytree.BinaryTreeBase.Node;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class BinaryTreeCheckerTest {

    public BinaryTreeCheckerTest() {
    }

    private BinaryTreeBase<String, Integer> bt;

    @Before
    public void beforeMethod() {
        bt = new BinaryTreeBase<String, Integer>();
    }

    @After
    public void afterMethod() {
        bt = null;
    }

    /**
     * Test of isBinaryTree method, of class BinaryTreeChecker.
     */
    @Test
    public void testIsBinaryTree() {
        System.out.println("****** testIsBinaryTree *******");
        Node root = bt.new Node("M", 3, 1);
        assertTrue(BinaryTreeChecker.isBinaryTree(root));

        Node falseRoot = bt.new Node("G", 3, 5);
        assertFalse(BinaryTreeChecker.isBinaryTree(falseRoot));

        root = bt.new Node("M", 3, 3);
        Node left = bt.new Node("G", 34, 1);
        Node right = bt.new Node("T", 34, 1);
        root.left = left;
        root.right = right;

        assertTrue(BinaryTreeChecker.isBinaryTree(root));

        root = bt.new Node("R", 3, 3);
        left = bt.new Node("H", 34, 2);
        root.left = left;
        Node leftRight = bt.new Node("M", 34, 1);
        left.right = leftRight;

        assertTrue(BinaryTreeChecker.isBinaryTree(root));

    }

    /**
     * Test of isOrdered method, of class BinaryTreeChecker.
     */
    @Test
    public void testIsOrdered() {
        System.out.println("****** testIsOrdered *******");
        Node root = bt.new Node("A", 3, 1);
        assertTrue(BinaryTreeChecker.isOrdered(root, "A", "A"));

        root = bt.new Node("B", 3, 1);
        Node left = bt.new Node("A", 34, 1);
        Node right = bt.new Node("X", 34, 1);
        root.left = left;
        root.right = right;
        assertTrue(BinaryTreeChecker.isOrdered(root, "A", "X"));

        root = bt.new Node("B", 3, 1);
        left = bt.new Node("M", 34, 1);
        right = bt.new Node("X", 34, 1);
        root.left = left;
        root.right = right;
        assertFalse(BinaryTreeChecker.isOrdered(root, "B", "X"));

        root = bt.new Node("B", 3, 1);
        left = bt.new Node("A", 34, 1);
        right = bt.new Node("X", 34, 1);
        root.left = left;
        root.right = right;
        assertFalse(BinaryTreeChecker.isOrdered(root, "A", "G"));

    }

    /**
     * Test of hasNoDuplicates method, of class BinaryTreeChecker.
     */
    @Test
    public void testHasNoDuplicates() {
        System.out.println("****** testHasNoDuplicates *******");

        Node root = bt.new Node("B", 3, 1);
        Node left = bt.new Node("M", 34, 1);
        Node right = bt.new Node("X", 34, 1);
        root.left = left;
        root.right = right;

        assertTrue(BinaryTreeChecker.hasNoDuplicates(root));

        left = bt.new Node("B", 34, 1);
        root.left = left;
        assertFalse(BinaryTreeChecker.hasNoDuplicates(root));
    }
    

}
