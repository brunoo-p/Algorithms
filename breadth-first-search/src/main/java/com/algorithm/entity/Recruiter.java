package com.algorithm.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class Recruiter {

  private UUID uuid;
  private String name;
  private List<PositionsEnum> positions = new LinkedList<>();
  private List<Recruiter> friends = new LinkedList<>();

  public Recruiter(
      String name,
      List<PositionsEnum> positions,
      List<Recruiter> friends
  ) {
    this.uuid = UUID.randomUUID();
    this.name = name;
    this.positions.addAll(positions);
    this.friends.addAll(friends);
  }

  @Override
  public String toString() {
    return "Recruiter {" +
        "\n uuid=" + uuid +
        ", \n name='" + name + '\'' +
        ", \n positions=" + positions +
        "\n}";
  }

}

