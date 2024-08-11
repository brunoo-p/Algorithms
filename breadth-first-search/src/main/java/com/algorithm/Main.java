package com.algorithm;

import com.algorithm.builderMock.RecruiterMock;
import com.algorithm.entity.*;
import com.algorithm.service.BreadthFirstSearch;
import com.algorithm.service.RecruiterGraphService;

import java.util.HashMap;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<Recruiter> recruiterList = new RecruiterMock().getRecruiters();
    RecruiterGraphService graphService = new RecruiterGraphService();
    HashMap<String, Vertex<Recruiter>> recruiterGraph = graphService.buildRecruiterGraph(recruiterList);

    BreadthFirstSearch<Recruiter> bfs = new BreadthFirstSearch<>(recruiterGraph.get("you"), RecruiterGraphService::stopPointMethod);
    VerticesDTO<Recruiter> vertexTree = bfs.traverse();
    System.out.println("recruiter with correct position: " + vertexTree);

  }
}