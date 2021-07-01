package book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan
@EnableAutoConfiguration
public class CountriesController {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CountriesController.class);
        RepOfCountry countries = context.getBean(RepOfCountry.class);
        RepOfRegion regions = context.getBean(RepOfRegion.class);
        RepOfCity cities = context.getBean(RepOfCity.class);


        Setter(countries, regions, cities)
                    .addCountry("Россия")
                    .addRegion("Московская область")
                    .addCity("Москва");
        Setter(countries, regions, cities)
                .addCountry("Россия")
                .addRegion("Ленинградская область")
                .addCity("Санкт-Петербург");
        Setter(countries, regions, cities)
                .addCountry("Россия")
                .addRegion("Вологодская область")
                .addCity("Вологда");
        for (Country country: countries.findAll()) {
            System.out.println(country.getName());
            for (Region region: country.getRegions()) {
                System.out.println(region.getName());
                for (City city: region.getCities()) {
                    System.out.println(city.getName());

                }
            }
        }

        context.close();
    }
    static class Setter {
        RepOfCountry countries;
        RepOfRegion regions;
        RepOfCity cities;

        public Setter(RepOfCountry countries, RepOfRegion regions, RepOfCity cities) {
            this.countries = countries;
            this.regions = regions;
            this.cities = cities;
        }

        public CountrySetter addCountry(String name) {
            return new CountrySetter(name);
        }

        class CountrySetter {
            Country country;

            CountrySetter(String name) {
                country = new Country(name);
                countries.save(country);
            }
            public RegionSetter addRegion(String name) {
                return new RegionSetter(this, name);
            }

            Setter add() {
                return Setter.this;
            }
        }

        class RegionSetter {
            Region region;
            CountrySetter Setter;
            RegionSetter(CountrySetter country, String name) {
                this.Setter = country;
                region = new Region(name, Setter.country);
                regions.save(region);
            }
            public RegionSetter addCity(String name) {
                City city = new City(name, region);
                cities.save(city);
                return this;
            }
            public CountrySetter add() {
                return Setter;
            }
        }
    }

    public static Setter Setter(RepOfCountry countries, RepOfRegion regions, RepOfCity cities) {
        return new Setter(countries, regions, cities);
    }
}
