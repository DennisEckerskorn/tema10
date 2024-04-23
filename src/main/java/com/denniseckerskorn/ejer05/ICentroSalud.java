package com.denniseckerskorn.ejer05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface ICentroSalud {
    int[] mayorMenor(List<Paciente> pacientes);
    int[] pacientesPorSexo(List<Paciente> pacientes);
    double calcularIMC(Paciente paciente);


}
