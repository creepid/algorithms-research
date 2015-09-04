/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.balancedtrees;

import static by.creepid.algorithms.searching.balancedtrees.LinkColor.BLACK;
import static by.creepid.algorithms.searching.balancedtrees.LinkColor.RED;

/**
 *
 * @author rusakovich
 *
 * While descending saving the property that current node is 4-node - thats
 * guarantee that last node will have the place for inserting node.
 *
 */
public class Descending234Tree<Key extends Comparable<Key>, Value> extends RedBlackTree<Key, Value> {

    @Override
    protected Node put(Node hNode, Key key, Value val) {
        if (hNode == null) {
            return new RBNode(key, val, 1, RED);
        }

        if (isRed(hNode.left) && isRed(hNode.right)) {
            flipColors(hNode);
        }

        int cmp = key.compareTo(hNode.key);
        if (cmp < 0) {
            hNode.left = put(hNode.left, key, val);
        } else if (cmp > 0) {
            hNode.right = put(hNode.right, key, val);
        } else {
            hNode.value = val;
        }

        if (isRed(hNode.right) && !isRed(hNode.left)) {
            hNode = this.rotateLeft(hNode);
        }
        if (isRed(hNode.left) && isRed(hNode.left.left)) {
            hNode = this.rotateRight(hNode);
        }

        hNode.n = size(hNode.left) + size(hNode.right) + 1;
        return hNode;
    }

    @Override
    public void put(Key key, Value val) {
        root = put(this.root, key, val);
        ((RBNode) root).color = BLACK;
    }

    @Override
    protected void flipColors(Node hNode) {
        ((RBNode) hNode).color = RED;
        if (hNode.left != null) {
            ((RBNode) hNode.left).color = BLACK;
        }
        if (hNode.right != null) {
            ((RBNode) hNode.right).color = BLACK;
        }
    }

    private Node balance(Node hNode) {
        if (isRed(hNode.right)) {
            hNode = rotateLeft(hNode);
        }

        if (isRed(hNode.right) && !isRed(hNode.left)) {
            hNode = this.rotateLeft(hNode);
        }
        if (isRed(hNode.left) && isRed(hNode.left.left)) {
            hNode = this.rotateRight(hNode);
        }
        if (isRed(hNode.left) && isRed(hNode.right)) {
            flipColors(hNode);
        }

        hNode.n = size(hNode.left) + size(hNode.right) + 1;

        flipColors(hNode);

        return hNode;
    }

    private Node moveRedLeft(Node hNode) {
        flipColors(hNode);

        if (hNode.right != null && isRed(hNode.right.left)) {
            hNode.right = rotateRight(hNode.right);
            hNode = rotateLeft(hNode);
        }

        return hNode;
    }

    private Node deleteMin(Node hNode) {
        if (hNode.left == null) {
            return null;
        }

        //Cause node easier to delete in 3-node 
        //than 2-node on the floor level 
        if (!isRed(hNode.left) && !isRed(hNode.left.left)) {
            hNode = moveRedLeft(hNode);
        }

        hNode.left = deleteMin(hNode.left);
        return balance(hNode);
    }

    private boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            ((RBNode) root).color = RED;
        }

        root = deleteMin(root);
        if (!isEmpty()) {
            ((RBNode) root).color = BLACK;
        }
    }

}
