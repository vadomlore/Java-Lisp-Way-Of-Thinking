import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Sqrt {

    /**
     * Lisp style of doing sqrt
     * @param x
     * @return
     */
    public double sqrt(double x){

        BinaryOperator<Double> average = (a, b) -> (a + b) / 2;

        UnaryOperator<Double> square = (c) -> c * c;

        Predicate<Double> accurate = (guess) -> Math.abs(square.apply(guess) - x) < 0.000000000000001;

        UnaryOperator<Double> improve = (guess) -> {
            double value = average.apply(guess, x / guess);
            System.out.println(value);
            return value;
        };
        return sqrt_iter(1.0, accurate, improve);
    }


    private double sqrt_iter(double guess, Predicate<Double> accurate, UnaryOperator<Double> improve){
        if (accurate.test(guess)) {
            return guess;
        }else{
            return sqrt_iter(improve.apply(guess), accurate, improve);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().sqrt(4));
    }
}
