/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic;

/**
 *
 * @author mirash
 *
 * Representation of a rational number
 */
public final class Rational {

    public static final Rational ZERO = new Rational(0, 1);
    private long numerator;
    private long denominator;

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalStateException("Denominator cannot be zero!");
        }

        if (numerator == 0) {
            this.denominator = denominator;
        } else {

            long divisor = Euclid.gcd(numerator, denominator);

            if (divisor != 1) {
                this.numerator = numerator / divisor;
                this.denominator = denominator / divisor;
            } else {
                this.numerator = numerator;
                this.denominator = denominator;
            }
        }
    }

    private void checkArg(Rational rational) {
        if (rational == null) {
            throw new IllegalArgumentException("Rational must not be null");
        }
    }

    public Rational negate() {
        return new Rational(-this.numerator, this.denominator);
    }

    public Rational plus(Rational another) {
        this.checkArg(another);

        if (another.equals(ZERO)) {
            return this;
        }
        if (this.equals(ZERO)) {
            return another;
        }

        long summNum = (this.numerator * another.denominator)
                + (another.numerator * this.denominator);
        long summDenom = this.denominator * another.denominator;

        return new Rational(summNum, summDenom);
    }

    public Rational minus(Rational another) {
        this.checkArg(another);

        if (another.equals(ZERO)) {
            return this;
        }
        if (this.equals(ZERO)) {
            return another.negate();
        }

        long summNum = (this.numerator * another.denominator)
                - (another.numerator * this.denominator);
        long summDenom = this.denominator * another.denominator;

        return new Rational(summNum, summDenom);
    }

    public Rational times(Rational another) {
        this.checkArg(another);

        long multiNum = (this.numerator * another.numerator);
        long multiDenom = (this.denominator * another.denominator);

        return new Rational(multiNum, multiDenom);
    }

    public Rational divides(Rational another) {
        this.checkArg(another);

        long multiNum = (this.numerator * another.denominator);
        long multiDenom = (this.denominator * another.numerator);

        return new Rational(multiNum, multiDenom);
    }

    public double toDouble() {
        return (double) (this.numerator / this.denominator);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Rational other = (Rational) obj;
        if (this.numerator != other.numerator) {
            return false;
        }

        if (this.denominator != other.denominator) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (this.numerator ^ (this.numerator >>> 32));
        hash = 79 * hash + (int) (this.denominator ^ (this.denominator >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        if (denominator == 0) {
            return String.valueOf(numerator);
        }

        return numerator + "/" + denominator;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }
}
