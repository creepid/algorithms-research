/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.uf;

import by.creepid.algorithms.basic.analysis.Interval;
import java.util.Random;

/**
 *
 * @author mirash
 */
public class ErdosRenyi {

    private final UnionFinding unionFinding;
    private final int n;
    private int count;
    private UFPrinter printer;

    public ErdosRenyi(UnionFinding unionFinding, int n) {
        this.n = n;
        this.unionFinding = unionFinding;
    }

    private int getRandom(Interval interval) {
        Random random = new Random();
        return random.nextInt(interval.getTo());
    }

    private void init() {
        count = getRandom(new Interval(0, n - 1));
        if (printer != null) {
            printer.printPairsCount(count);
        }

        int p;
        int q;
        for (int i = 0; i < count; i++) {
            p = getRandom(new Interval(0, n - 1));
            q = getRandom(new Interval(0, n - 1));

            if (printer != null) {
                printer.printPair(p, q);
            }

            if (!unionFinding.connected(p, q)) {
                unionFinding.union(p, q);
            }

        }
    }

    public int getCount() {
        init();
        return count;
    }

    public void setPrinter(UFPrinter printer) {
        this.printer = printer;
    }
}
