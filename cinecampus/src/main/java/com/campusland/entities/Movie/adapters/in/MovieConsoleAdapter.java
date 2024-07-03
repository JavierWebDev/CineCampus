package com.campusland.entities.Movie.adapters.in;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.campusland.utils.ConsoleUtils;
import com.campusland.entities.Movie.application.MovieService;
import com.campusland.entities.Movie.domain.Movie;


public class MovieConsoleAdapter {
    static Scanner sc = new Scanner(System.in);

    private final MovieService movieService;

    

    public MovieConsoleAdapter(MovieService movieService) {
        this.movieService = movieService;
    }

    public void registerMovie() {
        String rta = "S";
        while (rta.equalsIgnoreCase("s")) {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** REGISTRO PELICULA ***************");
            System.out.println("[*] INGRESE EL ID DEL PELICULA: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println("[*] INGRESE EL CODIGO INTERNO DE LA PELICULA: ");
            String codInterno = sc.nextLine();
            
            System.out.println("[*] INGRESE EL NOMBRE DE PELICULA: ");
            String nombre = sc.nextLine();

            System.out.println("[*] INGRESE DURACION DE LA PELICULA: ");
            String duracion = sc.nextLine();

            System.out.println("[*] INGRESE LA SINOPSIS:");
            String sinopsis = sc.nextLine();

            Movie movie = new Movie(id, codInterno, nombre, duracion, sinopsis);
            movieService.createMovie(movie);

            ConsoleUtils.limpiarConsola();
            System.out.println("[?] DESEA REGISTRAR OTRO PELICULA? [S - Si | Cualquier tecla para salir]");
            rta = sc.nextLine();
        }
    }

    public void updateMovie() {
        List<Movie> countries = movieService.getAllMovies();
        if (countries.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUN PELICULA REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ACTUALIZACION DE PELICULA ***************");
            System.out.println("[*] INGRESE EL ID DE LA PELICULA: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Movie> matchMovie = movieService.findMovieById(id);

            matchMovie.ifPresentOrElse(a -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("*************** ACTUALIZACION DE PELICULA***************");
                System.out.println("[*] INGRESE EL CODIGO INTERNO DE LA PELICULA: ");
                String codInterno = sc.nextLine();
                
                System.out.println("[*] INGRESE EL NOMBRE DE PELICULA: ");
                String nombre = sc.nextLine();
    
                System.out.println("[*] INGRESE DURACION DE LA PELICULA: ");
                String duracion = sc.nextLine();
    
                System.out.println("[*] INGRESE LA SINOPSIS:");
                String sinopsis = sc.nextLine();
    
                Movie movie = new Movie(id, codInterno, nombre, duracion, sinopsis);
                movieService.updateMovie(movie);
    
                ConsoleUtils.limpiarConsola();
            }, 
            () -> {
                ConsoleUtils.limpiarConsola();
                System.out.println("[!] NO EXISTE UNA PELICULA CON TAL ID!");
                sc.nextLine();
            });

        }
    }

    public void dropMovie() {
        List<Movie> movies = movieService.getAllMovies();
        if (movies.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUNA PELICULA REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** ELIMINACION DE PELICULA ***************");
            System.out.println("[?] INGRESE EL ID DEL PELICULA A ELIMINAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Movie> matchMovie = movieService.findMovieById(id);
            matchMovie.ifPresentOrElse(
                m -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[?] ESTAS SEGURO QUE DESEAS ELIMINAR EL PELICULA {0} ? [S - Si | Cuaquier tecla - No]", m.getId()));
                    String sel = sc.nextLine();

                    if (sel.equalsIgnoreCase("S")) {
                        ConsoleUtils.limpiarConsola();
                        System.out.println("[*] LA PELICULA HA SIDO ELIMINADO EXITOSAMENTE");
                        movieService.deleteMovie(id);
                    } else {
                        sc.nextLine();
                    }
                },
                () -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[!] NO HAY NINGUNA PELICULA REGISTRADA CON EL ID [{0}]", id));
                    sc.nextLine();
                });
        }
    }

    public void getMovieByID() {
        List<Movie> conutries = movieService.getAllMovies();
        if (conutries.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUNA PELICULA REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** BUSQUEDA DE PELICULA ***************");
            System.out.println("[?] INGRESE EL ID DEL PELICULA A BUSCAR: ");
            int id = Integer.parseInt(sc.nextLine());

            Optional<Movie> matchMovie = movieService.findMovieById(id);
            matchMovie.ifPresentOrElse(
                m -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println("***************PELICULA***************");
                    System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] CODIGO INTERNO: {1}\n       [*] NOMBRE: {2}\n       [*] DURACION: {3}\n       [*] SINOPSIS: {4}", m.getId(), m.getCodinterno(), m.getNombre(), m.getDuracion(), m.getSinopsis()));
                    sc.nextLine();
                },
                () -> {
                    ConsoleUtils.limpiarConsola();
                    System.out.println(MessageFormat.format("[!] NO HAY NINGUNA PELICULA REGISTRADA CON EL ID [{0}]", id));
                    sc.nextLine();
                });
        }
    }

    public void getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        if (movies.isEmpty()) {
            ConsoleUtils.limpiarConsola();
            System.out.println("[!] NO HAY NINGUNA PELICULA REGISTRADO! ");
            sc.nextLine();
        } else {
            ConsoleUtils.limpiarConsola();
            System.out.println("*************** PELICULAES ***************");
            movies.forEach(m -> {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(MessageFormat.format("       [*] ID: {0}\n       [*] CODIGO INTERNO: {1}\n       [*] NOMBRE: {2}\n       [*] DURACION: {3}\n       [*] SINOPSIS: {4}", m.getId(), m.getCodinterno(), m.getNombre(), m.getDuracion(), m.getSinopsis()));
            });
            sc.nextLine();
        }
    }
}
