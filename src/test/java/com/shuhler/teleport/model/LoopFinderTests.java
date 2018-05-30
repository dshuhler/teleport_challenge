package com.shuhler.teleport.model;

import com.shuhler.teleport.input.PortalDefinition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoopFinderTests {

    private static TeleportNet testNetwork;

    @BeforeAll
    private static void init() {

        var portals = List.of(
                new PortalDefinition("A", "B"),
                new PortalDefinition("B", "C"),
                new PortalDefinition("C", "A"),
                new PortalDefinition("B", "DD"),
                new PortalDefinition("DD", "EE"),
                new PortalDefinition("DD", "FF"),
                new PortalDefinition("EE", "GG"),
                new PortalDefinition("GG", "HH"));

        testNetwork = new TeleportNet(portals);
    }

    @Test
    public void canFindLoop() {
        assertTrue(testNetwork.hasLoop("A"));
        assertTrue(testNetwork.hasLoop("B"));
    }

    @Test
    public void findsNoLoops() {
        assertFalse(testNetwork.hasLoop("DD"));
        assertFalse(testNetwork.hasLoop("EE"));
        assertFalse(testNetwork.hasLoop("FF"));
    }

}
