package com.campusland;

import java.util.Scanner;

import com.campusland.entities.Actor.adapters.in.ActorConsoleAdapter;
import com.campusland.entities.Actor.adapters.out.ActorMySQLRepository;
import com.campusland.entities.Actor.application.ActorService;
import com.campusland.entities.ActorType.adapters.in.ActorTypeConsoleAdapter;
import com.campusland.entities.ActorType.adapters.out.ActorTypeMySQLRepository;
import com.campusland.entities.ActorType.application.ActorTypeService;
import com.campusland.entities.Country.adapters.in.CountryConsoleAdapter;
import com.campusland.entities.Country.adapters.out.CountryMySQLRepository;
import com.campusland.entities.Country.application.CountryService;
import com.campusland.entities.Format.adapters.in.FormatConsoleAdapter;
import com.campusland.entities.Format.adapters.out.FormatMySQLRepository;
import com.campusland.entities.Format.application.FormatService;
import com.campusland.entities.Gender.adapters.in.GenderConsoleAdapter;
import com.campusland.entities.Gender.adapters.out.GenderMySQLRepository;
import com.campusland.entities.Gender.application.GenderService;
import com.campusland.entities.Movie.adapters.in.MovieConsoleAdapter;
import com.campusland.entities.Movie.adapters.out.MovieMySQLRepository;
import com.campusland.entities.Movie.application.MovieService;
import com.campusland.utils.ConsoleUtils;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static String url = "jdbc:mysql://localhost:3306/cinecampus";
    static String user = "campus2023";
    static String password = "campus2023";

    public static void menu() {
        boolean isActiveApp = true;
        while (isActiveApp) {
            ConsoleUtils.limpiarConsola();
            System.out.println("Bienvenido a CineCampus");
            System.out.println("que desea Hacer:");
            System.out.println("1) Gestion de Actores:");
            System.out.println("2) Gestion de pelicula:");
            System.out.println("3) Gestion de formato:");
            System.out.println("4) Asignacion de Formatos:");
            System.out.println("5) Gestion de pelicula:");
            System.out.println("6) Asignacion de Actores a Peliculas:");
            System.out.println("7) Gestion de Generos:");
            System.out.println("8) Gestion de Paises:");
            System.out.println("9) Gestion de Tipos de Actores:");
            System.out.println("10) Consultar de Informacion detallada de una Pelicula:");
            System.out.println("11) Lista de Actores por Pelicula:");
            System.out.println("12) Salida");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1 -> {
                    gestActores();
                }

                case 2 -> {
                    gestPeliculas();
                }

                case 3 -> {
                    gestFormato();
                }

                case 4 -> {
                    asgActoresPel();
                }

                case 5 -> {
                    gestPeliculas();
                }

                case 6 -> {
                    asgActoresPel();
                }
                case 7 -> {
                    gestGenero();
                }
                case 8 -> {
                    gestPais();
                }

                case 9 -> {
                    gestTipoActor();
                }

                case 10 -> {
                    consInfoPelicula();

                }

                case 11 -> {
                    listActorPel();
                }

                case 12 -> {
                    isActiveApp = false;
                }

                default -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println("[!] Ingresaste una opción inválida.");
                    sc.nextLine();
                }
            }
        }
    }

    public static void gestActores() {
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
            System.out.println("5) Volver");
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
                    ConsoleUtils.limpiarConsola();
                    System.out.println("[!] Ingresaste una opción inválida.");
                    sc.nextLine();
                }
            }
        }
    }

    public static void gestPeliculas() {
        MovieMySQLRepository movieMySQLRepository = new MovieMySQLRepository(url, user, password);
        MovieService movieService = new MovieService(movieMySQLRepository);
        MovieConsoleAdapter movieConsoleAdapter = new MovieConsoleAdapter(movieService);
        boolean isActiveMovie = true;
        while (isActiveMovie) {
            ConsoleUtils.limpiarConsola();
            System.out.println("Seccion Gestion de Peliculas");
            System.out.println("que desea Hacer:");
            System.out.println("1) Agregar Pelicula:");
            System.out.println("2) editar Pelicula:");
            System.out.println("3) eliminar Pelicula:");
            System.out.println("4) listar Pelicula:");
            System.out.println("5) Volver");
            int opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1 -> {
                    ConsoleUtils.limpiarConsola();
                    movieConsoleAdapter.registerMovie();
                }

                case 2 -> {
                    ConsoleUtils.limpiarConsola();
                    movieConsoleAdapter.updateMovie();
                }

                case 3 -> {
                    ConsoleUtils.limpiarConsola();
                    movieConsoleAdapter.dropMovie();
                }

                case 4 -> {
                    ConsoleUtils.limpiarConsola();
                    movieConsoleAdapter.getAllMovies();
                }

                case 5 -> {
                    isActiveMovie = false;
                }

                default -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println("[!] Ingresaste una opción inválida.");
                    sc.nextLine();
                }
            }
        }
    }

    public static void gestFormato() {
        FormatMySQLRepository formatMySQLRepository = new FormatMySQLRepository(url, user, password);
        FormatService formatService = new FormatService(formatMySQLRepository);
        FormatConsoleAdapter formatConsoleAdapter = new FormatConsoleAdapter(formatService);
        boolean isActiveFormat = true;
        while (isActiveFormat) {
            ConsoleUtils.limpiarConsola();
            System.out.println("Seccion Gestion de Formatos");
            System.out.println("que desea Hacer:");
            System.out.println("1) Agregar Formatos:");
            System.out.println("2) editar Formatos:");
            System.out.println("3) eliminar Formatos:");
            System.out.println("4) listar Formatos:");
            System.out.println("5) Volver");
            int opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1 -> {
                    ConsoleUtils.limpiarConsola();
                    formatConsoleAdapter.registerFormat();
                }

                case 2 -> {
                    ConsoleUtils.limpiarConsola();
                    formatConsoleAdapter.updateFormat();
                }

                case 3 -> {
                    ConsoleUtils.limpiarConsola();
                    formatConsoleAdapter.dropFormat();
                }

                case 4 -> {
                    ConsoleUtils.limpiarConsola();
                    formatConsoleAdapter.getAllFormats();
                }

                case 5 -> {
                    isActiveFormat = false;
                }

                default -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println("[!] Ingresaste una opción inválida.");
                    sc.nextLine();
                }
            }
        }
    }

    public static void gestPais() {
        CountryMySQLRepository countryMySQLRepository = new CountryMySQLRepository(url, user, password);
        CountryService countryService = new CountryService(countryMySQLRepository);
        CountryConsoleAdapter countryConsoleAdapter = new CountryConsoleAdapter(countryService);
        boolean isActiveCountry = true;
        while (isActiveCountry) {
            ConsoleUtils.limpiarConsola();
            System.out.println("Seccion Gestion de Peliculas");
            System.out.println("que desea Hacer:");
            System.out.println("1) Agregar Pais:");
            System.out.println("2) editar Pais:");
            System.out.println("3) eliminar Pais:");
            System.out.println("4) listar Paises:");
            System.out.println("5) Volver");
            int opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1 -> {
                    countryConsoleAdapter.registerCountry();
                }
                case 2 -> {
                    countryConsoleAdapter.updateCountry();
                }
                case 3 -> {
                    countryConsoleAdapter.dropCountry();
                }
                case 4 -> {
                    countryConsoleAdapter.getAllCountrys();
                }
                case 5 -> {
                    isActiveCountry = false;
                }

                default -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println("[!] Ingresaste una opción inválida.");
                    sc.nextLine();
                }
            }
        }
    }

    public static void asgActoresPel() {
        ConsoleUtils.limpiarConsola();
        System.out.println("Seccion Asignacion de Actores a Peliculas");
    }

    public static void gestGenero() {
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
            System.out.println("5) Volver");
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

                case 5 -> {
                    isActiveGender = false;
                }

                default -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println("[!] Ingresaste una opción inválida.");
                    sc.nextLine();
                }
            }
        }
    }

    public static void gestTipoActor() {
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
            System.out.println("5) Volver");
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
                    actorTypeConsoleAdapter.getActorsTypes();
                }

                case 5 -> {
                    isActiveActorType = false;
                }

                default -> {
                    System.out.println("[!] Ingresaste una opción inválida.");
                    sc.nextLine();
                }
            }
        }
    }

    public static void consInfoPelicula() {
        ConsoleUtils.limpiarConsola();
        System.out.println("Seccion Consulta de informacion detallada de una Pelicula");
    }

    public static void listActorPel() {
        ConsoleUtils.limpiarConsola();
        System.out.println("Seccion Listar Actores por Pelicula");
    }

    public static void main(String[] args) {
        boolean isActive = true;
        while (isActive) {
            try {
                menu();
            } catch (NumberFormatException e) {
                ConsoleUtils.limpiarConsola();
                System.out.println("[!] Ingresaste una opción inválida.");
                sc.nextLine();
            }
        }
    }
}
