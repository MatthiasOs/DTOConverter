package de.ossi.util;

/**
 * Represents a function that accepts three arguments and produces a result. This is the three-arity specialization of Function.
 * This is a functional interface whose functional method is apply(Object, Object, Object)
 *
 * @param <T> the type of the input to the function
 * @param <K> the type of the second argument to the function
 * @param <U> the type of the third argument to the function
 * @param <R> the type of the result of the function
 */
@FunctionalInterface
public interface TriFunction<T, K, U, R> {
    /**
     * Applies this function to the given arguments
     *
     * @param t the first function argument
     * @param k the second function argument
     * @param u the third function argument
     * @return the function result
     */
    R apply(T t, K k, U u);
}
