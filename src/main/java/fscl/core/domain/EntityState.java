package fscl.core.domain;

public enum EntityState {
  PENDING("PENDING"),
  CREATED("CREATED");

  private final String state;

  EntityState(String state) {
    this.state = state;
  }
}