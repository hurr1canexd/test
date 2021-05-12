import model.City;
import util.CityParser;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static String FILE_PATH = "files/cities.txt";

    public static void main(String[] args) {
        List<City> parsed = CityParser.parse(new File(FILE_PATH));
        parsed.forEach(System.out::println);

        // Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра
        Comparator<City> cityByNameComparator = (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName());
        parsed.sort(cityByNameComparator);
        System.out.println("\n1st sort");
        parsed.forEach(System.out::println);


        // Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа
        // в алфавитном порядке по убыванию с учетом регистра
        Comparator<City> cityByDistrictTheByNameComparator = (c1, c2) -> {
            if (c1.getDistrict().compareTo(c2.getDistrict()) == 0) {
                return c1.getName().compareTo(c2.getName());
            }
            return c1.getDistrict().compareTo(c2.getDistrict());
        };
        parsed.sort(cityByDistrictTheByNameComparator);
        System.out.println("\n2nd sort:");
        parsed.forEach(System.out::println);
    }
}
