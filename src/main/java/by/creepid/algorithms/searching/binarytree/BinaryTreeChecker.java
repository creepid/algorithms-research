/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.binarytree;

import by.creepid.algorithms.searching.binarytree.BinaryTreeBase.Node;

/**
 *
 * @author rusakovich
 */
public class BinaryTreeChecker {

    private BinaryTreeChecker() {
    }

    public static boolean isBinaryTree(Node node) {
        if (node == null) {
            return true;
        }

        if (!isBinaryTree(node.left) || !isBinaryTree(node.right)) {
            return false;
        }

        int rightN = (node.right != null) ? node.right.n : 0;
        int leftN = (node.left != null) ? node.left.n : 0;

        return node.n == (rightN + leftN + 1);
    }

    public static <Key extends Comparable<Key>> boolean isOrdered(Node node, Key min, Key max) {
        if (node == null) {
            return true;
        }

        Node right = node.right;
        Node left = node.left;

        if (!isOrdered(right, min, max) || !isOrdered(left, min, max)) {
            return false;
        }

        if (right != null && node.key.compareTo(right.key) > 0) {
            return false;
        }

        if (left != null && node.key.compareTo(left.key) < 0) {
            return false;
        }

        return (node.key.compareTo(min) >= 0 && node.key.compareTo(max) <= 0);
    }

    public static boolean hasNoDuplicates(Node node) {
        if (node == null) {
            return true;
        }

        Node right = node.right;
        Node left = node.left;

        if (!hasNoDuplicates(node.left) || !hasNoDuplicates(node.right)) {
            return false;
        }

        if (right != null && node.key.compareTo(right.key) == 0) {
            return false;
        }

        if (left != null && node.key.compareTo(left.key) == 0) {
            return false;
        }

        return true;
    }

    public static boolean isBinaryTree(BinaryTreeBase bt) {
        if (!isBinaryTree(bt.root)) {
            return false;
        }

        if (!isOrdered(bt.root, bt.min(), bt.max())) {
            return false;
        }

        if (!hasNoDuplicates(bt.root)) {
            return false;
        }

        return true;
    }

}
