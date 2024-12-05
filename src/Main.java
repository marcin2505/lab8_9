import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Utworzenie obiektów pomocniczych
        DataGenerator dataGenerator = new DataGenerator();
        FileHelper fileHelper = new FileHelper();
        PersonHelper personHelper = new PersonHelper();
        StatisticHelper statisticHelper = new StatisticHelper();

        // 1. Generowanie danych
        System.out.println("Generowanie listy osób...");
        List<Person> generatedPeople = dataGenerator.generatePeopleList(10);

        // 2. Zapis danych do pliku
        System.out.println("Zapisywanie danych do pliku...");
        fileHelper.saveListToFile(generatedPeople);

        // 3. Odczyt danych z pliku
        System.out.println("Odczytywanie danych z pliku...");
        List<String> readLines = fileHelper.readFromFile();

        // 4. Konwersja linii z pliku na listę obiektów Person
        System.out.println("Konwersja danych na obiekty Person...");
        List<Person> peopleFromFile = personHelper.convertListOfStringsToListOfPeople(readLines);

        // 5. Wyświetlenie osób wczytanych z pliku
        System.out.println("Wczytane osoby:");
        peopleFromFile.forEach(System.out::println);

        // 6. Analizy statystyczne
        System.out.println("\n--- Statystyki ---");

        System.out.println("Osoby pracujące w najstarszej firmie:");
        statisticHelper.displayPeopleInOldestCompany(peopleFromFile);

        System.out.println("\nIlość kobiet i mężczyzn:");
        statisticHelper.calculateGenderCount(peopleFromFile);

        System.out.println("\nŚredni wiek:");
        statisticHelper.calculateAverageAge(peopleFromFile);

        System.out.println("\nŚrednie zarobki:");
        statisticHelper.calculateAverageSalary(peopleFromFile);

        System.out.println("\nŚrednie zarobki według płci:");
        statisticHelper.calculateAverageSalaryByGender(peopleFromFile);

        System.out.println("\nRozpiętość zarobków:");
        statisticHelper.calculateSalaryRange(peopleFromFile);

        System.out.println("\nŚrednie zarobki według miast:");
        statisticHelper.calculateAverageSalaryByCity(peopleFromFile);
    }
}

