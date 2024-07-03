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

    private final FormatService formatService;

    public FormatConsoleAdapter(FormatService formatService) {
        this.formatService = formatService;
    }

    public void registerFormat() {
        String rta = "S";
        while (rta.equalsIgnoreCase("s")) {
            ConsoleUtils.limpiarConsola();
            int idBase = 0;
            System.out.println("*************** REGISTRO FORMATO ***************");
            System.out.println("[*] INGRESE EL ID DEL FORMATO: ");
            idBase = Integer.parseInt(sc.nextLine());

            System.out.println("[*] INGRESE DESCRIPCION DE FORMATO: ");
            String description = sc.nextLine();

            Format Format = new Format(idBase, description);
            formatService.createFormat(Format);

            ConsoleUtils.limpiarConsola();
            System.out.println("[?] DESEA REGISTRAR OTRO FORMATO? [S - Si | Cualquier tecla para salir]");
            rta = sc.nextLine();
        }
    }

    public void updateFormat() {
        List<Format> countries = formatService.getAllFormats();
        if (countries.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN FORMATO REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ACTUALIZACION DE FORMATO ***************");
            System.out.println("[?] INGRESE EL ID DEL TIPO DE FORMATO A ACTUALIZAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Format> matchFORMATO = formatService.findFormatById(id);

            matchFORMATO.ifPresentOrElse(f -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("*************** ACTUALIZACION DE FORMATO***************");
                System.out.println("[*] INGRESE DESCRIPCION DEL FORMATO: ");
                String description = sc.nextLine();
                Format format = new Format (f.getId(), description);
                formatService.updateFormat(format);
            }, 
            () -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("[!] NO EXISTE UN FORMATO CON TAL ID!");
                sc.nextLine();
            });

        }
    }

    public void dropFormat() {
        List<Format> FORMATOes = formatService.getAllFormats();
        if (FORMATOes.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN FORMATO REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ELIMINACION DE FORMATO ***************");
            System.out.println("[?] INGRESE EL ID DEL FORMATO A ELIMINAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Format> matchFORMATO = formatService.findFormatById(id);
            matchFORMATO.ifPresentOrElse(
                f -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[?] ESTAS SEGURO QUE DESEAS ELIMINAR EL FORMATO {0} ? [S - Si | Cuaquier tecla - No]", f.getId()));
                    String sel = sc.nextLine();

                    if (sel.equalsIgnoreCase("S")) {
                        ConsoleUtils.limpiarConsola();
                        System.out.println("[*] EL FORMATO HA SIDO ELIMINADO EXITOSAMENTE");
                        formatService.deleteFormat(id);
                    } else {
                        sc.nextLine();
                    }
                },
                () -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[!] NO HAY NINGUN FORMATO REGISTRADO CON EL ID [{0}]", id));
                    sc.nextLine();
                });
        }
    }

    public void getFormatByID() {
        List<Format> FORMATOes = formatService.getAllFormats();
        if (FORMATOes.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN FORMATO REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** BUSQUEDA DE FORMATO ***************");
            System.out.println("[?] INGRESE EL ID DEL FORMATO A BUSCAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Format> matchFORMATO = formatService.findFormatById(id);
            matchFORMATO.ifPresentOrElse(
                f -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println("***************FORMATO***************");
                    System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] DESCRIPTION: {1}\n       ", f.getId(), f.getDescription()));
                    sc.nextLine();
                },
                () -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[!] NO HAY NINGUN TIPO DE FORMATO REGISTRADO CON EL ID [{0}]", id));
                    sc.nextLine();
                });
        }
    }

    public void getAllFormats() {
        List<Format> formats = formatService.getAllFormats();
        if (formats.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN TIPO DE FORMATO REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** FORMATOES ***************");
            formats.forEach(f -> {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] DESCRIPCION: {1}\n ", f.getId(), f.getDescription()));
            });
            sc.nextLine();
        }
    }
}

