package com.campusland.entities.Actor.adapters.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campusland.utils.ConsoleUtils;

import com.campusland.entities.Actor.application.ActorService;
import com.campusland.entities.Actor.domain.Actor;

public class ActorConsoleAdapter {
    static Scanner sc = new Scanner(System.in);

    private final ActorService actorService;

    public ActorConsoleAdapter(ActorService actorService) {
        this.actorService = actorService;
    }

    public void registerActor() {
        String rta = "S";
        while (rta.equalsIgnoreCase("s")) {
            ConsoleUtils.limpiarConsola();
            int idBase = 0;
            System.out.println("*************** REGISTRO DE ACTORES ***************");
            System.out.println("[*] INGRESE EL NOMBRE DEL ACTOR: ");
            String name = sc.nextLine();

            System.out.println("[*] INGRESE EL ID DE LA NACIONALIDAD DEL ACTOR: ");
            int idNationality = Integer.parseInt(sc.nextLine());

            System.out.println("[*] INGRESE LA EDAD DEL ACTOR: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.println("[*] INGRESE EL ID DEL GENERO DEL ACTOR: ");
            int idGender = Integer.parseInt(sc.nextLine());

            Actor actor = new Actor(idBase, name, idNationality, age, idGender);
            actorService.createActor(actor);

            ConsoleUtils.limpiarConsola();
            System.out.println("[?] DESEA REGISTRAR OTRO ACTOR? [S - Si | Cualquier tecla para salir]");
            rta = sc.nextLine();
        }
    }

    public void updateActor() {
        List<Actor> actores = actorService.getAllActors();
        if (actores.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN ACTOR REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ACTUALIZACION DE ACTOR ***************");
            System.out.println("[?] INGRESE EL ID DEL ACTOR A ACTUALIZAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Actor> matchActor = actorService.findActorById(id);

            matchActor.ifPresentOrElse(a -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("*************** ACTUALIZACION DE ACTOR ***************");
                System.out.println("[*] INGRESE EL NOMBRE DEL ACTOR: ");
                String name = sc.nextLine();
    
                System.out.println("[*] INGRESE EL ID DE LA NACIONALIDAD DEL ACTOR: ");
                int idNationality = Integer.parseInt(sc.nextLine());
    
                System.out.println("[*] INGRESE LA EDAD DEL ACTOR: ");
                int age = Integer.parseInt(sc.nextLine());
    
                System.out.println("[*] INGRESE EL ID DEL GENERO DEL ACTOR: ");
                int idGender = Integer.parseInt(sc.nextLine());
    
                Actor actor = new Actor(a.getId(), name, idNationality, age, idGender);
                actorService.updateActor(actor);
            }, 
            () -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("[!] NO EXISTE UN ACTOR CON TAL ID!");
                sc.nextLine();
            });

        }
    }

    public void dropActor() {
        List<Actor> actores = actorService.getAllActors();
        if (actores.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN ACTOR REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ELIMINACION DE ACTOR ***************");
            System.out.println("[?] INGRESE EL ID DEL ACTOR A ELIMINAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Actor> matchActor = actorService.findActorById(id);
            matchActor.ifPresentOrElse(
                a -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[?] ESTAS SEGURO QUE DESEAS ELIMINAR EL ACTOR {0} ? [S - Si | Cuaquier tecla - No]", a.getId()));
                    String sel = sc.nextLine();

                    if (sel.equalsIgnoreCase("S")) {
                        ConsoleUtils.limpiarConsola();
                        System.out.println("[*] EL ACTOR HA SIDO ELIMINADO EXITOSAMENTE");
                        actorService.deleteActor(id);
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

    public void getActorByID() {
        List<Actor> actores = actorService.getAllActors();
        if (actores.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN ACTOR REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** BUSQUEDA DE ACTOR ***************");
            System.out.println("[?] INGRESE EL ID DEL ACTOR A BUSCAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Actor> matchActor = actorService.findActorById(id);
            matchActor.ifPresentOrElse(
                a -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println("*************** ACTOR ***************");
                    System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] NOMBRE: {1}\n       [*] ID NACIONALIDAD: {2}\n      [*] EDAD: {3}\n     [*] ID GENERO: {4}", a.getId(), a.getNombre(), a.getIdNacionalidad(), a.getEdad(), a.getIdGenero()));
                    sc.nextLine();
                },
                () -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[!] NO HAY NINGUN ACTOR REGISTRADO CON EL ID [{0}]", id));
                    sc.nextLine();
                });
        }
    }

    public void getActors() {
        List<Actor> actores = actorService.getAllActors();
        if (actores.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN ACTOR REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ACTORES ***************");
            actores.forEach(a -> {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] NOMBRE: {1}\n       [*] ID NACIONALIDAD: {2}\n      [*] EDAD: {3}\n     [*] ID GENERO: {4}", a.getId(), a.getNombre(), a.getIdNacionalidad(), a.getEdad(), a.getIdGenero()));
            });
            sc.nextLine();
        }
    }



}
