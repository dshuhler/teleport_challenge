package com.shuhler.teleport.query;

import com.shuhler.teleport.network.TeleportNet;

import java.util.regex.Pattern;

public class LoopQuery extends TeleportQuery {

    static final Pattern PATTERN = Pattern.compile("^loop possible:.*");

    public LoopQuery(String queryString) {
        super(queryString);
    }

    @Override
    public String query(TeleportNet teleportNet) {
        String cityName = getParams().get(0);
        boolean result = teleportNet.hasLoop(cityName);
        return "Loop possible from " + cityName + ": " + result;
    }
}
