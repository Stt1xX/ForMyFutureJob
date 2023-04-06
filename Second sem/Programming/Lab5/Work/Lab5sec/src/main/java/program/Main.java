package program;

import commands.AddElem;
import commands.Storage;
import jakarta.xml.bind.JAXBException;
import movieCharact.Coordinates;
import movieCharact.Location;
import movieCharact.Movie;
import movieCharact.Person;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        //create test film
        Movie movie = new Movie();
        movie.setName("Titanik");
        movie.setGenre(Movie.MovieGenre.ACTION);
        movie.setOscarsCount(2L);
        Coordinates coordinates = new Coordinates();
        coordinates.setX(12.);
        coordinates.setY(13f);
        movie.setCoordinates(coordinates);
        movie.setMpaaRating(Movie.MpaaRating.NC_17);
        movie.createDate();
        movie.createId();
        Person person = new Person();
        person.setName("Tim");
        person.setHeight(8L);
        person.setEyeColor(Person.Color.GREEN);
        person.setNationality(Person.Country.FRANCE);
        Location location = new Location();
        location.setName("Avstria");
        location.setX(45);
        location.setY(21);
        location.setZ(12);
        person.setLocation(location);
        movie.setOperator(person);
        //create test film
        Storage storage = new Storage();
        storage.movies.add(movie);
        storage.movies.add(movie);
//        System.out.println(storage.movies.size());
//        storage.addToFile();
    }
}