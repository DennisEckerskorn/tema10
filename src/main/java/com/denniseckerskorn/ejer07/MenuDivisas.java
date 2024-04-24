package com.denniseckerskorn.ejer07;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;
import com.denniseckerskorn.lib.LibRandom;

public class MenuDivisas {
    private MapDivisas divisas;
    private Moneda[] currencies;
    private final ConsoleMenu menu;

    public MenuDivisas() {
        divisas = new MapDivisas();
        currencies = Moneda.values();

        divisasIniciales();

        menu = new ConsoleMenu("Menú Divisias");
        menu.addOpcion("Actualizar Divisa de una Moneda...");
        menu.addOpcion("Consultar cotizaciones de cada moneda...");
        menu.addOpcion("Convertir a Euros...");
        menu.addOpcion("Salir");

        int opcion;

        do{
            opcion = menu.mostrarMenuInt();
            switch(opcion) {
                case 1:
                  addDivisaMoneda();
                    break;
                case 2:
                    consultarDivisas();
                    break;
                case 3:
                    convertirDivisaAEuros();
                    break;
                default:
                    System.out.println("Valor introducido no es válido, vuelve a ingresar un valor válido.");
                    break;
            }
        }while(opcion != 4);
    }

    private void divisasIniciales() {
        divisas.addMoneda(Moneda.USD, 1.0935);
        divisas.addMoneda(Moneda.GBP, 0.8654);
        divisas.addMoneda(Moneda.INR, 85.5445);
        divisas.addMoneda(Moneda.AUD, 1.5674);
        divisas.addMoneda(Moneda.CAD, 1.4471);
        divisas.addMoneda(Moneda.ARS, 110.6444);
        divisas.addMoneda(Moneda.BOB, 8.5444);
        divisas.addMoneda(Moneda.CLP, 888.5444);
        divisas.addMoneda(Moneda.VEZ, 4755.5444);
        divisas.addMoneda(Moneda.CRC, 665.5444);
        divisas.addMoneda(Moneda.CUP, 26.5444);
        divisas.addMoneda(Moneda.DOP, 58.5444);
        divisas.addMoneda(Moneda.MXN, 21.1444);
    }

    private void addDivisaMoneda() {
        for(int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + ". " + currencies[i]);
        }

        int index = LibIO.requestInt("Selecciona una moneda: ") - 1;

        Moneda selectedMoneda = currencies[index];

        double exchangeRate = LibIO.requestDouble("Introduce la cotización:");

        divisas.addMoneda(selectedMoneda, exchangeRate);
    }

    private void consultarDivisas() {
        for(int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + ". " + currencies[i] + " - " + divisas.getDivisa(currencies[i]));
        }
    }

    private void convertirDivisaAEuros() {
        for(int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + ". " + currencies[i]);
        }

        int index = LibIO.requestInt("Selecciona una moneda: ") - 1;
        Moneda selectedMoneda = currencies[index];

        double amount = LibIO.requestDouble("Introduce la cantidad a convertir a euros:");
        double exchangeRate = divisas.getDivisa(selectedMoneda);
        double euroAmount = amount * exchangeRate;

        System.out.printf("El equivalente en euros es: %.2f Euros \n",euroAmount);
    }

}
