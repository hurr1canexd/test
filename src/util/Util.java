package util;

import model.City;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
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

    /**
     * Находит индекс элемента и значение с наибольшим количеством жителей города
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
     * Определяет количество городов в разрезе регионов
     */
    public static Map<String, Integer> getCitiesNumberByRegions(List<City> cities) {
        // TODO: 12.05.2021 Implement with streams
        Map<String, Integer> map = new HashMap<>();
        for (City city: cities) {
            String curRegion = city.getRegion();
            if (map.containsKey(curRegion)) {
                map.put(curRegion, map.get(curRegion) + 1);
            } else {
                map.put(curRegion, 1);
            }
        }

        return map;
    }
}
