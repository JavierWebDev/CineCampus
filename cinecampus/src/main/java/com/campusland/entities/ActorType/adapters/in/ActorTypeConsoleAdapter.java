package com.campusland.entities.ActorType.adapters.in;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campusland.utils.ConsoleUtils;

import com.campusland.entities.ActorType.application.ActorTypeService;
import com.campusland.entities.ActorType.domain.ActorType;

public class ActorTypeConsoleAdapter {
static Scanner sc = new Scanner(System.in);

    private final ActorTypeService actorTypeService;

    

    public ActorTypeConsoleAdapter(ActorTypeService actorService) {
        this.actorTypeService = actorService;
    }

    public void registerActorType() {
        String rta = "S";
        while (rta.equalsIgnoreCase("s")) {
            ConsoleUtils.limpiarConsola();
            int idBase = 0;
            System.out.println("*************** REGISTRO TIPO DE ACTOR ***************");
            System.out.println("[*] INGRESE DESCRIPCION DE TIPO DE ACTOR: ");
            String description = sc.nextLine();

            System.out.println("[*] INGRESE EL ID DEL TIPO DE ACTOR: ");
            idBase = Integer.parseInt(sc.nextLine());

            ActorType actorType = new ActorType(idBase, description);
            actorTypeService.createActorType(actorType);

            ConsoleUtils.limpiarConsola();
            System.out.println("[?] DESEA REGISTRAR OTRO TIPO DE ACTOR? [S - Si | Cualquier tecla para salir]");
            rta = sc.nextLine();
        }
    }

    public void updateActorType() {
        List<ActorType> actores = actorTypeService.getAllActorTypes();
        if (actores.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN ACTOR REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ACTUALIZACION DE ACTOR ***************");
            System.out.println("[?] INGRESE EL ID DEL TIPO DE ACTOR A ACTUALIZAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<ActorType> matchActor = actorTypeService.findActorById(id);

            matchActor.ifPresentOrElse(a -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("*************** ACTUALIZACION DE TIPO DE ACTOR ***************");
                System.out.println("[*] INGRESE DESCRIPCION DEL TIPO DE ACTOR: ");
                String description = sc.nextLine();
                ActorType actorType = new ActorType (a.getId(), description);
                actorTypeService.updateActorType(actorType);
            }, 
            () -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("[!] NO EXISTE UN TIPO DE ACTOR CON TAL ID!");
                sc.nextLine();
            });

        }
    }

    public void dropActorType() {
        List<ActorType> actores = actorTypeService.getAllActorTypes();
        if (actores.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN ACTOR REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ELIMINACION DE ACTOR ***************");
            System.out.println("[?] INGRESE EL ID DEL ACTOR A ELIMINAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<ActorType> matchActor = actorTypeService.findActorById(id);
            matchActor.ifPresentOrElse(
                a -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[?] ESTAS SEGURO QUE DESEAS ELIMINAR EL ACTOR {0} ? [S - Si | Cuaquier tecla - No]", a.getId()));
                    String sel = sc.nextLine();

                    if (sel.equalsIgnoreCase("S")) {
                        ConsoleUtils.limpiarConsola();
                        System.out.println("[*] EL ACTOR HA SIDO ELIMINADO EXITOSAMENTE");
                        actorTypeService.deleteActorType(id);
                    } else {
                        sc.nextLine();
                    }
                },
                () -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[!] NO HAY NINGUN ACTOR REGISTRADO CON EL ID [{0}]", id));
                    sc.nextLine();
                });
        }
    }

    public void getActorTypeByID() {
        List<ActorType> actores = actorTypeService.getAllActorTypes();
        if (actores.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN ACTOR REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** BUSQUEDA DE ACTOR ***************");
            System.out.println("[?] INGRESE EL ID DEL ACTOR A BUSCAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<ActorType> matchActor = actorTypeService.findActorById(id);
            matchActor.ifPresentOrElse(
                a -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println("*************** ACTOR ***************");
                    System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] DESCRIPTION: {1}\n       ", a.getId(), a.getDescription()));
                    sc.nextLine();
                },
                () -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[!] NO HAY NINGUN TIPO DE ACTOR REGISTRADO CON EL ID [{0}]", id));
                    sc.nextLine();
                });
        }
    }

    public void getActorsTypes() {
        List<ActorType> actorTypes = actorTypeService.getAllActorTypes();
        if (actorTypes.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN TIPO DE ACTOR REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ACTORES ***************");
            actorTypes.forEach(a -> {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] DESCRIPCION: {1}\n ", a.getId(), a.getDescription()));
            });
            sc.nextLine();
        }
    }
}
