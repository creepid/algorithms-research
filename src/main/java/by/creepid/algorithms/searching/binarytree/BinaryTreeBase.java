/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.binarytree;

import by.creepid.algorithms.basic.bags.LinkedListQueue;
import by.creepid.algorithms.basic.bags.Queue;

/**
 *
 * @author rusakovich
 */
public class BinaryTreeBase<Key extends Comparable<Key>, Value> {

    protected Node root;

    protected class Node {

        public Key key;
        public Value value;

        public Node left, right;

        public int n;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }

    }

    protected int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.n;
        }
    }

    public int size() {
        return size(root);
    }

    private Value get(Node currNode, Key targetKey) {
        if (currNode == null) {
            return null;
        }
        int cmp = targetKey.compareTo(currNode.key);

        if (cmp < 0) {
            return get(currNode.left, targetKey);
        } else if (cmp > 0) {
            return get(currNode.right, targetKey);
        } else {
            return currNode.value;
        }
    }

    public Value get(Key key) {
        //key searching
        return get(root, key);
    }

    private Node put(Node currNode, Key targetKey, Value val) {
        if (currNode == null) {
            return new Node(targetKey, val, 1);
        }

        int cmp = targetKey.compareTo(currNode.key);
        if (cmp < 0) {
            currNode.left = put(currNode.left, targetKey, val);
        } else if (cmp > 0) {
            currNode.right = put(currNode.right, targetKey, val);
        } else {
            currNode.value = val;
        }

        currNode.n = size(currNode.left) + size(currNode.right) + 1;
        return currNode;
    }

    /**
     * Searching for key. If it found - modify the value, otherwise - increase
     * tree size.
     *
     * @param key - target key
     * @param val - target value
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node min(Node currNode) {
        if (currNode.left == null) {
            return currNode;
        }
        return min(currNode.left);
    }

    /**
     * Min key in tree
     *
     * @return
     */
    public Key min() {
        return min(root).key;
    }

    private Node max(Node currNode) {
        if (currNode.right == null) {
            return currNode;
        }
        return max(currNode.right);
    }

    /**
     * Max key in tree
     *
     * @return
     */
    public Key max() {
        return max(root).key;
    }

    private Node floor(Node currNode, Key targetKey) {
        if (currNode == null) {
            return null;
        }

        int cmp = targetKey.compareTo(currNode.key);
        if (cmp == 0) {
            return currNode;
        }

        if (cmp < 0) {
            return floor(currNode.left, targetKey);
        }

        Node bigger = floor(currNode.right, targetKey);
        if (bigger != null) {
            return bigger;
        } else {
            return currNode;
        }
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node ceiling(Node currNode, Key targetKey) {
        if (currNode == null) {
            return null;
        }

        int cmp = targetKey.compareTo(currNode.key);
        if (cmp == 0) {
            return currNode;
        }

        if (cmp > 0) {
            return floor(currNode.left, targetKey);
        }

        Node less = floor(currNode.left, targetKey);
        if (less != null) {
            return less;
        } else {
            return currNode;
        }
    }

    public Key ceiling(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    /**
     * Return number of keys less then target key
     *
     * @param key - target key
     * @param currNode - current node to compare with
     * @return rank of target key
     */
    private int rank(Key targetKey, Node currNode) {
        if (currNode == null) {
            return 0;
        }

        int cmp = targetKey.compareTo(currNode.key);
        if (cmp < 0) {
            return rank(targetKey, currNode.left);
        } else if (cmp > 0) {
            return (1 + size(currNode.left) + rank(targetKey, currNode.right));
        } else {
            return size(currNode.left);
        }
    }

    /**
     * Return number of keys less then target key
     *
     * @param key - target key
     * @return rank of target key
     */
    public int rank(Key key) {
        return rank(key, root);
    }

    /**
     * Getting Node of giver rank
     *
     * @param currNode - node to compare with
     * @param targetRank - rank to select
     * @return node of given rank
     */
    private Node select(Node currNode, int targetRank) {
        if (currNode == null) {
            return null;
        }

        int leftBranchSize = size(currNode.left);

        if (leftBranchSize > targetRank) {
            return select(currNode.left, targetRank);
        } else if (leftBranchSize < targetRank) {
            return select(currNode.right, targetRank - leftBranchSize - 1);
        } else {
            return currNode;
        }
    }

    /**
     * Getting Node of giver rank
     *
     * @param rank - rank to select
     * @return node of given rank
     */
    public Key select(int rank) {
        return select(root, rank).key;
    }

    /**
     * Deleting min node
     *
     * @param currNode - node to delete
     * @return right sibling node of deleted node
     */
    private Node deleteMin(Node currNode) {
        if (currNode.left == null) {
            return currNode.right;
        }

        currNode.left = deleteMin(currNode.left);
        currNode.n = size(currNode.left) + size(currNode.right) + 1;

        return currNode;
    }

    /**
     * Deleting min node
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node currNode, Key targetKey) {
        if (currNode == null) {
            return null;
        }

        int cmp = targetKey.compareTo(currNode.key);
        if (cmp < 0) {
            currNode.left = delete(currNode.left, targetKey);
        } else if (cmp > 0) {
            currNode.right = delete(currNode.right, targetKey);
        } else {
            if (currNode.right == null) {
                return currNode.left;
            }

            if (currNode.right == null) {
                return currNode.right;
            }

            //saving link on deleting node to targetNode
            Node targetNode = currNode;
            //put in currNode it's incomer
            currNode = min(targetNode.right);
            //put in link on all nodes less than min of targetNode
            currNode.right = deleteMin(targetNode.right);
            //saving link to left branch of removed node
            currNode.left = targetNode.left;
        }

        //update n of node
        currNode.n = size(currNode.left) + size(currNode.right) + 1;
        return currNode;

    }

    void print(BTPrinter<Key> printer, Node node) {
        if (node == null) {
            return;
        }

        print(printer, node.left);
        printer.print(node.key);
        print(printer, node.right);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        LinkedListQueue<Key> queue = new LinkedListQueue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
        if (node == null) {
            return;
        }

        int cmplo = lo.compareTo(node.key);
        int cmphi = hi.compareTo(node.key);

        if (cmplo < 0) {
            keys(node.left, queue, lo, hi);
        }

        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(node.key);
        }

        if (cmphi > 0) {
            keys(node.right, queue, lo, hi);
        }
    }

}
