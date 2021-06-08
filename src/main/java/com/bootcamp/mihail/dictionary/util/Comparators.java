package com.bootcamp.mihail.dictionary.util;

import com.bootcamp.mihail.dictionary.model.City;

import java.util.Comparator;

public class Comparators {
    private Comparators() {}

    /**
     * Сравнивает города по наименованию в алфавитном порядке без учета регистра
     */
    public static final Comparator<City> cityByNameComparator = (c1, c2) ->
            c1.getName().compareToIgnoreCase(c2.getName());

    /**
     * Сравнивает города по федеральному округу и наименованию города внутри каждого федерального округа
     * в алфавитном порядке с учетом регистра
     */
    public static final Comparator<City> cityByDistrictThenByNameComparator = (c1, c2) -> {
        if (c1.getDistrict().compareTo(c2.getDistrict()) == 0) {
            return c1.getName().compareTo(c2.getName());
        }
        return c1.getDistrict().compareTo(c2.getDistrict());
    };
}
