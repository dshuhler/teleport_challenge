package com.shuhler.teleport.model;

import com.shuhler.teleport.input.Portal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NetworkConnectednessTest {

    private TeleportNet testNetwork;

    @BeforeEach
    public void init() {
        List<Portal> portals = new ArrayList<>();

        //create connected network
        portals.add(new Portal("A", "B"));
        portals.add(new Portal("B", "C"));
        portals.add(new Portal("C", "D"));
        portals.add(new Portal("D", "E"));
        portals.add(new Portal("E", "F"));

        //add some cities disconnected from other networks
        portals.add(new Portal("X", "Y"));

        testNetwork = new TeleportNet(portals);
    }

    @Test
    public void twoAdjacentCitiesConnected() {
        assertTrue(testNetwork.areConnected("A", "B"));
        assertTrue(testNetwork.areConnected("B", "A"));
    }

    @Test
    public void distantCitiesConnected() {
        assertTrue(testNetwork.areConnected("A", "C"));
        assertTrue(testNetwork.areConnected("A", "F"));
        assertTrue(testNetwork.areConnected("F", "A"));
    }

    @Test
    public void citiesNotConnected() {
        assertFalse(testNetwork.areConnected("A", "X"));
    }

}
