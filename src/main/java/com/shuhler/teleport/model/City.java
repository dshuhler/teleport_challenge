package com.shuhler.teleport.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class City {

  private String name;
  private Set<City> adjecentCities = new HashSet<>();
  private boolean searched = false;

  public City(String name) {
    this.name = name;
  }

  public void addPortalLink(City linkedCity) {
    adjecentCities.add(linkedCity);
  }

  public String getName() {
    return name;
  }

  public void setSearched(boolean searched) {
    this.searched = searched;
  }

  public boolean isSearched() {
    return searched;
  }

  public Set<String> getLinkedCities(int jumps) {
    searched = true;

    if (jumps <= 0) {
      return Collections.emptySet();
    }

    Set<City> unsearchedAdjecentCities = getUnsearchedAdjecentCities();

    Set<String> linkedCityNames = unsearchedAdjecentCities.stream().map(City::getName).collect(Collectors.toSet());

    for (City adjecentCity : unsearchedAdjecentCities) {
      linkedCityNames.addAll(adjecentCity.getLinkedCities(jumps - 1));
    }

    return linkedCityNames;
  }

  public boolean isConnectedTo(String cityName) {
    searched = true;

    if (getUnsearchedAdjecentCities().contains(new City(cityName))) {
      return true;
    } else {
      for (City adjecentCity : getUnsearchedAdjecentCities()) {
        if (adjecentCity.isConnectedTo(cityName)) {
          return true;
        }
      }
    }

    return false;
  }


  private Set<City> getUnsearchedAdjecentCities() {
    return adjecentCities.stream()
            .filter(c -> !c.isSearched())
            .collect(Collectors.toSet());
  }

  @Override
  public String toString() {
    return "City{" +
            "name='" + name + '\'' +
            ", searched=" + searched +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    City city = (City) o;
    return Objects.equals(name, city.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
