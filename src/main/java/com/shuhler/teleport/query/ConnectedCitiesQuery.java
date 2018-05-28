package com.shuhler.teleport.query;

import com.shuhler.teleport.model.TeleportNet;

import java.util.regex.Pattern;

public class ConnectedCitiesQuery extends TeleportQuery {

    protected static final Pattern PATTERN = Pattern.compile("^can I teleport from.*");

    public ConnectedCitiesQuery(String inputLine) {

    }

    @Override
    String query(TeleportNet teleportNet) {
        return null;
    }

}
