package com.shuhler.teleport.input;

import com.shuhler.teleport.query.TeleportQuery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TextFileInputReader {

    private static final String PORTAL_INPUT_DIVIDER = " - ";

    private List<String> inputLines;

    public TextFileInputReader(Path inputFile) {
        try {
            inputLines = Files.readAllLines(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PortalDefinition> getPortals() {
        return inputLines.stream()
                .map(this::parsePortal)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<PortalDefinition> parsePortal(String inputLine) {
        if (!inputLine.contains(PORTAL_INPUT_DIVIDER)) {
            return Optional.empty();
        }

        int dividerStartIndex = inputLine.indexOf(PORTAL_INPUT_DIVIDER);
        int dividerEndIndex = dividerStartIndex + PORTAL_INPUT_DIVIDER.length();

        String cityA = inputLine.substring(0, dividerStartIndex);
        String cityB = inputLine.substring(dividerEndIndex);

        return Optional.of(new PortalDefinition(cityA, cityB));
    }


    public List<TeleportQuery> getQueries() {
        return inputLines.stream()
                .map(TeleportQuery::buildQuery)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

}
