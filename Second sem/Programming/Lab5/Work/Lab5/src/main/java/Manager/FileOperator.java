package Manager;

import Manager.MovieСharact.Movie;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.util.Scanner;

public class FileOperator {
    private final String PATH;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public FileOperator(String path) {
        PATH = path;
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void exportToXML(Movie movie) {
        try {
            JAXBContext context = JAXBContext.newInstance(Movie.class);
            marshaller = context.createMarshaller();
            unmarshaller = context.createUnmarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(movie, new PrintWriter(PATH + "Movies.xml"));
        } catch (IOException | JAXBException e) {
            System.out.println(e);
        }
    }

    public Scanner getScanner(String fileName) throws FileNotFoundException {
        try {
            return new Scanner(new File(PATH + fileName));
        } catch (Exception e) {
            throw new FileNotFoundException(String.format("Can't locate file %s in %s", fileName, PATH));
        }
    }

    public Object importFromXML() throws FileNotFoundException {
        try {
            Scanner unnecessaryScanner = new Scanner(new File(PATH + "Movies.xml"));
            StringWriter sw = new StringWriter();

            while(unnecessaryScanner.hasNextLine()){
                sw.append(unnecessaryScanner.nextLine());
            }
            StringReader sr = new StringReader(sw.toString());
            return unmarshaller.unmarshal(sr);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(String.format("Couldn't import Space Marines Data from %s, because marines.xml doesn't exist there.", PATH));
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
