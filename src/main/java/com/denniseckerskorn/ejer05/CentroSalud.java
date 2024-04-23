package com.denniseckerskorn.ejer05;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class CentroSalud implements ICentroSalud {
    private ArrayList<Paciente> pacientes;
    private int numPacientes;

    public CentroSalud() {
        pacientes = new ArrayList<>();
        numPacientes = 0;
    }

    public boolean addNuevoPaciente(String nombre, String apellido, Date fechaNacimiento, char sexo, float altura, float peso) {
        if (numPacientes < pacientes.size()) {
            pacientes.add(new Paciente(nombre, apellido, fechaNacimiento, sexo, altura, peso));
            numPacientes++;
            return true;
        } else {
            return false;
        }
    }

    /*
    private boolean addPacienteAleatorio(String nombre, String apellido, Date fechaNacimiento, char sexo, float altura, float peso) {

    }
     */

    @Override
    public int[] mayorMenor(ArrayList<Paciente> pacientes) {
        return new int[0];
    }

    @Override
    public int[] pacientesPorSexo(ArrayList<Paciente> pacientes) {
        return new int[0];
    }

    @Override
    public double calcularIMC(Paciente paciente) {
        return 0;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
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
                '}';
    }
}
