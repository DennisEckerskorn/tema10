package com.denniseckerskorn.ejer10;

import net.datafaker.Faker;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * Clase que se encarga de gestionar la empresa con sus empleados e hijos.
 */
public class Empresa {
    private static final int DEFAULT_EMP_ALEA = 40;
    private final List<Empleado> empleados;
    private final Random rnd;

    /**
     * Constructor que inicializa el ArrayList, Random y genera varios empleados aleatorios usando Faker.
     * La cantidad de empleados se puede pasar como parámetro.
     */
    public Empresa() {
        this.empleados = new ArrayList<>();
        this.rnd = new Random();
        generarEmpleadosAleatorios(DEFAULT_EMP_ALEA);
    }

    /**
     * Método que permite generar empleados aleatorios con valores de los atributos totalmente aleatorios.
     * Una vez se hayan generado los datos aleatorios, crea un objeto de tipo empleado y lo añade al ArrayList.
     * Lo mismo pasa con cada hijo de cada empleado si la cantidad de hijos e mayor que 0.
     *
     * @param cantidadEmpleados int, cantidad de empleados aleatorios.
     */
    private void generarEmpleadosAleatorios(int cantidadEmpleados) {
        Faker faker = new Faker(new Locale("es", "ES"));
        for (int i = 0; i < cantidadEmpleados; i++) {
            String dni = String.format("%08d", rnd.nextInt());
            String nombre = faker.name().firstName();
            String apellidos = faker.name().lastName();
            LocalDate fechaNacimiento = faker.date().birthdayLocalDate();
            float sueldo = rnd.nextFloat(4001);
            int cantidadHijos = rnd.nextInt(11);
            Empleado empleadoGenerado = addNuevoEmpleado(dni, nombre, apellidos, fechaNacimiento, sueldo, cantidadHijos);
            if (empleadoGenerado.getCantidadHijos() > 0) {
                for (int j = 0; j < cantidadHijos; j++) {
                    String nombreHijo = faker.name().firstName();
                    LocalDate fechaNacimientoHijo = faker.date().birthdayLocalDate(0, 30);
                    empleadoGenerado.addHijo(nombreHijo, fechaNacimientoHijo);
                }
            }
        }
    }

    /**
     * Método que permite recibir varios parámetros de un empleado y si el List de empleados no es null, los añade.
     *
     * @param dni             String, DNI
     * @param nombre          String, nombre
     * @param apellidos       String, apellido
     * @param fechaNacimiento LocalDate, fecha de nacimiento
     * @param sueldo          float, sueldo
     * @param cantidadHijos   int, cantidad de hijos
     * @return Empleado creado, de lo contrario, null.
     */
    public Empleado addNuevoEmpleado(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, float sueldo, int cantidadHijos) {
        if (empleados != null) {
            Empleado nuevoEmpleado = new Empleado(dni, nombre, apellidos, fechaNacimiento, sueldo, cantidadHijos);
            empleados.add(nuevoEmpleado);
            return nuevoEmpleado;
        }
        return null;
    }

    /**
     * Método que permite buscar dentro del ArrayList de empleado, el empleado con el DNI específicado.
     *
     * @param dni String, DNI
     * @return Empleado encontrado con el DNI proporcionado.
     */
    public Empleado obtenerEmpleadoPorDNI(String dni) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni().equals(dni)) {
                return empleados.get(i);
            }
        }
        return null;
    }

    /**
     * Método que sirve para borrar un empleado del ArrayList empleados.
     * Recibe al empleado como parámetro y pone el ArrayList de hijos a null.
     * Luego elimina el empleado del arrayList.
     *
     * @param empleado Empleado, a eliminar.
     * @return {@true} si el empleado se eliminado con éxito, de lo contrario, {@false}
     */
    public boolean borrarEmpleado(Empleado empleado) {
        empleado.removeHijosList();
        return empleados.remove(empleado);
    }

    /**
     * Método que obtiene al empleado por su nombre.
     *
     * @param nombre String
     * @return Empleado con el nombre proporcionado.
     */
    public Empleado obtenerEmpleadoPorNombre(String nombre) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNombre().equals(nombre)) {
                return empleados.get(i);
            }
        }
        return null;
    }

    /**
     * Método que obtiene los empleados que estan dentro de un rango de edad.
     *
     * @param edadMin int, edad miníma.
     * @param edadMax int, edad máxima.
     * @return Lista de empleados con la edad dentro del rango proporcionado.
     */
    public List<Empleado> obtenerEmpleadosPorRangoEdad(int edadMin, int edadMax) {
        List<Empleado> rangosEdad = new ArrayList<>();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getEdadEmpleado() >= edadMin && empleados.get(i).getEdadEmpleado() <= edadMax) {
                rangosEdad.add(empleados.get(i));
            }
        }
        return rangosEdad;
    }

    /**
     * Método que obtiene a los empleados dentro del rango de sueldo proporcionado.
     *
     * @param minSueldo float, sueldo mínimo,
     * @param maxSueldo float, sueldo máximo.
     * @return Lista de empleados dentro del rango del sueldo proporcionado.
     */
    public List<Empleado> obtenerEmpleadosPorSueldo(float minSueldo, float maxSueldo) {
        List<Empleado> rangoSueldos = new ArrayList<>();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getSueldo() >= minSueldo && empleados.get(i).getSueldo() >= maxSueldo) {
                rangoSueldos.add(empleados.get(i));
            }
        }
        return rangoSueldos;
    }

    /**
     * Método que obtiene todos los hijos menores de edad de cada empleado.
     * Primero recorre el array de empleados y luego el array de hijos del empleado de i.
     *
     * @return List de hijos menores de edad de cada empleado.
     */
    public List<Empleado> obtenerEmpleadosHijosMenoresEdad() {
        List<Empleado> hijosMenoresEdad = new ArrayList<>();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getHijos() != null) {
                List<Hijo> hijos = empleados.get(i).getHijos();
                for (int j = 0; j < hijos.size(); j++) {
                    if (hijos.get(j).getEdadHijo() < 18) {
                        hijosMenoresEdad.add(empleados.get(i));
                        break;
                    }
                }
            }
        }
        return hijosMenoresEdad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empresa empresa = (Empresa) o;
        return empleados.equals(empresa.empleados) && rnd.equals(empresa.rnd);
    }

    @Override
    public int hashCode() {
        int result = empleados.hashCode();
        result = 31 * result + rnd.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "empleados=" + empleados +
                '}' + "\n";
    }
}
