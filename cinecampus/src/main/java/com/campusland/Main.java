package com.campusland;

import java.util.Scanner;

import com.campusland.entities.Actor.adapters.in.ActorConsoleAdapter;
import com.campusland.entities.Actor.adapters.out.ActorMySQLRepository;
import com.campusland.entities.Actor.application.ActorService;
import com.campusland.entities.ActorType.adapters.in.ActorTypeConsoleAdapter;
import com.campusland.entities.ActorType.adapters.out.ActorTypeMySQLRepository;
import com.campusland.entities.ActorType.application.ActorTypeService;
import com.campusland.entities.Gender.adapters.in.GenderConsoleAdapter;
import com.campusland.entities.Gender.adapters.out.GenderMySQLRepository;
import com.campusland.entities.Gender.application.GenderService;
import com.campusland.utils.ConsoleUtils;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static String url = "jdbc:mysql://localhost:3306/";
    static String user = "root";
    static String password = "123456";


    public static void Menu() {
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
                    /* GestTipoActor();
                    break; */
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
        ActorMySQLRepository actorMySQLRepository = new ActorMySQLRepository(url, user, password);
        ActorService actorService = new ActorService(actorMySQLRepository);
        ActorConsoleAdapter actorConsoleAdapter = new ActorConsoleAdapter(actorService);
        boolean isActiveActor = true;
        while (isActiveActor) {
            ConsoleUtils.limpiarConsola();
            System.out.println("Seccion Gestion de Peliculas");
            System.out.println("que desea Hacer:");
            System.out.println("1) Agregar actor:");
            System.out.println("2) editar actor:");
            System.out.println("3) eliminar actor:");
            System.out.println("4) listar actor:");
            System.out.println("5. Volver");
            int opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1 -> {
                    ConsoleUtils.limpiarConsola();
                    actorConsoleAdapter.registerActor();
                }

                case 2 -> {
                    ConsoleUtils.limpiarConsola();
                    actorConsoleAdapter.updateActor();
                }
                
                case 3 -> {
                    ConsoleUtils.limpiarConsola();
                    actorConsoleAdapter.dropActor();
                }

                case 4 -> {
                    ConsoleUtils.limpiarConsola();
                    actorConsoleAdapter.getActors();
                }

                case 5 -> {
                    isActiveActor = false;
                }

                default -> {
                    isActiveActor = false;
                }
            }
        }
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
        GenderMySQLRepository genderMySQLRepository = new GenderMySQLRepository(url, user, password);
        GenderService genderService = new GenderService(genderMySQLRepository);
        GenderConsoleAdapter genderConsoleAdapter = new GenderConsoleAdapter(genderService);
        boolean isActiveGender = true;
        while (isActiveGender) {
            ConsoleUtils.limpiarConsola();
            System.out.println("Seccion Gestion de Peliculas");
            System.out.println("que desea Hacer:");
            System.out.println("1) Agregar Genero:");
            System.out.println("2) editar Genero:");
            System.out.println("3) eliminar Genero:");
            System.out.println("4) listar Genero:");
            System.out.println("5. Volver");
            int opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1 -> {
                    ConsoleUtils.limpiarConsola();
                    genderConsoleAdapter.registerGender();
                }

                case 2 -> {
                    ConsoleUtils.limpiarConsola();
                    genderConsoleAdapter.updateGender();
                }
                
                case 3 -> {
                    ConsoleUtils.limpiarConsola();
                    genderConsoleAdapter.dropGender();
                }

                case 4 -> {
                    ConsoleUtils.limpiarConsola();
                    genderConsoleAdapter.getGenders();
                }

                default -> {
                    isActiveGender = false;
                }
            }
        }
    }

/*     public static void GestTipoActor() {
        ActorTypeMySQLRepository actorTypeMySQLRepository = new ActorTypeMySQLRepository(url, user, password);
        ActorTypeService actorTypeService = new ActorTypeService(actorTypeMySQLRepository);
        ActorTypeConsoleAdapter actorTypeConsoleAdapter = new ActorTypeConsoleAdapter(actorTypeService);
        boolean isActiveActorType = true;
        while (isActiveActorType) {
            ConsoleUtils.limpiarConsola();
            System.out.println("Seccion Gestion de Peliculas");
            System.out.println("que desea Hacer:");
            System.out.println("1) Agregar Genero:");
            System.out.println("2) editar Genero:");
            System.out.println("3) eliminar Genero:");
            System.out.println("4) listar Genero:");
            System.out.println("5. Volver");
            int opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1 -> {
                    ConsoleUtils.limpiarConsola();
                    actorTypeConsoleAdapter.registerActorType();
                }

                case 2 -> {
                    ConsoleUtils.limpiarConsola();
                    actorTypeConsoleAdapter.updateActorType();
                }
                
                case 3 -> {
                    ConsoleUtils.limpiarConsola();
                    actorTypeConsoleAdapter.dropActorType();
                }

                case 4 -> {
                    ConsoleUtils.limpiarConsola();
                    actorTypeConsoleAdapter.getActorTypes();
                }

                default -> {
                    isActiveActorType = false;
                }
            }
        }
    } */

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
