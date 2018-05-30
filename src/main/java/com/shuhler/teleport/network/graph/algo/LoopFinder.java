package com.shuhler.teleport.network.graph.algo;


import com.shuhler.teleport.network.graph.Node;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class LoopFinder {

    public boolean hasLoop(Node rootNode) {
        Set<Node> visited = new HashSet<>();

        return depthFirstSearch(rootNode, visited, 0, rootNode);
    }


    private boolean depthFirstSearch(Node root, Set<Node> visitedNodes, int depth, Node target) {

        if (depth > 1 && root.getAdjacentNodes().contains(target)) {
            return true;
        }

        visitedNodes.add(root);

        Set<Node> unsearchedAdjecentNodes = root.getAdjacentNodes().stream()
                .filter(n -> !visitedNodes.contains(n)).collect(toSet());

        boolean foundLoop = false;

        for (Node node : unsearchedAdjecentNodes) {
            foundLoop = foundLoop || depthFirstSearch(node, visitedNodes, depth + 1, target);
        }

        return foundLoop;
    }

}
