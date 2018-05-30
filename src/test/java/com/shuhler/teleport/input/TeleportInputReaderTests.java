package com.shuhler.teleport.input;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class TeleportInputReaderTests {

    @Test
    public void canReadPortals() {
        Path inputPath = Paths.get("src/test/resources/test_sample_input.txt");
        TeleportInputReader teleportInputReader = new TeleportInputReader(inputPath);
        var portalDefinitions = teleportInputReader.getPortals();

        assertThat(portalDefinitions).containsExactlyInAnyOrder(
                new PortalDefinition("Washington", "Baltimore"),
                new PortalDefinition("Washington", "Atlanta"),
                new PortalDefinition("Baltimore", "Philadelphia"),
                new PortalDefinition("Philadelphia", "New York"));
    }

}
