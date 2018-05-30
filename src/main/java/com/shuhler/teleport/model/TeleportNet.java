package com.shuhler.teleport.model;

import com.shuhler.teleport.input.Portal;
import com.shuhler.teleport.model.graph.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class TeleportNet {

    private Graph netGraph = new Graph();

    public TeleportNet(List<Portal> portals) {
        portals.forEach(this::addPortalToGraph);
    }

    public Set<String> findLinkedCities(String cityName, int jumps) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        Set<Node> linkedCities = depthFirstSearch.nodesWithinDistance(netGraph, cityName, jumps);
        return linkedCities.stream().map(Node::getName).collect(toSet());
    }

    public boolean areConnected(String cityNameA, String cityNameB) {
        var connectednessStrategy = new ConnectednessStrategy();

        Node cityA = netGraph.getNode(cityNameA);
        Node cityB = netGraph.getNode(cityNameB);

        return connectednessStrategy.areConnected(cityA, cityB);
    }

    public boolean hasLoop(String cityName) {
        var loopFinder = new LoopFinder();
        return loopFinder.hasLoop(netGraph.getNode(cityName));
    }

    private void addPortalToGraph(Portal portal) {
        netGraph.getNodes().putIfAbsent(portal.getCityA(), new Node(portal.getCityA()));
        netGraph.getNodes().putIfAbsent(portal.getCityB(), new Node(portal.getCityB()));

        Node cityA = netGraph.getNode(portal.getCityA());
        Node cityB = netGraph.getNode(portal.getCityB());

        cityA.addAdjacentNode(cityB);
        cityB.addAdjacentNode(cityA);
    }

}
