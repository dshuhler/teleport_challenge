package com.shuhler.teleport.model;

import com.shuhler.teleport.input.Portal;
import com.shuhler.teleport.model.graph.ConnectednessStrategy;
import com.shuhler.teleport.model.graph.DepthFirstSearch;
import com.shuhler.teleport.model.graph.Graph;
import com.shuhler.teleport.model.graph.Node;

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

        Node cityA = netGraph.getNodes().get(cityNameA);
        Node cityB = netGraph.getNodes().get(cityNameB);

        return connectednessStrategy.areConnected(cityA, cityB);
    }

    public boolean hasLoop(String cityName) {
        return false;
    }

    private void addPortalToGraph(Portal portal) {
        netGraph.getNodes().putIfAbsent(portal.getCityA(), new Node(portal.getCityA()));
        netGraph.getNodes().putIfAbsent(portal.getCityB(), new Node(portal.getCityB()));

        Node cityA = netGraph.getNodes().get(portal.getCityA());
        Node cityB = netGraph.getNodes().get(portal.getCityB());

        cityA.addAdjacentNode(cityB);
        cityB.addAdjacentNode(cityA);
    }

}
