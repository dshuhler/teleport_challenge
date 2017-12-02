package com.shuhler.teleport.model;

import java.util.Collections;
import java.util.HashSet;
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

  public boolean isSearched() {
    return searched;
  }

  public Set<String> getLinkedCities(int jumps) {

    searched = true;

    if (jumps <= 0) {
      return Collections.emptySet();
    }

    Set<City> unSearchedCities = adjecentCities.stream().filter(c -> !c.isSearched()).collect(Collectors.toSet());

    Set<String> linkedCityNames = unSearchedCities.stream().map(City::getName).collect(Collectors.toSet());

    for (City adjecentCity : unSearchedCities) {
        linkedCityNames.addAll(adjecentCity.getLinkedCities(jumps - 1));
    }

    return linkedCityNames;
  }


}
