package com.goriant.sharing.boundary_test_context.challenge.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class DirectedGraph {

    class Vertex {
        private String label;

        Vertex(String label) {
            this.label = label;
        }

        String getLabel() {
            return label;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            Vertex other = (Vertex) obj;

            if(!getOuterType().equals(other.getOuterType()))
                return false;

            if (label == null)
                if (other.label != null)
                    return false;
                else if (!label.equals(other.label))
                    return false;
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getLabel());
        }

        @Override
        public String toString() {
            return label;
        }

        private DirectedGraph getOuterType() {
            return DirectedGraph.this;
        }
    }

    private Map<Vertex, List<Vertex>> adjVertices;

    DirectedGraph() {
        this.adjVertices = new HashMap<>();
    }

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    /**
     * Adds the directed edge label1 -> label2 to this directed graph
     * @param label1 the tail vertex
     * @param label2 the head vertex
     */
    void addEdge(String label1, String label2) {
        Vertex tail = new Vertex(label1);
        Vertex head = new Vertex(label2);

//        adjVertices.get(v1).add(v2);
        adjVertices.get(tail).add(head);
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    String printGraph() {

        StringBuilder sb = new StringBuilder();

        for (DirectedGraph.Vertex v : adjVertices.keySet()) {
            sb.append(v);
            sb.append(adjVertices.get(v));
            sb.append("\n");
        }

        return sb.toString();
    }
}
