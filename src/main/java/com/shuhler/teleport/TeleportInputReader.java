package com.shuhler.teleport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TeleportInputReader {

  private static final String PORTAL_INPUT_DIVIDER = " - ";

  private List<String> inputLines;


  public TeleportInputReader(Path inputFile) {
    try {
      inputLines = Files.readAllLines(inputFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Portal> getPortals() {
    return inputLines.stream()
            .map(this::parsePortal)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
  }

  private Portal parsePortal(String inputLine) {
    //assumption: city names will never contain dashes

    if (inputLine.contains(PORTAL_INPUT_DIVIDER)) {

      int dividerStartIndex = inputLine.indexOf(PORTAL_INPUT_DIVIDER);
      int dividerEndIndex = dividerStartIndex + PORTAL_INPUT_DIVIDER.length();

      String cityA = inputLine.substring(0, dividerStartIndex);
      String cityB = inputLine.substring(dividerEndIndex);

      return new Portal(cityA, cityB);
    }

    return null;
  }


  public List<TeleportQuery> getQueries() {
    return null;
  }
}
