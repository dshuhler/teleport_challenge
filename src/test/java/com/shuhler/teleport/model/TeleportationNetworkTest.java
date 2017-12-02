package com.shuhler.teleport.model;

import com.shuhler.teleport.Portal;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TeleportationNetworkTest {

  @Test
  public void testCloseLinkedCities() {

    List<Portal> portals = new ArrayList<>();

    portals.add(new Portal("A", "B"));
    portals.add(new Portal("A", "C"));
    portals.add(new Portal("B", "BA"));
    portals.add(new Portal("B", "BB"));

    TeleportationNetwork testNetwork = new TeleportationNetwork(portals);

    assertEquals(2, testNetwork.findLinkedCities("A", 1).size());

  }


}
