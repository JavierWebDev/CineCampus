package com.campusland;

import java.util.Scanner;

import com.campusland.entities.Actor.adapters.in.ActorConsoleAdapter;
import com.campusland.entities.Actor.application.ActorService;
import com.campusland.utils.ConsoleUtils;

public class Main {

    static ActorService actorService;

    public static void Menu() {
        Scanner sc = new Scanner(System.in);
        boolean isActiveApp = true;
        System.out.println("Bienvenido a CineCampus");
        System.out.println("que desea Hacer:");
        System.out.println("1) Gestion de Actores:");
        System.out.println("2) Gestion de pelicula:");
        System.out.println("3) Gestion de formato:");
        System.out.println("4) Asignacion |de Formatos:");
        System.out.println("5) Gestion de pelicula:");
        System.out.println("6) Asignacion de Actores a Peliculas:");
        System.out.println("7) Gestion de Generos:");
        System.out.println("8) Gestion de Paises:");
        System.out.println("9) Gestion de Tipos de Actores:");
        System.out.println("10) Consultar de Informacion detallada de una Pelicula:");
        System.out.println("11) Lista de Actores por Pelicula:");
        System.out.println("12) Salida:");
        while (isActiveApp) {
            ConsoleUtils.limpiarConsola();
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    GestActores();
                    break;
                case 2:
                    GestPeliculas();
                    break;
                case 3:
                    GestFormato();
                    break;
                case 4:
                    AsgActoresPel();
                    break;
                case 5:
                    GestPeliculas();
                    break;
                case 6:
                    AsgActoresPel();
                    break;
                case 7:
                    GestGenero();
                    break;
                case 8:
                    GestPais();
                    break;
                case 9:
                    GestTipoActor();
                    break;
                case 10:
                    ConsInfoPelicula();
                    break;

                case 11:
                    ListActorPel();
                    break;
                case 12:
                    isActiveApp = false;
                    break;
                default:
                    System.out.println("Numero no identificado");
                    break;
            }
        }
        sc.close();
    }

    public static void GestActores() {
        ConsoleUtils.limpiarConsola();
        Scanner sc = new Scanner(System.in);
        System.out.println("Seccion Gestion de Actores");
        System.out.println("que desea Hacer:");
        System.out.println("1) Agregar Actor:");
        System.out.println("2) editar Actor:");
        System.out.println("3) eliminar Actor:");
        System.out.println("4) listar Actores:");
        int act = sc.nextInt();
        switch (act) {
            case 1:
                ActorConsoleAdapter actorConsoleAdapter = new ActorConsoleAdapter(actorService);
                actorConsoleAdapter.registerActor();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:

                break;
        }
        sc.close();
    }

    public static void GestPeliculas() {
        ConsoleUtils.limpiarConsola();
        System.out.println("Seccion Gestion de Peliculas");
        System.out.println("que desea Hacer:");
        System.out.println("1) Agregar Pelicula:");
        System.out.println("2) editar Pelicula:");
        System.out.println("3) eliminar Pelicula:");
        System.out.println("4) listar Peliculas:");
    }

    public static void GestFormato() {
        ConsoleUtils.limpiarConsola();
        System.out.println("Seccion Gestion de Peliculas");
        System.out.println("que desea Hacer:");
        System.out.println("1) Agregar Formato:");
        System.out.println("2) editar Formato:");
        System.out.println("3) eliminar Formato:");
        System.out.println("4) listar Formato:");
    }

    public static void GestPais() {
        ConsoleUtils.limpiarConsola();
        System.out.println("Seccion Gestion de Peliculas");
        System.out.println("que desea Hacer:");
        System.out.println("1) Agregar Pais:");
        System.out.println("2) editar Pais:");
        System.out.println("3) eliminar Pais:");
        System.out.println("4) listar Paises:");
    }

    public static void AsgActoresPel() {
        ConsoleUtils.limpiarConsola();
        System.out.println("Seccion Asignacion de Actores a Peliculas");
    }

    public static void GestGenero() {
        ConsoleUtils.limpiarConsola();
        System.out.println("Seccion Gestion de Peliculas");
        System.out.println("que desea Hacer:");
        System.out.println("1) Agregar Genero:");
        System.out.println("2) editar Genero:");
        System.out.println("3) eliminar Genero:");
        System.out.println("4) listar Genero:");
    }

    public static void GestTipoActor() {
        ConsoleUtils.limpiarConsola();
        System.out.println("Seccion Gestion de Peliculas");
        System.out.println("que desea Hacer:");
        System.out.println("1) Agregar Tipo actor:");
        System.out.println("2) editar Tipo actor:");
        System.out.println("3) eliminar Tipo actor:");
        System.out.println("4) listar Tipo de actores:");
    }

    public static void ConsInfoPelicula() {
        ConsoleUtils.limpiarConsola();
        System.out.println("Seccion Consulta de informacion detallada de una Pelicula");
    }

    public static void ListActorPel() {
        ConsoleUtils.limpiarConsola();
        System.out.println("Seccion Listar Actores por Pelicula");
    }

    public static void main(String[] args) {
        Menu();
    }
}
