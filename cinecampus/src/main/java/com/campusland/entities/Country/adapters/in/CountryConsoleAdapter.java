package com.campusland.entities.Country.adapters.in;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campusland.utils.ConsoleUtils;
import com.campusland.entities.Country.application.CountryService;
import com.campusland.entities.Country.domain.Country;

public class CountryConsoleAdapter {
    static Scanner sc = new Scanner(System.in);

    private final CountryService countryService;

    

    public CountryConsoleAdapter(CountryService countryService) {
        this.countryService = countryService;
    }

    public void registerCountry() {
        String rta = "S";
        while (rta.equalsIgnoreCase("s")) {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** REGISTRO PAIS ***************");
            System.out.println("[*] INGRESE EL ID DEL PAIS: ");
            int id = Integer.parseInt(sc.nextLine());
            
            System.out.println("[*] INGRESE EL NOMBRE DE PAIS: ");
            String description = sc.nextLine();

            Country country = new Country(id, description);
            countryService.createCountry(country);

            ConsoleUtils.limpiarConsola();
            System.out.println("[?] DESEA REGISTRAR OTRO PAIS? [S - Si | Cualquier tecla para salir]");
            rta = sc.nextLine();
        }
    }

    public void updateCountry() {
        List<Country> countries = countryService.getAllCountrys();
        if (countries.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN PAIS REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ACTUALIZACION DE PAIS ***************");
            System.out.println("[?] INGRESE EL ID DEL TIPO DE PAIS A ACTUALIZAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Country> matchCountry = countryService.findCountryById(id);

            matchCountry.ifPresentOrElse(a -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("*************** ACTUALIZACION DE PAIS***************");
                System.out.println("[*] INGRESE DESCRIPCION DEL PAIS: ");
                String description = sc.nextLine();
                Country country = new Country (a.getId(), description);
                countryService.updateCountry(country);
            }, 
            () -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("[!] NO EXISTE UN PAIS CON TAL ID!");
                sc.nextLine();
            });

        }
    }

    public void dropCountry() {
        List<Country> countries = countryService.getAllCountrys();
        if (countries.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN PAIS REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ELIMINACION DE PAIS ***************");
            System.out.println("[?] INGRESE EL ID DEL PAIS A ELIMINAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Country> matchCountry = countryService.findCountryById(id);
            matchCountry.ifPresentOrElse(
                a -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[?] ESTAS SEGURO QUE DESEAS ELIMINAR EL PAIS {0} ? [S - Si | Cuaquier tecla - No]", a.getId()));
                    String sel = sc.nextLine();

                    if (sel.equalsIgnoreCase("S")) {
                        ConsoleUtils.limpiarConsola();
                        System.out.println("[*] EL PAIS HA SIDO ELIMINADO EXITOSAMENTE");
                        countryService.deleteCountry(id);
                    } else {
                        sc.nextLine();
                    }
                },
                () -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[!] NO HAY NINGUN PAIS REGISTRADO CON EL ID [{0}]", id));
                    sc.nextLine();
                });
        }
    }

    public void getCountryByID() {
        List<Country> conutries = countryService.getAllCountrys();
        if (conutries.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN PAIS REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** BUSQUEDA DE PAIS ***************");
            System.out.println("[?] INGRESE EL ID DEL PAIS A BUSCAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Country> matchCountry = countryService.findCountryById(id);
            matchCountry.ifPresentOrElse(
                a -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println("***************PAIS***************");
                    System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] DESCRIPTION: {1}\n       ", a.getId(), a.getDescription()));
                    sc.nextLine();
                },
                () -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[!] NO HAY NINGUN TIPO DE PAIS REGISTRADO CON EL ID [{0}]", id));
                    sc.nextLine();
                });
        }
    }

    public void getAllCountrys() {
        List<Country> countries = countryService.getAllCountrys();
        if (countries.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN TIPO DE PAIS REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** PAISES ***************");
            countries.forEach(a -> {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] DESCRIPCION: {1}\n ", a.getId(), a.getDescription()));
            });
            sc.nextLine();
        }
    }
}
