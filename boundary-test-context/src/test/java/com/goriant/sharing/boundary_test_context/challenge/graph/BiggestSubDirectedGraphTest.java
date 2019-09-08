package com.goriant.sharing.boundary_test_context.challenge.graph;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("Biggest sub graph challenge")
class BiggestSubDirectedGraphTest {

    @Nested
    @DisplayName("#New DirectedGraph")
    class WhenNewDirectedGraph {

        @Test
        @DisplayName("Should return new instance")
        void graph_add_vertex() throws Exception {
            DirectedGraph directedGraph = new DirectedGraph();
            assertThat(directedGraph).isNotNull();
        }
    }

    @Nested
    @DisplayName("#addEdge")
    class TestAddEdge {

        private DirectedGraph directedGraph;

        @BeforeEach
        void setup() {
            directedGraph = new DirectedGraph();
        }

        @Nested
        @DisplayName("When user add one edge")
        class AddOneEdge {

            @Test
            @DisplayName("Vertex number should equal one")
            void add_new_edge() throws Exception {

                // given
                directedGraph.addVertex("A");
                directedGraph.addVertex("B");
                directedGraph.addEdge("A", "B");


                // when
                List<DirectedGraph.Vertex> vertices = directedGraph.getAdjVertices("A");

                // then
                assertThat(vertices.size()).isEqualTo(1);
            }
        }

        @Nested
        @DisplayName("When user add two edges")
        class AddTwoEdges {

            @Test
            @DisplayName("Vertices number should equals two")
            void add_two_edge() throws Exception {

                // given
                directedGraph.addVertex("A");
                directedGraph.addVertex("B");
                directedGraph.addVertex("C");
                directedGraph.addEdge("A", "B");
                directedGraph.addEdge("A", "C");


                // when
                List<DirectedGraph.Vertex> vertices = directedGraph.getAdjVertices("A");

                // then
                assertThat(vertices.size()).isEqualTo(2);
            }
        }
    }

    @Nested
    @DisplayName("Given a Graph such as Problem/Challenge")
    class GivenDirectedGraph {
        private DirectedGraph directedGraph;

        @BeforeEach
        void setup() {
            directedGraph = new DirectedGraph();

            directedGraph.addVertex("A");
            directedGraph.addVertex("B");
            directedGraph.addVertex("C");
            directedGraph.addVertex("D");
            directedGraph.addVertex("E");
            directedGraph.addVertex("F");

            directedGraph.addEdge("B", "D");
            directedGraph.addEdge("D", "E");
            directedGraph.addEdge("E", "F");
            directedGraph.addEdge("B", "C");
            directedGraph.addEdge("C", "F");
        }

        @Nested
        @DisplayName("#printGraph")
        class PrintDirectedGraph {
            @Test
            @DisplayName("Print given directedGraph")
            void print_graph() throws Exception {

                String rendered = directedGraph.printGraph();

                assertThat(rendered).containsSubsequence("A");
                assertThat(rendered).containsSubsequence("B[D, C]");
                assertThat(rendered).containsSubsequence("C[F]");
                assertThat(rendered).containsSubsequence("D[E]");
                assertThat(rendered).containsSubsequence("E[F]");
                assertThat(rendered).containsSubsequence("F");
            }
        }

        @Nested
        @DisplayName("#GraphTraversal.depthFirstTraversal")
        class DepthFirstSearch {

            @Test
            void depthFirstTraversal_given_start_node_B() throws Exception {

                Set<String> subGraph = GraphTraversal.depthFirstTraversal(directedGraph, "B");

                assertThat(subGraph).containsExactly("B", "C", "F", "D", "E");
            }


            @Test
            void depthFirstTraversal_given_start_node_D() throws Exception {

                Set<String> subGraph = GraphTraversal.depthFirstTraversal(directedGraph, "D");

                assertThat(subGraph).containsExactly("D", "E", "F");
            }
        }

        @Nested
        @DisplayName("#GraphTraversal.breadthFirstTraversal")
        class BreadthFirstSearch {

            @Test
            void breadthFirstTraversal_given_start_node_B() throws Exception {

                Set<String> subGraph = GraphTraversal.breadthFirstTraversal(directedGraph, "B");

                assertThat(subGraph).containsExactly("B", "D", "C", "E", "F");
            }

            @Test
            void depthFirstTraversal_given_start_node_D() throws Exception {

                Set<String> subGraph = GraphTraversal.breadthFirstTraversal(directedGraph, "D");

                assertThat(subGraph).containsExactly("D", "E", "F");
            }
        }
    }
}
