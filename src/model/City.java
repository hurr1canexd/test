package model;

public class City {
    private final String name; // наименование города
    private final String region; // регион
    private final String district; // федеральный округ
    private final int population; // количество жителей города
    private final String foundation; // дата основания или первое упоминание


    // TODO: 12.05.2021 Make chechks
    public City(String[] fields) {
        this.name = fields[1];
        this.region = fields[2];
        this.district = fields[3];
        this.population = Integer.parseInt(fields[4]);
        this.foundation = fields[5];
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getFoundation() {
        return foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }
}
