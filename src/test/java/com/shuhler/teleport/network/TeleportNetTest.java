package com.shuhler.teleport.network;

import com.shuhler.teleport.input.PortalDefinition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TeleportNetTest {

    private static TeleportNet testNetwork;

    @BeforeAll
    private static void init() {
        var portals = List.of(
                new PortalDefinition("A", "B"),
                new PortalDefinition("A", "C"),
                new PortalDefinition("B", "C"),
                new PortalDefinition("B", "D"),
                new PortalDefinition("D", "F"),
                new PortalDefinition("F", "H"),
                new PortalDefinition("D", "E"));

        testNetwork = new TeleportNet(portals);
    }

    @Test
    public void testZeroJumpLinkedCities() {
        assertThat(testNetwork.findLinkedCities("A", 0)).isEmpty();
        assertThat(testNetwork.findLinkedCities("E", 0)).isEmpty();
    }

    @Test
    public void testOneJumpLinkedCities() {
        assertThat(testNetwork.findLinkedCities("A", 1)).containsExactly("B", "C");
        assertThat(testNetwork.findLinkedCities("E", 1)).containsExactly("D");
    }

    @Test
    public void testMultiJumpLinkedCities() {
        assertThat(testNetwork.findLinkedCities("A", 3)).containsExactly("B", "C", "D", "E", "F");
        assertThat(testNetwork.findLinkedCities("E", 3)).containsExactly("A", "B", "C", "D", "F", "H");
    }
}
