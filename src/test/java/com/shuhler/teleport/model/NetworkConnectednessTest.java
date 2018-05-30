package com.shuhler.teleport.model;

import com.shuhler.teleport.input.Portal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NetworkConnectednessTest {

    private static TeleportNet testNetwork;

    @BeforeAll
    private static void init() {

        var portals = List.of(
                new Portal("A", "B"),
                new Portal("B", "C"),
                new Portal("C", "D"),
                new Portal("D", "DD"),
                new Portal("D", "E"),
                new Portal("E", "F"),
                new Portal("X", "Y")); //add some cities disconnected from other networks

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
