package util;

import model.City;

import java.util.Comparator;

public class Comparators {
    /**
     * Для сортировки списка городов по наименованию в алфавитном порядке по убыванию без учета регистра
     */
    public static Comparator<City> cityByNameComparator() {
        return (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName());

    }

    /**
     * Для сортировки списка городов по федеральному округу и наименованию города внутри каждого федерального округа
     * в алфавитном порядке с учетом регистра
     */
    public static Comparator<City> cityByDistrictThenByNameComparator() {
        return (c1, c2) -> {
            if (c1.getDistrict().compareTo(c2.getDistrict()) == 0) {
                return c1.getName().compareTo(c2.getName());
            }
            return c1.getDistrict().compareTo(c2.getDistrict());
        };
    }
}
