package hu.webvalto.rest;

public class Country {

    private String id;
    private String name;
    private String currency;
    private String capital;
    private String population;

    public Country(String id, String name, String currency, String capital, String population) {
        this.name = name;
        this.currency = currency;
        this.capital = capital;
        this.population = population;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }
}
