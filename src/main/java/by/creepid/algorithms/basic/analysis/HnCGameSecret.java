/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.analysis;

import by.creepid.algorithms.utils.StdRandom;

/**
 *
 * @author mirash
 */
class HnCGameSecret {

    private static final int ATTEMPTS_CORRELATION = 4;
    private static final int INTERVAL_START = 1;
    private final int secret;
    private final Interval interval;
    private final int attemptsLimit;
    private int attempt;

    static class CheckResult {

        private boolean guessed;
        private boolean numberGreater;

        public CheckResult(boolean guessed, boolean numberGreater) {
            this.guessed = guessed;
            this.numberGreater = numberGreater;
        }

        public CheckResult() {
        }

        public boolean isGuessed() {
            return guessed;
        }

        public void setGuessed(boolean guessed) {
            this.guessed = guessed;
        }

        public boolean isNumberGreater() {
            return numberGreater;
        }

        public void setNumberGreater(boolean numberGreater) {
            this.numberGreater = numberGreater;
        }
    }

    private int getAttemptsLimit(int n, boolean strictMode) {
        return (strictMode)
                ? ((int) (Math.round(Math.log10((double) n))))
                : ((int) (2 * Math.round(Math.log10((double) n))) + ATTEMPTS_CORRELATION);
    }

    HnCGameSecret(int n) {
        this(n, false);
    }

    HnCGameSecret(int n, boolean strictMode) {
        interval = new Interval(INTERVAL_START, n);
        secret = StdRandom.randInt(INTERVAL_START, n);
        attemptsLimit = getAttemptsLimit(n, strictMode);
    }

    public CheckResult checkNumber(int number) {
        attempt++;

        if (attempt > attemptsLimit) {
            throw new IllegalStateException("You have exceeded the maximum number of attempts:" + attemptsLimit);
        }

        CheckResult result = new CheckResult();

        if (secret == number) {
            result.setGuessed(true);
        } else {
            result.setGuessed(false);

            if (number < secret) {
                result.setNumberGreater(false);
            } else {
                result.setNumberGreater(true);
            }

        }

        return result;
    }

    public Interval getInterval() {
        return interval;
    }

    public int getAttemptsLimit() {
        return attemptsLimit;
    }

    public int getAttempt() {
        return attempt;
    }
}
