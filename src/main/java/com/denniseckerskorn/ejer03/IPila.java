package com.denniseckerskorn.ejer03;

public interface IPila<T> {
    T push(T e);
    T pop();
    int size();
    T top();
    boolean isEmpty();
}
