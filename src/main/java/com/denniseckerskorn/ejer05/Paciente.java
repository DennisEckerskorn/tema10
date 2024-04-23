package com.denniseckerskorn.ejer05;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Paciente {
    public enum Sexo {M, F}

    ;
    private static int nextID = 1;
    private int id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Sexo sexo;
    private float altura;
    private float peso;


    public Paciente(String nombre, String apellido, String fechaNacimiento, Sexo sexo, float altura, float peso) throws DateTimeParseException {
        this.id = nextID++;
        this.nombre = nombre;
        this.apellido = apellido;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, fmt);
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    /**
     * Método que calcula la edad del paciente entre su fecha de nacimiento y la fecha actual.
     * @return la edad en años y en números enteros.
     */
    public int getEdad() {
        LocalDate ahora = LocalDate.now();
        Period period = Period.between(fechaNacimiento, ahora);
        return period.getYears();
    }

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
                ", edad=" + getEdad() +
                ", sexo=" + sexo +
                ", altura=" + altura +
                ", peso=" + peso +
                '}' + "\n";
    }
}
