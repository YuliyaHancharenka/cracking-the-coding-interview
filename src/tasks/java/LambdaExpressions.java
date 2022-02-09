package tasks.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaExpressions {
    //13.7 p.168
    public static void main(String[] args) {
        List<Country> countries = Arrays.asList(
                new Country(332000000, "North America"),
                new Country(68000000, "Europe"),
                new Country(38000000, "Europe"),
                new Country(38000000, "North America")
                );

        System.out.println(getPopulation(countries, "Europe"));

    }

    private static int getPopulation(List<Country> countries, String continent) {
        Stream<Integer> populations = countries.stream().map(c -> c.getContinent().equals(continent) ? c.getPopulation() : 0);
        return populations.reduce(0, Integer::sum);
    }

    private static class Country {
        int population;
        String continent;

        public Country(int population, String continent) {
            this.population = population;
            this.continent = continent;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public String getContinent() {
            return continent;
        }

        public void setContinent(String continent) {
            this.continent = continent;
        }
    }

}

