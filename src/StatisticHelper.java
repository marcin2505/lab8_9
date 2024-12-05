import java.util.*;
import java.util.stream.Collectors;

public class StatisticHelper {

    // Wyświetla osoby pracujące w najstarszej firmie
    public void displayPeopleInOldestCompany(List<Person> people) {
        OptionalInt oldestYear = people.stream()
                .mapToInt(p -> p.getCompany().getYear())
                .min();

        if (oldestYear.isPresent()) {
            List<Person> inOldestCompany = people.stream()
                    .filter(p -> p.getCompany().getYear() == oldestYear.getAsInt())
                    .collect(Collectors.toList());

            System.out.println("Osoby pracujące w najstarszej firmie:");
            inOldestCompany.forEach(System.out::println);
        } else {
            System.out.println("Brak danych o firmach.");
        }
    }

    // Oblicza ilość kobiet i mężczyzn
    public void calculateGenderCount(List<Person> people) {
        long maleCount = people.stream()
                .filter(p -> p.getSex().equalsIgnoreCase("Mężczyzna"))
                .count();
        long femaleCount = people.stream()
                .filter(p -> p.getSex().equalsIgnoreCase("Kobieta"))
                .count();

        System.out.println("Liczba mężczyzn: " + maleCount);
        System.out.println("Liczba kobiet: " + femaleCount);
    }

    // Oblicza średni wiek
    public void calculateAverageAge(List<Person> people) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        double averageAge = people.stream()
                .mapToInt(p -> currentYear - p.getBornYear())
                .average()
                .orElse(0);

        System.out.println("Średni wiek: " + averageAge);
    }

    // Oblicza średnie zarobki
    public void calculateAverageSalary(List<Person> people) {
        double averageSalary = people.stream()
                .mapToDouble(Person::getSalary)
                .average()
                .orElse(0);

        System.out.println("Średnie zarobki: " + averageSalary + " zł");
    }

    // Oblicza średnie zarobki według płci
    public void calculateAverageSalaryByGender(List<Person> people) {
        Map<String, Double> averageSalaryByGender = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getSex,
                        Collectors.averagingDouble(Person::getSalary)
                ));

        System.out.println("Średnie zarobki według płci:");
        averageSalaryByGender.forEach((gender, avgSalary) ->
                System.out.println(gender + ": " + avgSalary + " zł"));
    }

    // Oblicza rozpiętość zarobków
    public void calculateSalaryRange(List<Person> people) {
        OptionalDouble minSalary = people.stream()
                .mapToDouble(Person::getSalary)
                .min();
        OptionalDouble maxSalary = people.stream()
                .mapToDouble(Person::getSalary)
                .max();

        if (minSalary.isPresent() && maxSalary.isPresent()) {
            double range = maxSalary.getAsDouble() - minSalary.getAsDouble();
            System.out.println("Rozpiętość zarobków: " + range + " zł");
        } else {
            System.out.println("Brak danych o zarobkach.");
        }
    }

    // Oblicza średnie zarobki według miast
    public void calculateAverageSalaryByCity(List<Person> people) {
        Map<String, Double> averageSalaryByCity = people.stream()
                .collect(Collectors.groupingBy(
                        p -> p.getAddress().getCity(),
                        Collectors.averagingDouble(Person::getSalary)
                ));

        System.out.println("Średnie zarobki według miast:");
        averageSalaryByCity.forEach((city, avgSalary) ->
                System.out.println(city + ": " + avgSalary + " zł"));
    }
}
