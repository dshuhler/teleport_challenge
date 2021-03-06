package com.shuhler.teleport.network.graph.algo;

import com.shuhler.teleport.network.graph.Node;

import java.util.ArrayDeque;
import java.util.HashSet;

import static java.util.stream.Collectors.toSet;

public class SimpleConnectivity {

    public boolean areConnected(Node nodeA, Node nodeB) {

        var queue = new ArrayDeque<Node>();
        var visited = new HashSet<Node>();

        queue.add(nodeA);
        visited.add(nodeA);

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.getAdjacentNodes().contains(nodeB)) {
                return true;
            }

            var unvisitedAdjacentNodes = node.getAdjacentNodes().stream()
                    .filter(n -> !visited.contains(n)).collect(toSet());

            visited.addAll(unvisitedAdjacentNodes);
            queue.addAll(unvisitedAdjacentNodes);
        }
        return false;
    }

}
