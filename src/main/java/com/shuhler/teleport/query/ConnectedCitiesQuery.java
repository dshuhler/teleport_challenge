package com.shuhler.teleport.query;

import com.shuhler.teleport.model.TeleportNet;

import java.util.regex.Pattern;

public class ConnectedCitiesQuery extends TeleportQuery {

    protected static final Pattern PATTERN = Pattern.compile("^can I teleport from.*");

    public ConnectedCitiesQuery(String queryString) {
        super(queryString);
    }

    @Override
    String query(TeleportNet teleportNet) {

        String cityA = getParams().get(0);
        String cityB = getParams().get(1);

        boolean result = teleportNet.areConnected(cityA, cityB);

        return "Can I teleport from " + cityA + " to " + cityB + ": " + result;
    }
}
