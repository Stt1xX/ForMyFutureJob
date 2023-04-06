package org.example;

import jakarta.xml.bind.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = context.createMarshaller();
        Unmarshaller unmarshaller = context.createUnmarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Cat cat1 = new Cat("вспыш", 8, 12);

        PrintWriter fileOutput = new PrintWriter("FileOutput.txt");
        marshaller.marshal(cat1, fileOutput);

        Path path = Paths.get("FileOutput.txt");
        Scanner scanner = new Scanner(path);
        StringBuilder storage = new StringBuilder();

        while(scanner.hasNextLine()){
            storage.append(scanner.nextLine());
        }

        StringReader reader = new StringReader(storage.toString());
        Cat cat2 = (Cat) unmarshaller.unmarshal(reader);
        System.out.println(cat2);
        scanner.close();
    }
}