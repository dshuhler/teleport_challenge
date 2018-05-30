package com.shuhler.teleport.query;

import com.shuhler.teleport.network.TeleportNet;

import java.util.List;


public abstract class TeleportQuery {

    private String queryString;

    // If more query types are going to be added, I'd move this logic to its own class and consider
    // using a custom annotation to associate the regex pattern with the query.

    public static TeleportQuery buildQuery(String inputLine) {

        if (CitiesByJumpsQuery.PATTERN.matcher(inputLine).matches()) {
            return new CitiesByJumpsQuery(inputLine);
        } else if (ConnectedCitiesQuery.PATTERN.matcher(inputLine).matches()) {
            return new ConnectedCitiesQuery(inputLine);
        } else if (LoopQuery.PATTERN.matcher(inputLine).matches()) {
            return new LoopQuery(inputLine);
        }

        return null;
    }

    public TeleportQuery(String queryString) {
        this.queryString = queryString;
    }

    protected List<String> getParams() {
        String queryParams = queryString.substring(queryString.indexOf(":") + 2);
       return List.of(queryParams.split(", "));
    }

    abstract public String query(TeleportNet teleportNet);
}
