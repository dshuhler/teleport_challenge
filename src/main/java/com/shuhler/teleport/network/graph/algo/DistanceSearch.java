package com.shuhler.teleport.network.graph.algo;

import com.shuhler.teleport.network.graph.Graph;
import com.shuhler.teleport.network.graph.Node;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class DistanceSearch {

    public Set<Node> nodesWithinDistance(Graph graph, String startNodeName, int maxDepth) {
        Node startNode = graph.getNodes().get(startNodeName);
        return breadthFirstSearch(startNode, maxDepth);
    }

    private Set<Node> breadthFirstSearch(Node root, int maxDepth) {

        var nodeQueue = new ArrayDeque<Node>();
        var depthQueue = new ArrayDeque<Integer>();
        var visited = new HashSet<Node>();

        nodeQueue.add(root);
        depthQueue.add(0);
        visited.add(root);

        while(!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            Integer depth = depthQueue.poll();

            if (depth < maxDepth) {

                var unvisitedAdjacentNodes = node.getAdjacentNodes().stream()
                        .filter(n -> !visited.contains(n)).collect(toSet());

                for (Node adjacentNode: unvisitedAdjacentNodes) {
                    visited.add(adjacentNode);
                    nodeQueue.add(adjacentNode);
                    depthQueue.add(depth + 1);
                }
            }
        }

        visited.remove(root);

        return visited;
    }

}
