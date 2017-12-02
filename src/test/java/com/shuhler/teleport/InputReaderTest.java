package com.shuhler.teleport;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class InputReaderTest {

  @Test
  public void testPortalRead() {
    Path path = Paths.get("src/test/resources/portals.txt");
    InputReader inputReader = new InputReader(path);

    List<Portal> portals = inputReader.getPortals();

    assertEquals(4, portals.size());
    assertTrue(portals.contains(new Portal("Washington", "Baltimore")));
    assertTrue(portals.contains(new Portal("Washington", "Atlanta")));
    assertTrue(portals.contains(new Portal("Baltimore", "Philadelphia")));
    assertTrue(portals.contains(new Portal("Philadelphia", "New York")));
  }









}
