package com.shuhler.teleport.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class City {

  private String name;
  private Set<City> adjecentCities = new HashSet<>();

  public City(String name) {
    this.name = name;
  }

  public void addPortalLink(City linkedCity) {
    adjecentCities.add(linkedCity);
  }

  public String getName() {
    return name;
  }

  public List<String> getLinkedCities(int jumps) {

    if (jumps <= 0) {
      return Collections.emptyList();
    }

    List<String> linkedCityNames = adjecentCities.stream().map(City::getName).collect(Collectors.toList());

    for (City adjecentCity : adjecentCities) {
      linkedCityNames.addAll(adjecentCity.getLinkedCities(jumps - 1));
    }

    return linkedCityNames;
  }


}
