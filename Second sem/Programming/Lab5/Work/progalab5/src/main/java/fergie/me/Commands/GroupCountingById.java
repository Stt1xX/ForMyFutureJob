package fergie.me.Commands;

import fergie.me.CollectionManager;

import java.util.Scanner;

public class GroupCountingById extends InputCommand implements Command {
    String description = "group_counting_by_genre : сгруппировать элементы коллекции по значению поля Genre, " +
            " вывести количество элементов в каждой группе";

    public GroupCountingById(CollectionManager collectionManager, Scanner scanner) {
        super(collectionManager, scanner);

    }

    public void execute() {
        try {
            collectionManager.groupCountingByGenre(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println("Такого жанра не существует. ");
        }
    }


    public String getDescription() {
        return description;
    }

}
