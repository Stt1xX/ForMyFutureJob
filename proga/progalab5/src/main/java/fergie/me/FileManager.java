package fergie.me;

import fergie.me.Data.Coordinates;
import fergie.me.Data.Location;
import fergie.me.Data.Movie;
import fergie.me.Data.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
@XmlRootElement(name = "storage")
public class FileManager extends CollectionManager{
    FileManager(){

    }
    @XmlElement(name = "movies")
    public ArrayDeque<Movie> movies = arrayDeque; // change, was private
    public void importToFile() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Movie.class, Person.class, Location.class,
                Coordinates.class, FileManager.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        PrintWriter fileOutput = new PrintWriter("Movies.xml");
        marshaller.marshal(this, fileOutput);
    }
    public void exportFromFile() throws JAXBException{
        JAXBContext context = JAXBContext.newInstance();
        Unmarshaller unmarshaller = context.createUnmarshaller();

    }
}
