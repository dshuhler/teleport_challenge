package com.shuhler.teleport.network;

import com.shuhler.teleport.input.PortalDefinition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NetworkConnectednessTest {

    private static TeleportNet testNetwork;

    @BeforeAll
    private static void init() {

        var portals = List.of(
                new PortalDefinition("A", "B"),
                new PortalDefinition("B", "C"),
                new PortalDefinition("A", "C"),
                new PortalDefinition("B", "C"),
                new PortalDefinition("C", "D"),
                new PortalDefinition("D", "DD"),
                new PortalDefinition("D", "E"),
                new PortalDefinition("E", "F"),
                new PortalDefinition("DD", "F"),
                new PortalDefinition("X", "Y")); //add some cities disconnected from other networks

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
