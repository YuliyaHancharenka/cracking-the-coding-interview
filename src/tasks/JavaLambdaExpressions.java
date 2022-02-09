package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JavaLambdaExpressions {
    //13.7 p.168
    public static void main(String[] args) {
        Country usa = new Country(332000000, "North America");
        Country uk = new Country(68000000, "Europe");
        Country poland = new Country(38000000, "Europe");
        Country canada = new Country(38000000, "North America");
        List<Country> countries = new ArrayList<>();
        countries.add(usa);
        countries.add(uk);
        countries.add(poland);
        countries.add(canada);

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

