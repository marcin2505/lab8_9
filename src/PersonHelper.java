import java.util.ArrayList;
import java.util.List;

public class PersonHelper {

    // Konwertuje listę linii tekstowych na listę obiektów Person
    public List<Person> convertListOfStringsToListOfPeople(List<String> list) {
        List<Person> people = new ArrayList<>();
        for (String line : list) {
            people.add(convertStringToPerson(line));
        }
        return people;
    }

    // Konwertuje linię tekstową na obiekt Person
    public Person convertStringToPerson(String data) {
        String[] parts = data.split(";");
        if (parts.length != 8) {
            throw new IllegalArgumentException("Nieprawidłowa struktura danych: " + data);
        }

        String name = parts[0];
        String surname = parts[1];
        String sex = parts[2];
        int bornYear = Integer.parseInt(parts[3]);
        String job = parts[4];
        double salary = Double.parseDouble(parts[5]);

        // Rozdzielenie danych Address
        String[] addressParts = parts[6].split(", ");
        String[] streetParts = addressParts[0].split(" ");
        String street = streetParts[0];
        String houseNo = streetParts[1].split("/")[0];
        String flatNo = streetParts[1].split("/")[1];
        String postalCode = addressParts[1].split(" ")[0];
        String city = addressParts[1].split(" ")[1];
        String country = addressParts[2];

        Address address = new Address(street, flatNo, houseNo, postalCode, city, country);

        // Rozdzielenie danych Company
        String[] companyParts = parts[7].split(" \\(rok założenia: ");
        String companyName = companyParts[0];
        int companyYear = Integer.parseInt(companyParts[1].replace(")", ""));
        Company company = new Company(companyName, companyYear);

        return new Person(name, surname, sex, bornYear, job, company, salary, address);
    }
}
