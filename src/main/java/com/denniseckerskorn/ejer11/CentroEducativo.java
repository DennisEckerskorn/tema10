package com.denniseckerskorn.ejer11;

import java.util.ArrayList;
import java.util.List;

public class CentroEducativo {
    private final List<Grupo> grupos;

    public CentroEducativo() {
        grupos = new ArrayList<>();
    }

    /**
     * Permite añadir un grupo a la lista de grupos.
     * @param grupo
     * @return {@true} si se ha añadido correctamente, de lo contrario, {@false}
     */
    public boolean addGrupo(Grupo grupo) {
        return grupos.add(grupo);
    }

    /**
     * Permite obtener la lista completa de grupos.
     * @return lista de grupos.
     */
    public List<Grupo> getGrupos() {
        return grupos;
    }

    /**
     * Permite obtener el nombre de cada grupo, sirve para mostrar los nombres de grupo.
     * @param index
     * @return
     */
    public String getNombreGrupo(int index) {
        if(index >= 0 && index < grupos.size()) {
            Grupo grupo = grupos.get(index);
            return grupo.getNombre();
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CentroEducativo that = (CentroEducativo) o;
        return grupos.equals(that.grupos);
    }

    @Override
    public int hashCode() {
        return grupos.hashCode();
    }

    @Override
    public String toString() {
        return "CentroEducativo{" +
                "grupos=" + grupos +
                '}' + "\n";
    }
}
