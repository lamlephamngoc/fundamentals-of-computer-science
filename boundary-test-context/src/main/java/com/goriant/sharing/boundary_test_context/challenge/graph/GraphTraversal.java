package com.goriant.sharing.boundary_test_context.challenge.graph;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class GraphTraversal {

    static Set<String> depthFirstTraversal(DirectedGraph directedGraph, String startNode) {

        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {

            String vertex = stack.pop();

            if (!visited.contains(vertex)) {
                visited.add(vertex);

                for (DirectedGraph.Vertex v : directedGraph.getAdjVertices(vertex))
                    stack.push(v.getLabel());

            }
        }

        return visited;
    }

    static Set<String> breadthFirstTraversal(DirectedGraph directedGraph, String startNode) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();

            for (DirectedGraph.Vertex v : directedGraph.getAdjVertices(vertex)) {
                if (!visited.contains(v.getLabel())) {
                    visited.add(v.getLabel());
                    queue.add(v.getLabel());
                }
            }
        }

        return visited;
    }
}
