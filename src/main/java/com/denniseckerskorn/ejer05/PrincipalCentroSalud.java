package com.denniseckerskorn.ejer05;

import java.util.List;

public class PrincipalCentroSalud {
    public PrincipalCentroSalud() {
        CentroSalud centroSalud = new CentroSalud();
        centroSalud.addNuevoPaciente("Pepe", "Gonzales", "12/02/1980", Paciente.Sexo.F, 1.63f, 57f);
        centroSalud.addNuevoPaciente("Carlos", "Bover", "07/03/1990", Paciente.Sexo.F, 1.74f, 60.5f);
        centroSalud.addNuevoPaciente("Pedro", "Cabrera", "20/03/1967", Paciente.Sexo.F, 1.62f, 50.8f);
        centroSalud.addNuevoPaciente("Andres", "Bolufer", "20/04/1972", Paciente.Sexo.M, 1.78f, 72.5f);
        centroSalud.addNuevoPaciente("Daniel", "Garcia", "29/02/1960", Paciente.Sexo.M, 1.8f, 85.2f);
        System.out.println(centroSalud);

        List<Paciente> listaPacientes = centroSalud.getPacientes();

        int[] edadMenorMayor = centroSalud.mayorMenor(listaPacientes);
        System.out.printf("PACIENTE MAYOR DE EDAD: %d SEXO: \n", edadMenorMayor[0]); //TODO: FALTA OBTNER EL SEXO???
        System.out.printf("PACIENTE MENOR DE EDAD: %d SEXO: \n", edadMenorMayor[1]); //TODO: FALTA OBTENER EL SEXO???

        int[] cantidadHombreMujeres = centroSalud.pacientesPorSexo(listaPacientes);
        System.out.println("Cantidad de pacientes por sexos: ");
        System.out.printf("Hombres: %d, Mujeres: %d \n", cantidadHombreMujeres[0], cantidadHombreMujeres[1]);

        for(int i = 0; i < listaPacientes.size(); i++) {
            double imc = centroSalud.calcularIMC(listaPacientes.get(i));
            System.out.println("Paciente número " + listaPacientes.get(i).getId() + ": " + centroSalud.tablaIMC(imc));
        }
    }
}
