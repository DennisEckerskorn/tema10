package com.denniseckerskorn.ejer05;

import com.denniseckerskorn.lib.LibRandom;
import net.datafaker.Faker;

import java.util.*;

public class CentroSalud implements ICentroSalud {
    private ArrayList<Paciente> pacientes;
    private int numPacientes;

    public CentroSalud() {
        pacientes = new ArrayList<>();
        numPacientes = 0;
        addPacienteAleatorio(40);
    }

    public boolean addNuevoPaciente(String nombre, String apellido, String fechaNacimiento, Paciente.Sexo sexo, float altura, float peso) {
        if (numPacientes < pacientes.size()) {
            pacientes.add(new Paciente(nombre, apellido, fechaNacimiento, sexo, altura, peso));
            numPacientes++;
            return true;
        } else {
            return false;
        }
    }


    private void addPacienteAleatorio(int cantidadAlumnos) {
        Faker faker = new Faker(new Locale("es", "ES"));
        for(int i = 0; i < cantidadAlumnos; i++) {
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            String fechaNacimiento = faker.date().birthday(1, 100).toString();
            Paciente.Sexo sexo = LibRandom.randomInt(0, 1) == 0 ? Paciente.Sexo.M : Paciente.Sexo.F;
            float altura = LibRandom.randomFloat(0.50f, 2.00f);
            float peso = LibRandom.randomFloat(10.00f, 150.00f);
            pacientes.add(new Paciente(nombre, apellido, fechaNacimiento, sexo, altura, peso));
        }
    }

    @Override
    public int[] mayorMenor(List<Paciente> pacientes) {
        for(int i = 0; i < pacientes.size(); i++) {

        }
        return new int[0];
    }

    @Override
    public int[] pacientesPorSexo(List<Paciente> pacientes) {
        return new int[0];
    }

    @Override
    public double calcularIMC(Paciente paciente) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CentroSalud that = (CentroSalud) o;
        return Objects.equals(pacientes, that.pacientes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pacientes);
    }

    @Override
    public String toString() {
        return "CentroSalud{" +
                "pacientes=" + pacientes +
                ", numPacientes=" + numPacientes +
                '}';
    }
}
