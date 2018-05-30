package com.shuhler.teleport.network.graph;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class DepthFirstSearch {

    public Set<Node> nodesWithinDistance(Graph graph, String startNodeName, int maxDepth) {
        Set<Node> visited = new HashSet<>();
        Node startNode = graph.getNodes().get(startNodeName);
        return depthFirstSearch(startNode, visited, maxDepth);
    }

    private Set<Node> depthFirstSearch(Node root, Set<Node> visitedNodes, int maxDepth) {
        visitedNodes.add(root);

        if (maxDepth == 0) {
            return Collections.emptySet();
        }

        Set<Node> unsearchedAdjecentNodes = root.getAdjacentNodes().stream()
                .filter(n -> !visitedNodes.contains(n)).collect(toSet());

        Set<Node> allChildNodes = new HashSet<>(unsearchedAdjecentNodes);

        for (Node node : unsearchedAdjecentNodes) {
            allChildNodes.addAll(depthFirstSearch(node, visitedNodes, maxDepth - 1));
        }

        return allChildNodes;
    }


}
