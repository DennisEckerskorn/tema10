package com.denniseckerskorn.ejer03;

import java.util.ArrayList;

/**
 * Esta clase implementa una pila utilizando un ArrayList interno para almacenar los elementos.
 *
 * @param <T> el tipo de elementos que se almacenarán en la pila.
 */
public class Pila<T> implements IPila<T> {
    private ArrayList<T> elements;

    /**
     * Constructor predeterminado que inicializa la pila con capacidad inicial predeterminada.
     */
    public Pila() {
        this.elements = new ArrayList<>();
    }

    /**
     * Constructor que inicializa la pila con una capacidad inicial específica.
     *
     * @param initialCapacity la capacidad inicial de la pila.
     */
    public Pila(int initialCapacity) {
        this.elements = new ArrayList<>(initialCapacity);
    }

    /**
     * Agrega un elemento a la parte superior de la pila.
     *
     * @param e el elemento a agregar.
     * @return el elemento agregado.
     */
    @Override
    public T push(T e) {
        elements.add(e);
        return e;
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return el elemento eliminado de la parte superior de la pila.
     * @throws IllegalStateException si la pila está vacía.
     */
    @Override
    public T pop() throws IllegalStateException{
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    /**
     * Devuelve el número de elementos en la pila.
     *
     * @return el número de elementos en la pila.
     */
    @Override
    public int size() {
        return elements.size();
    }

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     *
     * @return el elemento en la parte superior de la pila.
     * @throws IllegalStateException si la pila está vacía.
     */
    @Override
    public T top() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }
        return elements.get(elements.size() - 1);
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
