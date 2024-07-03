package com.campusland.entities.Gender.adapters.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campusland.utils.ConsoleUtils;
import com.campusland.entities.Gender.domain.Gender;
import com.campusland.entities.Gender.application.GenderService;
import com.campusland.entities.Gender.domain.Gender;

public class GenderConsoleAdapter {
    static Scanner sc = new Scanner(System.in);

    private final GenderService genderService;

    public GenderConsoleAdapter(GenderService genderService) {
        this.genderService = genderService;
    }

        public void registerGender() {
        String rta = "S";
        while (rta.equalsIgnoreCase("s")) {
            ConsoleUtils.limpiarConsola();
            int idBase = 0;
            System.out.println("*************** REGISTRO DE GENEROS ***************");
            System.out.println("[*] INGRESE EL NOMBRE GENERO: ");
            String descripcion = sc.nextLine();

            Gender gender = new Gender(idBase, descripcion);
            genderService.createGender(gender);

            ConsoleUtils.limpiarConsola();
            System.out.println("[?] DESEA REGISTRAR OTRO GENERO? [S - Si | Cualquier tecla para salir]");
            rta = sc.nextLine();
        }
    }

    public void updateGender() {
        List<Gender> genders = genderService.getAllGenders();
        if (genders.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN GENERO REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ACTUALIZACION DE GENERO ***************");
            System.out.println("[?] INGRESE EL ID DEL GENERO A ACTUALIZAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Gender> matchGender = genderService.findGenderById(id);

            matchGender.ifPresentOrElse(g -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("*************** ACTUALIZACION DE GENERO ***************");
                System.out.println("[*] INGRESE EL NOMBRE GENERO: ");
                String descripcion = sc.nextLine();
    
                Gender gender = new Gender(g.getId(), descripcion);
                genderService.updateGender(gender);
            }, 
            () -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("[!] NO EXISTE UN GENERO CON TAL ID!");
                sc.nextLine();
            });

        }
    }

    public void dropGender() {
        List<Gender> genders = genderService.getAllGenders();
        if (genders.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN GENERO REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ELIMINACION DE GENERO ***************");
            System.out.println("[?] INGRESE EL ID DEL GENERO A ELIMINAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Gender> matchGender = genderService.findGenderById(id);
            matchGender.ifPresentOrElse(
                g -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[?] ESTAS SEGURO QUE DESEAS ELIMINAR EL GENERO {0} ? [S - Si | Cuaquier tecla - No]", g.getId()));
                    String sel = sc.nextLine();

                    if (sel.equalsIgnoreCase("S")) {
                        ConsoleUtils.limpiarConsola();
                        System.out.println("[*] EL GENERO HA SIDO ELIMINADO EXITOSAMENTE");
                        genderService.deleteGender(id);
                    } else {
                        sc.nextLine();
                    }
                },
                () -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[!] NO HAY NINGUN Gender REGISTRADO CON EL ID [{0}]", id));
                    sc.nextLine();
                });
        }
    }

    public void getGenderByID() {
        List<Gender> genders = genderService.getAllGenders();
        if (genders.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN GENERO REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** BUSQUEDA DE GENERO ***************");
            System.out.println("[?] INGRESE EL ID DEL Gender A BUSCAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Gender> matchGender = genderService.findGenderById(id);
            matchGender.ifPresentOrElse(
                g -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println("*************** GENERO ***************");
                    System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] DESCRIPCION: {1}", g.getId(), g.getDescripcion()));
                    sc.nextLine();
                },
                () -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[!] NO HAY NINGUN GENERO REGISTRADO CON EL ID [{0}]", id));
                    sc.nextLine();
                });
        }
    }

    public void getGenders() {
        List<Gender> genders = genderService.getAllGenders();
        if (genders.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN GENERO REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** GENEROS ***************");
            genders.forEach(g -> {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] DESCRIPCION: {1}", g.getId(), g.getDescripcion()));
            });
            sc.nextLine();
        }
    }
}
