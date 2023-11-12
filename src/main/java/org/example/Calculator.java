package org.example;

import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = (a, b) -> a + b;
    BinaryOperator<Integer> minus = (a, b) -> a - b;
    BinaryOperator<Integer> multiply = (a, b) -> a * b;
    BinaryOperator<Integer> divide = (a, b) -> b == 0 ? 0 : a / b;
    UnaryOperator<Integer> pow = a -> a * a;
    UnaryOperator<Integer> abs = a -> a > 0 ? a : -a;
    Predicate<Integer> isPositive = a -> a > 0;
    Consumer<Integer> printLn = System.out::println;
}
