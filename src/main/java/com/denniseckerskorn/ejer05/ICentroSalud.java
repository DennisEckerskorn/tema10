package com.denniseckerskorn.ejer05;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ICentroSalud {
    int[] mayorMenor(ArrayList<Paciente> pacientes);
    int[] pacientesPorSexo(ArrayList<Paciente> pacientes);
    double calcularIMC(Paciente paciente);


}
