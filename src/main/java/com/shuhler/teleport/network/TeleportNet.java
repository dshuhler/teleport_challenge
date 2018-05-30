package com.shuhler.teleport.network;

import com.shuhler.teleport.input.PortalDefinition;
import com.shuhler.teleport.network.graph.*;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class TeleportNet {

    private Graph netGraph = new Graph();

    public TeleportNet(List<PortalDefinition> portalDefinitions) {
        portalDefinitions.forEach(this::addPortalToGraph);
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

    private void addPortalToGraph(PortalDefinition portalDefinition) {
        netGraph.getNodes().putIfAbsent(portalDefinition.getCityA(), new Node(portalDefinition.getCityA()));
        netGraph.getNodes().putIfAbsent(portalDefinition.getCityB(), new Node(portalDefinition.getCityB()));

        Node cityA = netGraph.getNode(portalDefinition.getCityA());
        Node cityB = netGraph.getNode(portalDefinition.getCityB());

        cityA.addAdjacentNode(cityB);
        cityB.addAdjacentNode(cityA);
    }

}
