package com.shuhler.teleport.query;

import com.shuhler.teleport.model.TeleportNet;

import java.util.regex.Pattern;

public abstract class TeleportQuery {


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


    abstract String query(TeleportNet teleportNet);
}
