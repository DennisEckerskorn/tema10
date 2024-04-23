package com.denniseckerskorn.ejer05;

import com.denniseckerskorn.lib.LibRandom;
import net.datafaker.Faker;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Clase que representa un centro de salud.
 */
public class CentroSalud implements ICentroSalud {
    private static final int CANTIDAD_ALUMNOS = 50;
    private ArrayList<Paciente> pacientes;
    private int numPacientes;

    /**
     * Constructor de la clase CentroSalud. Inicializa la lista de pacientes y agrega pacientes aleatorios.
     */
    public CentroSalud() {
        pacientes = new ArrayList<>();
        numPacientes = 0;
        //addPacienteAleatorio(CANTIDAD_ALUMNOS);
    }

    /**
     * Agrega un nuevo paciente al centro de salud.
     *
     * @param nombre          Nombre del paciente.
     * @param apellido        Apellido del paciente.
     * @param fechaNacimiento Fecha de nacimiento del paciente en formato "dd/MM/yyyy".
     * @param sexo            Sexo del paciente (M para masculino, F para femenino).
     * @param altura          Altura del paciente en metros.
     * @param peso            Peso del paciente en kilogramos.
     * @return true si se agregó el paciente correctamente, false si no se pudo agregar.
     */
    public boolean addNuevoPaciente(String nombre, String apellido, String fechaNacimiento, Paciente.Sexo sexo, float altura, float peso) {
        try{
            pacientes.add(new Paciente(nombre, apellido, fechaNacimiento, sexo, altura, peso));
            numPacientes++;
            return true;

        } catch (DateTimeParseException dtpe) {
            System.out.println("El formato de la fecha se ingresado mal (dd/MM/yyyy)");
            return false;
        }
    }

    /**
     * Método que genera datos aleatorios con Faker para agregar pacientes al centro de salud.
     *
     * @param cantidadAlumnos Cantidad de pacientes aleatorios a agregar.
     */
    private void addPacienteAleatorio(int cantidadAlumnos) {
        Faker faker = new Faker(new Locale("es", "ES"));
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato esperado

        for (int i = 0; i < cantidadAlumnos; i++) {
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            Date fechaNacimientoUtil = faker.date().birthday(1, 100); // Obtener la fecha como java.util.Date
            LocalDate fechaNacimiento = fechaNacimientoUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Convertir a LocalDate
            String fechaNacimientoFormateada = fechaNacimiento.format(fmt); // Formatear la fecha
            Paciente.Sexo sexo = LibRandom.randomInt(0, 1) == 0 ? Paciente.Sexo.M : Paciente.Sexo.F;
            float altura = LibRandom.randomFloat(0.50f, 2.00f);
            float peso = LibRandom.randomFloat(10.00f, 150.00f);
            pacientes.add(new Paciente(nombre, apellido, fechaNacimientoFormateada, sexo, altura, peso));
            numPacientes++;
        }
    }

    /**
     * Método que calcula la menor y mayor edad entre los pacientes de una lista.
     *
     * @param pacientes La lista de pacientes de la cual se desea obtener la menor y mayor edad.
     * @return Un array de dos elementos, donde el primer elemento representa la menor edad
     * y el segundo elemento representa la mayor edad entre los pacientes.
     */
    @Override
    public int[] mayorMenor(List<Paciente> pacientes) {
        int edadMayor = Integer.MIN_VALUE;
        int edadMenor = Integer.MAX_VALUE;

        for (Paciente paciente : pacientes) {
            int edad = paciente.getEdad();
            if (edad < edadMenor) {
                edadMenor = edad;
            }
            if (edad > edadMayor) {
                edadMayor = edad;
            }
        }
        int[] edadMenorMayor = {edadMenor, edadMayor};
        return edadMenorMayor;
    }

    /**
     * Método que cuenta la cantidad de pacientes por sexo en una lista.
     *
     * @param pacientes La lista de pacientes de la cual se desea contar la cantidad por sexo.
     * @return Un array de dos elementos, donde el primer elemento representa la cantidad de hombres
     * y el segundo elemento representa la cantidad de mujeres en la lista de pacientes.
     */
    @Override
    public int[] pacientesPorSexo(List<Paciente> pacientes) {
        int cantidadHombres = 0;
        int cantidadMujeres = 0;
        for (Paciente paciente : pacientes) {
            if (paciente.getSexo() == Paciente.Sexo.M) {
                cantidadHombres++;
            } else {
                cantidadMujeres++;
            }
        }
        int[] hombresMujeres = {cantidadHombres, cantidadMujeres};
        return hombresMujeres;
    }

    /**
     * Método que calcula el índice de masa corporal (IMC) de un paciente.
     *
     * @param paciente El paciente del cual se calculará el IMC.
     * @return El IMC del paciente.
     */
    @Override
    public double calcularIMC(Paciente paciente) {
        float peso = paciente.getPeso();
        float altura = paciente.getAltura();
        return peso / (altura * altura);
    }

    /**
     * Método que devuelve un mensaje basado en el índice de masa corporal (IMC) proporcionado.
     *
     * @param imc El índice de masa corporal (IMC) del paciente.
     * @return El mensaje correspondiente al IMC del paciente.
     */
    public String tablaIMC(double imc) {
        StringBuilder sb = new StringBuilder();
        if (imc < 18.5) {
            sb.append("Peso insuficiente");
        } else if (imc >= 18.5 && imc <= 24.9) {
            sb.append("Peso normal");
        } else if (imc >= 25 && imc <= 26.9) {
            sb.append("Sobrepeso grado I");
        } else if (imc >= 27 && imc <= 29.9) {
            sb.append("Sobrepeso grado II");
        } else if (imc > 29.9) {
            sb.append("Sobrepeso grado III");
        } else {
            sb.append("IMC fuera de rango");
        }
        return sb.toString();
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public int getNumPacientes() {
        return numPacientes;
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
