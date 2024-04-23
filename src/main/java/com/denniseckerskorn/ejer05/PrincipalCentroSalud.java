package com.denniseckerskorn.ejer05;

import java.time.format.DateTimeParseException;

public class PrincipalCentroSalud {
    public PrincipalCentroSalud() {

        try{
            CentroSalud centroSalud = new CentroSalud();
            System.out.println(centroSalud);
        }catch(DateTimeParseException dtpe) {
            System.out.println("Formato errone");
        }
    }
}
