/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.basic.graph.undirected;

/**
 *
 * @author rusakovich
 */
public abstract class AbstractGraph implements Graph {

    protected int vertices;
    protected int edges;

    public AbstractGraph(int vertices) {
        this.vertices = vertices;
    }

    @Override
    public int vertexCount() {
        return this.vertices;
    }

    @Override
    public int edgeCount() {
        return this.edges;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Vertices: [" + vertices + "], edges: [" + edges + "]\n");

        for (int v = 0; v < vertices; v++) {
            builder.append(v).append(": ");

            for (int w : this.adjacentVertices(v)) {
                builder.append(w).append(" ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

}
