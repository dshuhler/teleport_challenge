package com.shuhler.teleport.model;

import com.shuhler.teleport.input.Portal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TeleportNet {

    private Map<String, City> cityMap = new HashMap<>();


    public TeleportNet(List<Portal> portals) {
        portals.forEach(this::addPortalToNetwork);
    }

    public Set<String> findLinkedCities(String cityName, int jumps) {
        resetSearchFlags();
        City rootCity = cityMap.get(cityName);
        return rootCity.getLinkedCities(jumps);
    }

    public boolean areConnected(String cityNameA, String cityNameB) {
        resetSearchFlags();
        City rootCity = cityMap.get(cityNameA);
        return rootCity.isConnectedTo(cityNameB);
    }


    private void addPortalToNetwork(Portal portal) {

        cityMap.putIfAbsent(portal.getCityA(), new City(portal.getCityA()));
        cityMap.putIfAbsent(portal.getCityB(), new City(portal.getCityB()));

        City cityA = cityMap.get(portal.getCityA());
        City cityB = cityMap.get(portal.getCityB());

        cityA.addPortalLink(cityB);
        cityB.addPortalLink(cityA);

    }


    private void resetSearchFlags() {
        cityMap.values().forEach(c -> c.setSearched(false));
    }


}