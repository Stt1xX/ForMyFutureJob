package Manager;

import Manager.MovieСharact.*;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayDeque;
import java.util.Deque;

class Main{
    public static void main(String[] args) throws InvalidAttributeValueException {
        Deque<Movie> movies = new ArrayDeque<>();
        Movie movie1 = new Movie("Titanik", new Coordinates(2.5, 3.0f), 4L, MovieGenre.DRAMA,
                MpaaRating.NC_17, new Person("Mariya Bogydanova", 3L, Color.GREEN, Country.JAPAN, new Location(4.2f, 5.7f, 2L, "ITMO")));
        FileOperator fileOp = new FileOperator("");
        fileOp.exportToXML(movie1);
        System.out.println(fileOp.getMarshaller());
    }
}