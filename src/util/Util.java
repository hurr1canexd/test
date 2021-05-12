package util;

import model.City;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Util {
    /**
     * Преобразовать список городов в массив и путем перебора массива найти индекс элемента и значение с наибольшим количеством жителей города.
     */
    public static int[] findCityWithHighestPopulation(List<City> cities) {
        if (cities.isEmpty()) {
            return new int[] {0, 0};
        }
        // TODO: 12.05.2021 Implement with streams
        City[] citiesArr = cities.toArray(new City[0]);

        int maxIndex = 0;
        for (int i = 0; i < citiesArr.length; i++) {
            if (citiesArr[i].getPopulation() > citiesArr[maxIndex].getPopulation()) {
                maxIndex = i;
            }
        }

        return new int[] {maxIndex, citiesArr[maxIndex].getPopulation()};
    }

    /**
     * Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра
     */
    public static void sortCitiesByNameIgnoreCase(List<City> cities) {
        Comparator<City> cityByNameComparator = (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName());
        cities.sort(cityByNameComparator);
    }

    /**
     * Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа
     * в алфавитном порядке по убыванию с учетом регистра
     */
    public static void sortCitiesByDistrictThenByName(List<City> cities) {
        Comparator<City> cityByDistrictThenByNameComparator = (c1, c2) -> {
            if (c1.getDistrict().compareTo(c2.getDistrict()) == 0) {
                return c1.getName().compareTo(c2.getName());
            }
            return c1.getDistrict().compareTo(c2.getDistrict());
        };
        cities.sort(cityByDistrictThenByNameComparator);
    }
}
