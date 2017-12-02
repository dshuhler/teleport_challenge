package com.shuhler.teleport;

import java.util.Objects;

public class Portal {

  private String cityA;
  private String cityB;

  public Portal(String cityA, String cityB) {
    this.cityA = cityA;
    this.cityB = cityB;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Portal portal = (Portal) o;
    return Objects.equals(cityA, portal.cityA) &&
            Objects.equals(cityB, portal.cityB);
  }

  @Override
  public int hashCode() {

    return Objects.hash(cityA, cityB);
  }
}
