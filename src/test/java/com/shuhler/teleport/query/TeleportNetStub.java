package com.shuhler.teleport.query;

import com.shuhler.teleport.input.Portal;
import com.shuhler.teleport.model.TeleportNet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeleportNetStub extends TeleportNet {

    public TeleportNetStub(List<Portal> portals) {
        super(portals);
    }

    @Override
    public Set<String> findLinkedCities(String cityName, int jumps) {
        return new HashSet<>(Arrays.asList("Boston", "Portland"));
    }

}
