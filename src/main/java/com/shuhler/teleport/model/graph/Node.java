package com.shuhler.teleport.model.graph;

import java.util.HashSet;
import java.util.Set;

public class Node {
    private String name;
    private Set<Node> adjacentNodes = new HashSet<>();

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void addAdjacentNode(Node node) {
        adjacentNodes.add(node);
    }
}
