package com.shuhler.teleport.input;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TeleportInputReaderTests {

    @Test
    public void testPortalRead() {
        Path path = Paths.get("src/test/resources/portals.txt");
        TeleportInputReader teleportInputReader = new TeleportInputReader(path);

        List<Portal> portals = teleportInputReader.getPortals();

        assertEquals(4, portals.size());
        assertTrue(portals.contains(new Portal("Washington", "Baltimore")));
        assertTrue(portals.contains(new Portal("Washington", "Atlanta")));
        assertTrue(portals.contains(new Portal("Baltimore", "Philadelphia")));
        assertTrue(portals.contains(new Portal("Philadelphia", "New York")));
    }

}
