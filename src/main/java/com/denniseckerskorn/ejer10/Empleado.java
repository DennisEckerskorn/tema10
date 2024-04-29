package com.denniseckerskorn.ejer10;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Empleado de una Empresa con sus atributos y métodos necesarios.
 */
public class Empleado {
    private List<Hijo> hijos;
    private final String dni;
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNacimiento;
    private float sueldo;
    private int cantidadHijos;

    /**
     * Constructor que crea a un empleado con sus atributos.
     *
     * @param dni             String, DNI del empleado
     * @param nombre          String, nomnre del empleado.
     * @param apellidos       String, appelido/s del empleado.
     * @param fechaNacimiento LocalDate, fecha de nacimiento del empleado.
     * @param sueldo          float, sueldo del empleado.
     * @param cantidadHijos   int, cantidad de hijos del empleado.
     */
    public Empleado(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, float sueldo, int cantidadHijos) {
        this.hijos = new ArrayList<>();
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.cantidadHijos = cantidadHijos;
    }

    /**
     * Getter del array de hijos del empleado.
     *
     * @return List, hijos del empleado.
     */
    public List<Hijo> getHijos() {
        return hijos;
    }

    /**
     * Getter del DNI del empleado.
     *
     * @return String, DNI del empleado.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Getter del nombre del empleado.
     *
     * @return String, nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter del apellido/s del empleado.
     *
     * @return String, apellido/s del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Getter de la fecha de nacimiento del empleado.
     *
     * @return LocalDate, fecha de nacimiento del empleado.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Getter del sueldo del empleado.
     *
     * @return float, sueldo del empleado.
     */
    public float getSueldo() {
        return sueldo;
    }

    /**
     * Getter de la cantidad de hojos que tiene un empleado.
     *
     * @return int, cantidad de hijos del empleado.
     */
    public int getCantidadHijos() {
        return cantidadHijos;
    }

    /**
     * Setter del sueldo del empleado.
     *
     * @param nuevoSueldo float, el sueldo nuevo del empleado.
     */
    public void setSueldo(float nuevoSueldo) {
        sueldo = nuevoSueldo;
    }

    /**
     * Método que incrementa la variable cantidadHijos en 1 si se añade un hijo nuevo.
     */
    public void incrementaCantidadHijosEmpleado() {
        cantidadHijos += 1;
    }

    /**
     * Método que decrementa la variable cantidadHijos en 1 se quita un hijo.
     */
    public void decrementaCantidadHijosEmpleado() {
        cantidadHijos -= 1;
    }

    /**
     * Método que calcula la edad a paritir de la fecha de nacimiento.
     * Usa LocalDate para obtener la fecha actual y calcula la diferencia en años entre la fecha de nacimiento y ahora.
     *
     * @return int, la edad en números enteros, solo los años.
     */
    public int getEdadEmpleado() {
        LocalDate ahora = LocalDate.now();
        Period period = Period.between(fechaNacimiento, ahora);
        return period.getYears();
    }

    /**
     * Método que permite añadir un hijo nuevo al array de hijos de un empleado.
     * Si el array de hijos es distinto a null, creará un nuevo hijo con sus valores de los parámetros.
     *
     * @param nombre          String, nombre del hijo nuevo.
     * @param fechaNacimiento LocalDate, fecha de nacimiento del hijo nuevo.
     * @return {@true} si el hijo nuevo se ha creado y añadido al List, de lo contrario, {@false}
     */
    public boolean addHijo(String nombre, LocalDate fechaNacimiento) {
        if (hijos != null) {
            hijos.add(new Hijo(nombre, fechaNacimiento));
            return true;
        }
        return false;
    }

    /**
     * Método que inicializa la lista hijos a null.
     * Sirve para eliminar el array si el objeto empleado se destruye.
     */
    public void removeHijosList() {
        hijos = null;
    }

    /**
     * Método que busca dentro de la lista el hijo con el nombre indicado como parámetro.
     * Una vez se haya encontrado se elimina el hijo de la lista.
     *
     * @param nombreHijo String, nombre del hijo.
     * @return {@true} si el hijo se ha eliminado correctamente, de lo contrario, {@false}
     */
    public boolean removeHijo(String nombreHijo) {
        for (int i = 0; i < hijos.size(); i++) {
            if (hijos.get(i).getNombre().equals(nombreHijo)) {
                hijos.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empleado empleado = (Empleado) o;
        return dni.equals(empleado.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "hijos=" + hijos +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + getEdadEmpleado() +
                ", sueldo=" + sueldo +
                ", cantidadHijos=" + cantidadHijos +
                '}' + "\n";
    }
}
