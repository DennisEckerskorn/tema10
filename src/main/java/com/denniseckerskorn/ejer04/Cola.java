package com.denniseckerskorn.ejer04;

import java.util.ArrayList;

/**
 * Esta clase implementa una cola utilizando un ArrayList interno para almacenar los elementos.
 *
 * @param <T> el tipo de elementos que se almacenarán en la cola.
 */
public class Cola<T> implements ICola<T> {
    private ArrayList<T> elements;

    /**
     * Constructor predeterminado que inicializa la cola con capacidad inicial predeterminada.
     */
    public Cola() {
        this.elements = new ArrayList<>();
    }

    /**
     * Constructor que inicializa la cola con una capacidad inicial específica.
     *
     * @param initialCapacity la capacidad inicial de la cola.
     */
    public Cola(int initialCapacity) {
        this.elements = new ArrayList<>(initialCapacity);
    }

    /**
     * Añade un elemento al final de la cola.
     *
     * @param e el elemento a añadir.
     * @return true si el elemento fue agregado correctamente, false en caso contrario.
     */
    @Override
    public boolean add(T e) {
        return elements.add(e);
    }

    /**
     * Elimina y devuelve el elemento en el frente de la cola.
     *
     * @return el elemento eliminado del frente de la cola.
     * @throws IllegalStateException si la cola está vacía.
     */
    @Override
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }

        return elements.remove(0);
    }

    /**
     * Devuelve el número de elementos en la cola.
     *
     * @return el número de elementos en la cola.
     */
    @Override
    public int size() {
        return elements.size();
    }

    /**
     * Devuelve el elemento en el frente de la cola sin eliminarlo.
     *
     * @return el elemento en el frente de la cola.
     * @throws IllegalStateException si la cola está vacía.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        return elements.get(0);
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
