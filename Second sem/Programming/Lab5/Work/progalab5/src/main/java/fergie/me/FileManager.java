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
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Scanner;
/**
 * A Class for all file operations and XML marshalling.
 * @author St1xXx
 * @version 0.1
 * @exception IOException, JAXBException
 */
@XmlType(name = "storage")
@XmlRootElement
public class FileManager extends CollectionManager {

    @XmlElement(name = "movies")
    public ArrayDeque<Movie> movies = arrayDeque;
    @XmlTransient
    public final String path = System.getenv("MOVIES_PATH");

    public FileManager() {

    }

    public void exportToFile(CollectionManager collectionManager) {
        // add to movies in FileManager
        FileManager fileManager = new FileManager();
        fileManager.movies.addAll(collectionManager.arrayDeque);

        try {

            // create marshaller
            JAXBContext context = JAXBContext.newInstance(Movie.class, Person.class, Location.class,
                    Coordinates.class, FileManager.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            PrintWriter fileOutput = new PrintWriter(path + "Movies.xml");
            marshaller.marshal(fileManager, fileOutput);
            // create marshaller

        } catch (JAXBException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public CollectionManager importFromFile() { // return ready Collection
        try {

            JAXBContext context = JAXBContext.newInstance(Movie.class, Person.class, Location.class,
                    Coordinates.class, FileManager.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();


            // Bloody parse

            Path path = Paths.get(this.path + "Movies.xml");
            Scanner scanner = new Scanner(path);
            StringBuilder storage = new StringBuilder();
            while (scanner.hasNextLine()) {
                storage.append(scanner.nextLine());
            }
            StringReader reader = new StringReader(storage.toString());
            // Bloody parse

            // FileManager fileManager = (FileManager) unmarshaller.unmarshal(new File("***"));
            //how would parse the normal guy
            FileManager fileManager = (FileManager) unmarshaller.unmarshal(reader);
            CollectionManager collectionManager = new CollectionManager();
            collectionManager.arrayDeque = fileManager.movies;
            return collectionManager;
        } catch (IOException e) {
            System.out.println("Убедитесь, что в переменной окружения правильный путь.");
        } catch (JAXBException e) {
            System.out.println("Предупреждение: коллекция пуста");
        }
        return new CollectionManager();
    }

    public Scanner getScanner(String scriptAdress) {
        Path path = Paths.get(scriptAdress);
        try {
            return new Scanner(path);
        } catch (IOException e) {
            System.out.println("Убедитесь, что в переменной окружения правильный путь.");
        }
        return null;
    }
}