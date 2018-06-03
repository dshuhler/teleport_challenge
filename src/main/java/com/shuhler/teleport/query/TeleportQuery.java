package com.shuhler.teleport.query;

import com.shuhler.teleport.network.TeleportNet;

import java.util.List;
import java.util.Optional;


public abstract class TeleportQuery {

    private String queryString;

    // If more query types are going to be added, I'd move this logic to its own class and consider
    // using a custom annotation to associate the regex pattern with the query.

    public static Optional<TeleportQuery> buildQuery(String inputLine) {

        TeleportQuery query = null;

        if (CitiesByJumpsQuery.PATTERN.matcher(inputLine).matches()) {
            query =  new CitiesByJumpsQuery(inputLine);
        } else if (ConnectedCitiesQuery.PATTERN.matcher(inputLine).matches()) {
            query =  new ConnectedCitiesQuery(inputLine);
        } else if (LoopQuery.PATTERN.matcher(inputLine).matches()) {
            query = new LoopQuery(inputLine);
        }

        return Optional.ofNullable(query);
    }

    public TeleportQuery(String queryString) {
        this.queryString = queryString;
    }

    protected List<String> getParams() {
        String queryParams = queryString.substring(queryString.indexOf(':') + 2);
       return List.of(queryParams.split(", "));
    }

    public abstract String query(TeleportNet teleportNet);
}
