package commands;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.*;
import movieCharact.Coordinates;
import movieCharact.Location;
import movieCharact.Movie;
import movieCharact.Person;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

@XmlRootElement(name = "storage")
public class Storage {

    public Storage(){

    }

    public Deque<Movie> movies = new ArrayDeque<>();

    public void addToFile() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Movie.class, Person.class, Coordinates.class, Location.class, Storage.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        PrintWriter fileOutput = new PrintWriter("Movies.xml");
        marshaller.marshal(this, fileOutput);
    }
}
