package com.shuhler.teleport.query;

import com.shuhler.teleport.model.TeleportNet;

import java.util.List;
import java.util.regex.Pattern;

public class ConnectedCitiesQuery extends TeleportQuery {

    protected static final Pattern PATTERN = Pattern.compile("^can I teleport from.*");

    private String queryString;

    public ConnectedCitiesQuery(String queryString) {
        this.queryString = queryString;
    }

    @Override
    String query(TeleportNet teleportNet) {
        String queryParams = queryString.substring(queryString.indexOf(":") + 2);
        List<String> myList = List.of(queryParams.split(", "));

        String cityA = myList.get(0);
        String cityB = myList.get(1);

        boolean result = teleportNet.areConnected(cityA, cityB);

        return "Can I teleport from " + cityA + " to " + cityB + ": " + result;
    }

}
