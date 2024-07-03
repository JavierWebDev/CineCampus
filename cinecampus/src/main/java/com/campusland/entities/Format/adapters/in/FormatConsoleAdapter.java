package com.campusland.entities.Format.adapters.in;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campusland.utils.ConsoleUtils;
import com.campusland.entities.Format.application.FormatService;
import com.campusland.entities.Format.domain.Format;
public class FormatConsoleAdapter {
static Scanner sc = new Scanner(System.in);

    private final FormatService FormatService;

    

    public FormatConsoleAdapter(FormatService PAISService) {
        this.FormatService = PAISService;
    }

    public void registerFormat() {
        String rta = "S";
        while (rta.equalsIgnoreCase("s")) {
            ConsoleUtils.limpiarConsola();
            int idBase = 0;
            System.out.println("*************** REGISTRO PAIS ***************");
            System.out.println("[*] INGRESE DESCRIPCION DE PAIS: ");
            String description = sc.nextLine();

            System.out.println("[*] INGRESE EL ID DEL PAIS: ");
            idBase = Integer.parseInt(sc.nextLine());

            Format Format = new Format(idBase, description);
            FormatService.createFormat(Format);

            ConsoleUtils.limpiarConsola();
            System.out.println("[?] DESEA REGISTRAR OTRO PAIS? [S - Si | Cualquier tecla para salir]");
            rta = sc.nextLine();
        }
    }

    public void updateFormat() {
        List<Format> countries = FormatService.getAllFormats();
        if (countries.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN PAIS REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ACTUALIZACION DE PAIS ***************");
            System.out.println("[?] INGRESE EL ID DEL TIPO DE PAIS A ACTUALIZAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Format> matchPAIS = FormatService.findFormatById(id);

            matchPAIS.ifPresentOrElse(a -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("*************** ACTUALIZACION DE PAIS***************");
                System.out.println("[*] INGRESE DESCRIPCION DEL PAIS: ");
                String description = sc.nextLine();
                Format Format = new Format (a.getId(), description);
                FormatService.updateFormat(Format);
            }, 
            () -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("[!] NO EXISTE UN PAIS CON TAL ID!");
                sc.nextLine();
            });

        }
    }

    public void dropFormat() {
        List<Format> PAISes = FormatService.getAllFormats();
        if (PAISes.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN PAIS REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ELIMINACION DE PAIS ***************");
            System.out.println("[?] INGRESE EL ID DEL PAIS A ELIMINAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Format> matchPAIS = FormatService.findFormatById(id);
            matchPAIS.ifPresentOrElse(
                a -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[?] ESTAS SEGURO QUE DESEAS ELIMINAR EL PAIS {0} ? [S - Si | Cuaquier tecla - No]", a.getId()));
                    String sel = sc.nextLine();

                    if (sel.equalsIgnoreCase("S")) {
                        ConsoleUtils.limpiarConsola();
                        System.out.println("[*] EL PAIS HA SIDO ELIMINADO EXITOSAMENTE");
                        FormatService.deleteFormat(id);
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

    public void getFormatByID() {
        List<Format> PAISes = FormatService.getAllFormats();
        if (PAISes.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN PAIS REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** BUSQUEDA DE PAIS ***************");
            System.out.println("[?] INGRESE EL ID DEL PAIS A BUSCAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Format> matchPAIS = FormatService.findFormatById(id);
            matchPAIS.ifPresentOrElse(
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

    public void getPAISsTypes() {
        List<Format> Formats = FormatService.getAllFormats();
        if (Formats.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN TIPO DE PAIS REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** PAISES ***************");
            Formats.forEach(a -> {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] DESCRIPCION: {1}\n ", a.getId(), a.getDescription()));
            });
            sc.nextLine();
        }
    }
}

