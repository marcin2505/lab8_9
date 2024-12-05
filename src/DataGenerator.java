import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
    private static final String[] NAMES = {"Jan", "Anna", "Marek", "Katarzyna", "Piotr", "Zofia"};
    private static final String[] SURNAMES = {"Kowalski", "Nowak", "Wiśniewski", "Dąbrowski", "Lewandowski"};
    private static final String[] JOBS = {"Inżynier", "Lekarz", "Nauczyciel", "Programista", "Prawnik"};
    private static final String[] COMPANY_NAMES = {"TechCorp", "HealthCare Inc.", "EduWorld", "SoftDev", "LegalGroup"};
    private static final String[] STREETS = {"Świętokrzyska", "Marszałkowska", "Piłsudskiego", "Kwiatowa", "Słoneczna"};
    private static final String[] CITIES = {"Warszawa", "Kraków", "Łódź", "Poznań", "Gdańsk"};
    private static final String COUNTRY = "Polska";

    private final Random random = new Random();

    public List<Person> generatePeopleList(int n) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            people.add(generatePerson());
        }
        return people;
    }

    public Person generatePerson() {
        String name = NAMES[random.nextInt(NAMES.length)];
        String surname = SURNAMES[random.nextInt(SURNAMES.length)];
        String sex = random.nextBoolean() ? "Mężczyzna" : "Kobieta";
        int bornYear = random.nextInt(42) + 1960; // Zakres od 1960 do 2001
        String job = JOBS[random.nextInt(JOBS.length)];
        Company company = generateCompany();
        double salary = 3000 + random.nextDouble() * 7000; // Pensja między 3000 a 10000
        Address address = generateAddress();

        return new Person(name, surname, sex, bornYear, job, company, salary, address);
    }

    private Company generateCompany() {
        String name = COMPANY_NAMES[random.nextInt(COMPANY_NAMES.length)];
        int year = random.nextInt(101) + 1920; // Zakres od 1920 do 2021
        return new Company(name, year);
    }

    private Address generateAddress() {
        String street = STREETS[random.nextInt(STREETS.length)];
        String flatNo = String.valueOf(random.nextInt(50) + 1);
        String houseNo = String.valueOf(random.nextInt(200) + 1);
        String postalCode = String.format("%02d-%03d", random.nextInt(100), random.nextInt(1000));
        String city = CITIES[random.nextInt(CITIES.length)];
        return new Address(street, flatNo, houseNo, postalCode, city, COUNTRY);
    }
}

