public class Fraction {

    public int numerator;
    public int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Ошибка! Знаменатель не может быть равен 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction plus(Fraction fr2) {
        int newNum = numerator * fr2.denominator + fr2.numerator * denominator;
        return new Fraction(newNum, denominator * fr2.denominator);
    }

    public Fraction plus(int integer) {
        return plus(new Fraction(integer, 1));
    }

    public Fraction minus(Fraction fr2) {
        int newNum = numerator * fr2.denominator - fr2.numerator * denominator;
        return new Fraction(newNum, denominator * fr2.denominator);
    }

    public Fraction minus(int integer) {
        return minus(new Fraction(integer, 1));
    }

    public Fraction mul(Fraction fr2) {
        return new Fraction(numerator * fr2.numerator, denominator * fr2.denominator);
    }

    public Fraction mul(int integer) {
        return mul(new Fraction(integer, 1));
    }

    public Fraction div(Fraction fr2) {
        return new Fraction(numerator * fr2.denominator, denominator * fr2.numerator);
    }

    public Fraction div(int integer) {
        return div(new Fraction(integer, 1));
    }
}
