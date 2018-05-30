package com.shuhler.teleport.model.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {

    private Map<String, Node> nodes = new HashMap<>();

    public Map<String, Node> getNodes() {
        return nodes;
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

}
