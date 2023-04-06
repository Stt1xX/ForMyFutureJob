package commands;

import jakarta.xml.bind.JAXBException;
import movieCharact.Movie;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddElem{

    public String getDiscription() {
        return "add {element} : добавить новый элемент в коллекцию";
    }


    public static void execute() throws JAXBException, FileNotFoundException {
        Movie movie = new Movie();
        movie.createMovie(new Scanner(System.in));
        System.out.println();
        Storage storage = new Storage();
        storage.movies.add(movie);
        storage.addToFile();

    }
}
