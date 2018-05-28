package com.shuhler.teleport.query;

import com.shuhler.teleport.model.TeleportNet;

import java.util.List;
import java.util.regex.Pattern;

public abstract class TeleportQuery {

    private String queryString;

    public static TeleportQuery buildQuery(String inputLine) {

        if (CitiesByJumpsQuery.PATTERN.matcher(inputLine).matches()) {
            return new CitiesByJumpsQuery(inputLine);
        } else if (ConnectedCitiesQuery.PATTERN.matcher(inputLine).matches()) {
            return new ConnectedCitiesQuery(inputLine);
        } else if (LoopQuery.PATTERN.matcher(inputLine).matches()) {
            return new LoopQuery(inputLine);
        }

        //throw exception?
        return null;
    }

    public TeleportQuery(String queryString) {
        this.queryString = queryString;
    }

    protected List<String> getParams() {
        String queryParams = queryString.substring(queryString.indexOf(":") + 2);
       return List.of(queryParams.split(", "));
    }

    abstract String query(TeleportNet teleportNet);
}
