package com.algorithm.service;

import com.algorithm.entity.*;

import java.util.*;

public class BreadthFirstSearch<T> {

  private final Vertex<T> startVertex;
  private final IStopPoint<T> stopPointMethod;

  public BreadthFirstSearch(Vertex<T> startVertex, IStopPoint<T> stopPointMethod) {
    this.startVertex = startVertex;
    this.stopPointMethod = stopPointMethod;
  }

  public VerticesDTO<T> traverse() {
    List<Vertex<T>> visitedVertex = new LinkedList<>();
    Queue<Vertex<T>> queue = new LinkedList<>();
    queue.add(startVertex);

    while (!queue.isEmpty()) {
      Vertex<T> current = queue.poll();
      if (!current.isVisited()) {
        if (stopPointMethod.check(current.getData())) return new VerticesDTO<>(current, visitedVertex);
        current.setVisited(true);
        visitedVertex.add(current);
        queue.addAll(current.getNeighbors());
      }
    }
    return new VerticesDTO<>(null, visitedVertex);
  }
}
