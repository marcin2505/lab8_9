import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    private static final String FILE_NAME = "people.txt";

    // Zapisuje listę osób do pliku
    public void saveListToFile(List<Person> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Person person : list) {
                writer.write(convertPersonToString(person));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku: " + e.getMessage());
        }
    }

    // Odczytuje dane z pliku i zwraca je jako listę ciągów znakowych
    public List<String> readFromFile() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu z pliku: " + e.getMessage());
        }
        return lines;
    }

    // Konwertuje obiekt Person na reprezentację tekstową
    private String convertPersonToString(Person person) {
        return person.getName() + ";" +
                person.getSurname() + ";" +
                person.getSex() + ";" +
                person.getBornYear() + ";" +
                person.getJob() + ";" +
                person.getSalary() + ";" +
                person.getAddress() + ";" +
                person.getCompany();
    }
}
