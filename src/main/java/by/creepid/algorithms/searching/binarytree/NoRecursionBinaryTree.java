/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.binarytree;

/**
 *
 * @author rusakovich
 *
 * May be useful in case of deep call stack
 */
public class NoRecursionBinaryTree<Key extends Comparable<Key>, Value> extends BinaryTreeBase<Key, Value> {

    @Override
    public Value get(Key key) {
        //key searching
        Node curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.key);
            if (cmp == 0) {
                return curr.value;
            } else if (cmp < 0) {
                curr = curr.left;
            } else if (cmp > 0) {
                curr = curr.right;
            }
        }
        return null;
    }

    @Override
    public void put(Key key, Value val) {
        if (root == null) {
            root = new Node(key, val, 1);
            return;
        }

        Node curr = root;
        Node parent = null;

        while (curr != null) {
            int cmp = key.compareTo(curr.key);

            parent = curr;
            if (cmp < 0) {
                curr = curr.left;
                if (curr == null) {
                    parent.left = new Node(key, val, 1);
                }
            } else if (cmp > 0) {
                curr = curr.right;
                if (curr == null) {
                    parent.right = new Node(key, val, 1);
                }
            } else {
                curr.value = val;
                return;
            }
        }

        //undate indexes
        Node parentOfInserted = parent;
        parentOfInserted.n++;

        curr = root;
        while (curr != null) {
            if (curr == parentOfInserted) {
                break;
            }

            curr.n++;
            int cmp = key.compareTo(curr.key);
            if (cmp < 0) {
                curr = curr.left;
            } else if (cmp > 0) {
                curr = curr.right;
            }
        }

    }
}
