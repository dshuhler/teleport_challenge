package com.shuhler.teleport.model;

import com.shuhler.teleport.Portal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TeleportationNetworkTest {

  private TeleportationNetwork testNetwork;

  @BeforeEach
  public void init() {
    List<Portal> portals = new ArrayList<>();

    portals.add(new Portal("A", "B"));
    portals.add(new Portal("A", "C"));
    portals.add(new Portal("B", "C"));
    portals.add(new Portal("B", "D"));
    portals.add(new Portal("D", "F"));
    portals.add(new Portal("F", "H"));
    portals.add(new Portal("D", "E"));

    testNetwork = new TeleportationNetwork(portals);
  }


  @Test
  public void testZeroJumpLinkedCities() {
    assertEquals(0, testNetwork.findLinkedCities("A", 0).size());
  }

  @Test
  public void testOneJumpLinkedCities() {
    Set<String> linkedCityNames = testNetwork.findLinkedCities("A", 1);

    assertEquals(2, linkedCityNames.size());
    assertTrue(linkedCityNames.contains("B"));
    assertTrue(linkedCityNames.contains("C"));
  }

  @Test
  public void testMultiJumpLinkedCities() {
    Set<String> linkedCityNames = testNetwork.findLinkedCities("A", 3);

    assertEquals(5, linkedCityNames.size());
    assertTrue(linkedCityNames.contains("B"));
    assertTrue(linkedCityNames.contains("C"));
    assertTrue(linkedCityNames.contains("D"));
    assertTrue(linkedCityNames.contains("E"));
    assertTrue(linkedCityNames.contains("F"));
  }

  @Test
  public void testTwoQueriesOnSameNetwork() {
    //this will fail if the implementation uses flags to track what nodes have been searched but fails to reset them
    testNetwork.findLinkedCities("A", 2);
    Set<String> linkedCityNames = testNetwork.findLinkedCities("A", 3);

    System.out.println(linkedCityNames);

    assertEquals(5, linkedCityNames.size());
    assertTrue(linkedCityNames.contains("B"));
    assertTrue(linkedCityNames.contains("C"));
    assertTrue(linkedCityNames.contains("D"));
    assertTrue(linkedCityNames.contains("E"));
    assertTrue(linkedCityNames.contains("F"));
  }


}
