/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.bags;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rusakovich
 */
public class JosephusFlaviusSolution {

    private final int numberOfMans;
    private final int orderNumber;

    private Node<Integer> first;

    private final List<Integer> exitList = new ArrayList<>();

    private void initCycle() {
        first = new Node<>();
        first.item = 0;

        Node<Integer> current = first;
        for (int i = 1; i < numberOfMans; i++) {
            Node<Integer> next = new Node<>();
            next.item = i;

            current.next = next;
            current = next;
        }

        current.next = first;
    }

    private void removeNode(Node node) {

        Node prev = first;

        for (Node curr = first.next;; curr = curr.next) {

            if (curr == node) {
                prev.next = node.next;

                if (curr == first) {
                    first = curr.next;
                }

                break;
            }

            prev = curr;
        }

        prev = null;
        node = null;
    }

    public JosephusFlaviusSolution(int numberOfMans, int orderNumber) {
        this.numberOfMans = numberOfMans;
        this.orderNumber = orderNumber;
        initCycle();
        solve();
    }

    private void solve() {

        Node<Integer> startCountNode = first;
        for (int i = 0; i < numberOfMans; i++) {

            int j = 1;
            for (Node<Integer> curr = startCountNode;; curr = curr.next, j++) {
                if (j == orderNumber) {

                    if (first == first.next) {
                        exitList.add(first.item);
                        break;
                    }

                    startCountNode = (curr.next.next != curr)
                            ? curr.next : curr;

                    exitList.add(curr.item);
                    this.removeNode(curr);

                    break;
                }
            }

        }

    }

    public List<Integer> getExitOrder() {
        return exitList;
    }

}
