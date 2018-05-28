package com.shuhler.teleport.query;

import com.shuhler.teleport.model.TeleportNet;

import java.util.regex.Pattern;

public class LoopQuery extends TeleportQuery {

    protected static final Pattern PATTERN = Pattern.compile("^loop possible from.*");

    public LoopQuery(String queryString) {
        super(queryString);
    }

    @Override
    String query(TeleportNet teleportNet) {
        return null;
    }
}
