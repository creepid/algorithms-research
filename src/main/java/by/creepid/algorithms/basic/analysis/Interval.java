/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.analysis;

/**
 *
 * @author mirash
 */
class Interval {

    private final int from;
    private final int to;

    Interval(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
