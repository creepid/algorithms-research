/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.analysis;

import by.creepid.algorithms.basic.analysis.HnCGameSecret.CheckResult;
import by.creepid.algorithms.utils.Interval1D;
import java.util.LinkedHashMap;

/**
 *
 * @author mirash
 */
public class HnCGame {

    private final Interval interval;
    private final HnCGameSecret secret;
    private final int attemptsLimit;
    private LinkedHashMap<Integer, CheckResult> checkLog = new LinkedHashMap<>();

    public HnCGame(int n) {
        secret = new HnCGameSecret(n);
        interval = secret.getInterval();
        attemptsLimit = secret.getAttemptsLimit();
    }

    private int evaluate() {
        for (int leftEdge : checkLog.keySet()) {

            for (int rightEdge : checkLog.keySet()) {

                if (leftEdge == rightEdge) {
                    continue;
                }

                CheckResult leftCheck = checkLog.get(leftEdge);
                CheckResult rightCheck = checkLog.get(rightEdge);

                if (leftCheck.isNumberGreater() == rightCheck.isNumberGreater()) {
                    continue;
                }

                if (leftCheck.isNumberGreater() && !rightCheck.isNumberGreater()) {
                    Interval1D interval1D = new Interval1D(rightEdge, leftEdge);
                    if ((int) interval1D.length() == 2) {
                        return rightEdge + 1;
                    }
                }

                if (!leftCheck.isNumberGreater() && rightCheck.isNumberGreater()) {
                    Interval1D interval1D = new Interval1D(leftEdge, rightEdge);
                    if ((int) interval1D.length() == 2) {
                        return leftEdge + 1;
                    }
                }

                if ((!leftCheck.isNumberGreater() && !rightCheck.isNumberGreater()) 
                        && (Math.abs(leftEdge - rightEdge) == 1)) {
                    return Math.max(leftEdge, leftEdge) + 1;
                }
                
            }
        }


        return -1;
    }

    public int guessNumber() {
        int max = interval.getTo();
        int min = interval.getFrom();

        int number;

        CheckResult result;
        do {
            number = min + (max - min) / 2;

            int currentAttempt = secret.getAttempt();

            if (currentAttempt == attemptsLimit) {
                int evalResult = evaluate();
                if (evalResult != -1) {
                    return evalResult;
                }
            }

            result = secret.checkNumber(number);
            checkLog.put(number, result);

            if (result.isGuessed()) {
                return number;
            }

            if (result.isNumberGreater()) {
                max = number - 1;
            } else {
                min = number + 1;
            }


        } while (min <= max);


        throw new IllegalStateException("Cannot guess the number ((");
    }
}
