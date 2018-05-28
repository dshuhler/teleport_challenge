package com.shuhler.teleport.query;

import com.shuhler.teleport.model.TeleportNet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CitiesByJumpsQuery extends TeleportQuery {

    protected static final Pattern PATTERN = Pattern.compile("^cities from.*");

    private String queryString;

    public CitiesByJumpsQuery(String queryString) {
        this.queryString = queryString;
    }

    @Override
    String query(TeleportNet teleportNet) {

        List<String> myList = new ArrayList<>(Arrays.asList(queryString.split(" ")));

        String cityName = myList.get(2);
        int jumps = Integer.parseInt(myList.get(4));

        Set<String> linkedCities = teleportNet.findLinkedCities(cityName, jumps);

        return queryString + ": " + String.join(",", linkedCities);
    }
}
