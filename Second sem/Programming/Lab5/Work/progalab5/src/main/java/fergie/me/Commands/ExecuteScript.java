package fergie.me.Commands;

import fergie.me.CollectionManager;
import fergie.me.CommandManager;
import fergie.me.FileManager;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExecuteScript extends InputCommand implements Command {

    int counter; //для рекурсии
    String description = "execute_script file_name: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";

    public ExecuteScript(CollectionManager collectionManager, Scanner scanner) {
        super(collectionManager, scanner);
    }
    public void execute() {
        if (counter < 20) {
            System.out.println("Введите путь до скрипта (включая его имя):");
            Path path = Paths.get(scanner.nextLine());
            try {
                Scanner scannerForScript = new Scanner(path);
                String arg[];
                CommandManager commandManagerForScript = new CommandManager(collectionManager, scannerForScript);
                counter += 1;
                while (scannerForScript.hasNextLine()) {
                    String s = (scannerForScript.nextLine());
                    arg = s.split("\s+");
                    if (arg.length == 1) {
                        if (s.equals("exit")) {
                            break;
                        }
                        try {
                            commandManagerForScript.getCommands().get(s).execute();
                        } catch (NullPointerException e) {
                            System.out.println("Введенной команды не существует.");
                        }
                    } else
                        System.out.println("Слишком длинная команда.");

                }
                System.out.println("Скрипт выполнен");
            } catch (IOException e) {
                System.out.println("Ошибка в пути к файлу");
            }
        }
        else{
            System.out.println("Блокировка скрипта, из-за рекурсии");
        }
    }


    public String getDescription() {
        return description;
    }

}
