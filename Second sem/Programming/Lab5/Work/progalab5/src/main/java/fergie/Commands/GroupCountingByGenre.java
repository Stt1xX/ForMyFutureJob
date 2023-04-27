package fergie.Commands;

import fergie.CollectionManager;

import java.util.Scanner;

public class GroupCountingByGenre extends InputCommand implements Command {
    String description = "group_counting_by_genre : сгруппировать элементы коллекции по значению поля Genre, " +
            " вывести количество элементов в каждой группе";

    public GroupCountingByGenre(CollectionManager collectionManager, Scanner scanner) {
        super(collectionManager, scanner);

    }

    public void execute(String arg) {
        try {
            collectionManager.groupCountingByGenre(scanner, arg);
        } catch (IllegalArgumentException e) {
            System.out.println("Такого жанра не существует. ");
        }
    }


    public String getDescription() {
        return description;
    }

}
