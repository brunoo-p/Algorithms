package com.algorithm.service;

import com.algorithm.builderMock.RecruiterMock;
import com.algorithm.entity.Recruiter;
import com.algorithm.entity.Vertex;
import com.algorithm.entity.VerticesDTO;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

  List<Recruiter> recruiterList = new RecruiterMock().getRecruiters();

  RecruiterGraphService graphService = new RecruiterGraphService();
  HashMap<String, Vertex<Recruiter>> recruiterGraph = graphService.buildRecruiterGraph(recruiterList);

  private final Vertex<Recruiter> rootVertex = recruiterGraph.get("you");
  private final Vertex<Recruiter> vertexToBeFound = new Vertex<>(recruiterList.stream().filter(RecruiterGraphService::stopPointMethod).findFirst().orElse(null));

  @Test
  void traverseShouldReturnTheFirstCheckRecruiterWithOpenedPositionExpected() {
    VerticesDTO<Recruiter> expectedVerticesDTO = new VerticesDTO<>(vertexToBeFound, List.of());

    BreadthFirstSearch<Recruiter> breadthFirstSearch = new BreadthFirstSearch<>(rootVertex, RecruiterGraphService::stopPointMethod);
    VerticesDTO<Recruiter> response = breadthFirstSearch.traverse();

    assertEquals(expectedVerticesDTO.getStopPointVertex().getData().getUuid(), response.getStopPointVertex().getData().getUuid());
    assertEquals(expectedVerticesDTO.getStopPointVertex().getData().getName(), response.getStopPointVertex().getData().getName());
  }
}
