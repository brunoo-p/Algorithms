package com.algorithm.builderMock;

import com.algorithm.entity.PositionsEnum;
import com.algorithm.entity.Recruiter;

import java.util.Arrays;
import java.util.List;

public class RecruiterMock {

  private final Recruiter alice;
  private final Recruiter bob;
  private final Recruiter charlie;
  private final Recruiter dan;
  private final Recruiter ellen;
  private final Recruiter john;
  private final Recruiter max;
  private final Recruiter peggy;
  private final Recruiter sara;
  private final Recruiter you;

  public RecruiterMock() {
    this.max = new Recruiter("max", List.of(PositionsEnum.UX_DESIGNER, PositionsEnum.FULL_STACK_DEVELOPER), List.of());
    this.ellen = new Recruiter("ellen", List.of(PositionsEnum.DATA_SCIENTIST, PositionsEnum.UX_DESIGNER), List.of());
    this.bob = new Recruiter("bob", List.of(PositionsEnum.TYPESCRIPT_DEVELOPER), List.of());
    this.sara = new Recruiter("sara", List.of(PositionsEnum.DATA_SCIENTIST), List.of());
    this.dan = new Recruiter("dan", List.of(),Arrays.asList(max, ellen));
    this.charlie = new Recruiter("charlie", List.of(PositionsEnum.JAVA_DEVELOPER), List.of());
    this.peggy = new Recruiter("peggy", List.of(PositionsEnum.FULL_STACK_DEVELOPER), List.of());
    this.alice = new Recruiter("alice", List.of(), List.of(peggy));
    this.john = new Recruiter("john", List.of(PositionsEnum.TESTER, PositionsEnum.UX_DESIGNER, PositionsEnum.DOTNET_DEVELOPER), Arrays.asList(bob, charlie));
    this.you = new Recruiter("you", List.of(PositionsEnum.TESTER, PositionsEnum.FULL_STACK_DEVELOPER), Arrays.asList(john, alice));
    peggy.setFriends(List.of(alice));
    charlie.setFriends(Arrays.asList(john, dan, sara));
  }

  public List<Recruiter> getRecruiters() {
    return Arrays.asList(alice, bob, dan, charlie, ellen, john, peggy, max, sara, you);
  }
}
