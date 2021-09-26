import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/*Данный класс реализуюет интерфейс пароля и наследует класс File. Экземпляр данного класса имеет пароль,
 который задается методом @setNewPassword(), выполняющимся при создании экземпляра класса, и путь,
 который передается в конструктор. Чтобы получить данные из файла c помощью метода @getFileContent(),
 должен корректно отработать метод @isCorrectPassword(),который в свою очередь проверяет совпадает ли пароль
 экземпляра класса с введенной в консоли строки */

public class ProtectedFile extends File implements Password {
    private Scanner scanner = new Scanner(System.in);
    private String password;

    public ProtectedFile(String filePath) {
        super(filePath);
        setNewPassword();
    }

    public void getFileContent() {
        if (isCorrectPassword()) {
            System.out.println(WELCOME_WITH_PASSWORD);
            try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)))) {
                StringBuilder fileContent = new StringBuilder();
                while (reader.ready()) {
                    fileContent.append(reader.readLine());
                }
                System.out.println(fileContent);
                System.out.println("----------------------------------------------");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNewPassword() {
        System.out.println(SET_PASSWORD + " для " + this.path.getFileName());
        this.password = scanner.nextLine();
    }

    public boolean isCorrectPassword() {
        System.out.println(ENTER_PASSWORD + " для " + this.path.getFileName());
        for (int i = 0; i < 4; i++) {
            if (this.password.equals(scanner.nextLine())) {
                return true;
            } else if (i < 3) {
                System.out.printf(INCORRECT_PASSWORD_WITH_ATTEMPTS, NUMBER_OF_ATTEMPTS - i);
            } else
                System.out.println(INCORRECT_PASSWORD_SUPPORT);
        }
        return false;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
