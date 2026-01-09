package oobasics.task1;

public class Rational {
    private final int numerator;
    private final int denominator;
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Rational other = (Rational) obj;

        return this.numerator * other.denominator
                == other.numerator * this.denominator;
    }
}
