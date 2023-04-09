package fergie.me.Commands;

import fergie.me.CollectionManager;
import fergie.me.Data.MovieGenre;

import java.util.Arrays;
import java.util.Scanner;

public class CountGreaterThanGenre extends InputCommand implements Command {
    String description = "count_greater_than_genre genre : вывести количество элементов, значение поля genre которых больше заданного";

    public CountGreaterThanGenre(CollectionManager collectionManager, Scanner scanner) {
        super(collectionManager, scanner);
    }

    public void execute() {
        while (true) {
            try {
                System.out.println("Выберите жанр из списка: ");
                System.out.println(Arrays.toString(MovieGenre.values()));
                String genre = scanner.nextLine();
                Integer count = collectionManager.countGreaterThanGenre(MovieGenre.valueOf(genre));
                System.out.println("Количество элементов: " + count);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Введено не существующее значение. Попробуйте еще раз: ");
            } catch (NullPointerException e) {
                System.out.println("У заданного фильма отсутствует жанр.");
            }
        }


    }

    public String getDescription() {
        return description;
    }
}
