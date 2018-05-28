package com.shuhler.teleport.graph;

import java.util.Set;

public class Node {
    private String name;
    private Set<Node> adjacentNodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Set<Node> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}
