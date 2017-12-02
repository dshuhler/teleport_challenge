package com.shuhler.teleport.model;

import com.shuhler.teleport.Portal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeleportationNetwork {

  private Map<String, City> cityMap = new HashMap<>();


  public TeleportationNetwork(List<Portal> portals) {
    portals.forEach(this::addPortalToNetwork);
  }

  public List<String> findLinkedCities(String cityName, int jumps) {

    City rootCity = cityMap.get(cityName);

    return rootCity.getLinkedCities(jumps);

  }


  private void addPortalToNetwork(Portal portal) {

    cityMap.putIfAbsent(portal.getCityA(), new City(portal.getCityA()));
    cityMap.putIfAbsent(portal.getCityB(), new City(portal.getCityB()));

    City cityA = cityMap.get(portal.getCityA());
    City cityB = cityMap.get(portal.getCityB());

    cityA.addPortalLink(cityB);
    cityB.addPortalLink(cityA);

  }





}
