package service;

import model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityParser {
    public static List<City> parse(File file) {
        List<City> cities = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] curCityInfo = scanner.nextLine().split(";", 6);
                City curCity = new City(curCityInfo);
                cities.add(curCity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return cities;
    }
}
