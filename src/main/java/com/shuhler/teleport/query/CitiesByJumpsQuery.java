package com.shuhler.teleport.query;

import com.shuhler.teleport.model.TeleportNet;

import java.util.*;
import java.util.regex.Pattern;

public class CitiesByJumpsQuery extends TeleportQuery {

    protected static final Pattern PATTERN = Pattern.compile("^cities in jumps:.*");

    public CitiesByJumpsQuery(String queryString) {
        super(queryString);
    }

    @Override
    String query(TeleportNet teleportNet) {

        String cityName = paramList().get(0);
        int jumps = Integer.parseInt(paramList().get(1));

        Set<String> linkedCities = teleportNet.findLinkedCities(cityName, jumps);

        // It's not required to sort the cities, but it makes the output consistent
        List<String> sortedLinkedCities = new ArrayList<>(linkedCities);
        Collections.sort(sortedLinkedCities);

        return "Cities from " + cityName + " in " + jumps + " jumps: " + String.join(", ", sortedLinkedCities);
    }
}
