package service;

import model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CityParser {
    /**
     * Считывает данные из файла и разбивает их в файл
     * @param file - файл, содержащий информацию о городах
     * @param cities - список для добавления городов
     */
    public static void parse(File file, List<City> cities) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] curCityInfo = scanner.nextLine().split(";", 6);
                City curCity = new City(curCityInfo);
                cities.add(curCity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
