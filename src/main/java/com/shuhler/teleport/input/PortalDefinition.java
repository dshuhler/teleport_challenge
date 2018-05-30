package com.shuhler.teleport.input;

import java.util.Objects;

public class PortalDefinition {

    private String cityA;
    private String cityB;

    public PortalDefinition(String cityA, String cityB) {
        this.cityA = cityA;
        this.cityB = cityB;
    }

    public String getCityA() {
        return cityA;
    }

    public String getCityB() {
        return cityB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PortalDefinition portalDefinition = (PortalDefinition) o;
        return Objects.equals(cityA, portalDefinition.cityA) &&
                Objects.equals(cityB, portalDefinition.cityB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityA, cityB);
    }
}
