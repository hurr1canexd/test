import model.City;
import util.CityParser;

import java.io.File;
import java.util.List;

public class Main {
    private static String FILE_PATH = "files/cities.txt";

    public static void main(String[] args) {
        List<City> parsed = CityParser.parse(new File(FILE_PATH));
        for (City city: parsed) {
            System.out.println(city);
        }
    }
}
