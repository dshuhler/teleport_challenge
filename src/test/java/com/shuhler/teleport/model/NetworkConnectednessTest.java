package com.shuhler.teleport.model;

import com.shuhler.teleport.Portal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NetworkConnectednessTest {

  private TeleportationNetwork testNetwork;

  @BeforeEach
  public void init() {
    List<Portal> portals = new ArrayList<>();

    portals.add(new Portal("A", "B"));
    portals.add(new Portal("C", "D"));

    testNetwork = new TeleportationNetwork(portals);
  }


  @Test
  public void twoAdjacentCitiesConnected() {
    assertTrue(testNetwork.areConnected("A", "B"));
  }

  @Test
  public void citiesNotConnected() {
    assertFalse(testNetwork.areConnected("A", "C"));
  }



}
