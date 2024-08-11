package com.algorithm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class VerticesDTO<T> {
  private Vertex<T> stopPointVertex;
  private List<Vertex<T>> visitedVertex = new LinkedList<>();

  @Override
  public String toString() {
    var data = stopPointVertex.getData();
    return "VerticesDTO{" +
      "\n stopPointVertex= " + stopPointVertex.getData() +
      ", \n visitedVertex=" + visitedVertex.stream().map(Vertex::getData).toList() +
    "}";
  }
}