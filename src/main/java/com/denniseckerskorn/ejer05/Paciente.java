package com.denniseckerskorn.ejer05;

import java.util.Date;

public class Paciente {
    private static int nextID = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private char sexo;
    private float altura;
    private float peso;


    public Paciente(String nombre, String apellido, Date fechaNacimiento, char sexo, float altura, float peso) {
        this.id = nextID++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    /* TODO: Method not implemented yet...
    private int calcularEdadEnAnyos(String fechaNacimiento) {
        return 0;
    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paciente pacientes = (Paciente) o;
        return id == pacientes.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Pacientes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo=" + sexo +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
