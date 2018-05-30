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
        Path path = Paths.get("src/test/resources/portalDefinitions.txt");
        TeleportInputReader teleportInputReader = new TeleportInputReader(path);

        List<PortalDefinition> portalDefinitions = teleportInputReader.getPortals();

        assertEquals(4, portalDefinitions.size());
        assertTrue(portalDefinitions.contains(new PortalDefinition("Washington", "Baltimore")));
        assertTrue(portalDefinitions.contains(new PortalDefinition("Washington", "Atlanta")));
        assertTrue(portalDefinitions.contains(new PortalDefinition("Baltimore", "Philadelphia")));
        assertTrue(portalDefinitions.contains(new PortalDefinition("Philadelphia", "New York")));
    }

}
