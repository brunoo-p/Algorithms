package com.algorithm.entity;

import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Vertex<T> {

  private T data;
  private boolean visited;
  private List<Vertex<T>> neighbors = new LinkedList<>();

  public Vertex(T data, List<Vertex<T>>neighbors) {
    this.data = data;
    this.visited = false;
    this.neighbors.addAll(neighbors);
  }
  public Vertex(T data) {
    this.data = data;
    this.visited = false;
  }
}
