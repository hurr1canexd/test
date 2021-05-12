package service;

import model.City;

import java.util.Comparator;
import java.util.List;

public class Sorter {
    private Comparator<City> comparator;

    public void setComparator(Comparator<City> comparator) {
        this.comparator = comparator;
    }

    public void sort(List<City> list) {
        list.sort(comparator);
    }
}
