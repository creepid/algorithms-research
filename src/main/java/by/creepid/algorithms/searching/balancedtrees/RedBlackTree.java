/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.balancedtrees;

import static by.creepid.algorithms.searching.balancedtrees.LinkColor.RED;
import static by.creepid.algorithms.searching.balancedtrees.LinkColor.BLACK;
import by.creepid.algorithms.searching.binarytree.BinaryTreeBase;

/**
 *
 * @author rusakovich
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> extends BinaryTreeBase<Key, Value> {

    protected class RBNode extends BinaryTreeBase<Key, Value>.Node {

        LinkColor color;

        public RBNode(Key key, Value value, int n, LinkColor color) {
            super(key, value, n);
            this.color = color;
        }

    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return (((RBNode) node).color == RED);
    }

    private Node rotateLeft(Node hNode) {
        Node xNode = hNode.right;
        hNode.right = xNode.left;
        xNode.left = hNode;
        ((RBNode) xNode).color = ((RBNode) hNode).color;
        ((RBNode) hNode).color = RED;
        xNode.n = hNode.n;
        hNode.n = 1 + size(hNode.left) + size(hNode.right);
        return xNode;
    }

    private Node rotateRight(Node hNode) {
        Node xNode = hNode.left;
        hNode.left = xNode.right;
        xNode.right = hNode;
        ((RBNode) xNode).color = ((RBNode) hNode).color;
        ((RBNode) hNode).color = RED;
        xNode.n = hNode.n;
        hNode.n = 1 + size(hNode.left) + size(hNode.right);
        return xNode;
    }

    /**
     * Flips color from RED to BLACK, and parent of hNode changes color from
     * BLACK to RED
     *
     * @param hNode - target node
     */
    private void flipColors(Node hNode) {
        ((RBNode) hNode).color = RED;
        ((RBNode) hNode.left).color = BLACK;
        ((RBNode) hNode.right).color = BLACK;
    }

    private Node put(Node hNode, Key key, Value val) {
        if (hNode == null) {
            return new RBNode(key, val, 1, RED);
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
        if (isRed(hNode.left) && isRed(hNode.right)) {
            flipColors(hNode);
        }
        
        hNode.n = size(hNode.left) + size(hNode.right) + 1;
        return hNode;
    }

    @Override
    public void put(Key key, Value val) {
        root = put(this.root, key, val);
        ((RBNode) root).color = BLACK;
    }

}
