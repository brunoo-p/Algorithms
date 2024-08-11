package com.algorithm.service;

import com.algorithm.entity.PositionsEnum;
import com.algorithm.entity.Recruiter;
import com.algorithm.entity.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RecruiterGraphService {

  private final HashMap<String, Vertex<Recruiter>> graph = new HashMap<>();
  private static final PositionsEnum stopPointCriteria = PositionsEnum.JAVA_DEVELOPER;

  private void addToHash(Recruiter recruiter, HashMap<String, Vertex<Recruiter>> graph) {
    if (!graph.containsKey(recruiter.getName())) {
      graph.put(recruiter.getName(), this.buildVertex(recruiter));
    }
  }

  private List<Vertex<Recruiter>> checkFriends(List<Recruiter> friends, HashMap<String, Vertex<Recruiter>> graph) {

    List<Vertex<Recruiter>> vertexNeighbors = new LinkedList<>();
    friends.forEach(friend -> {
      this.addToHash(friend, graph);
      vertexNeighbors.add(graph.get(friend.getName()));
    });
    return vertexNeighbors;
  }

  private Vertex<Recruiter> buildVertex(Recruiter recruiter) {
    return new Vertex<>(recruiter);
  }

  public HashMap<String, Vertex<Recruiter>> buildRecruiterGraph(List<Recruiter> list) {

    list.forEach(recruiter -> {
      this.addToHash(recruiter, graph);
      List<Vertex<Recruiter>> vertexNeighbors = this.checkFriends(recruiter.getFriends(), graph);
      graph.get(recruiter.getName()).setNeighbors(vertexNeighbors);
    });
    return graph;
  }

  public static boolean stopPointMethod(Recruiter data) {
    return data.getPositions().contains(stopPointCriteria);
  }
}
