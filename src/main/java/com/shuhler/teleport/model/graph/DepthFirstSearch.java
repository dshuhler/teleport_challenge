package com.shuhler.teleport.model.graph;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class DepthFirstSearch {



    public Set<String> nodesWithinDistance(Graph graph, String startNodeName, int maxDepth) {

        Set<Node> visited = new HashSet<>();

        Node startNode = graph.getNodes().get(startNodeName);

        Set<Node> nodeResult = depthFirstSearch(startNode, visited, maxDepth);
        return nodeResult.stream().map(Node::getName).collect(toSet());

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
