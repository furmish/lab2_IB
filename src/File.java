import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

/*Класс для получения данных из файла
* объект данного класса содержит только поле пути, который передается в конструктор и метод получения контента файла
* @getFileContent()*/

public class File {
    public Path path;

    public File(String filePath) {
        this.path = Path.of(filePath);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public void getFileContent() {
        System.out.println(Password.CONTENT);
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
