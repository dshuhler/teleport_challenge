package com.shuhler.teleport;

import com.shuhler.teleport.input.TextFileInputReader;
import com.shuhler.teleport.network.TeleportNet;
import com.shuhler.teleport.query.TeleportQuery;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TeleportRunner {

  public static void main(String[] args) {

      if (args.length != 1) {
        System.out.println("invalid parameters");
        return;
      }

      Path inputFile = Paths.get(args[0]);
      TextFileInputReader textFileInputReader = new TextFileInputReader(inputFile);
      TeleportNet network = new TeleportNet(textFileInputReader.getPortals());

      List<TeleportQuery> queries = textFileInputReader.getQueries();
      List<String> queryResults = queries.stream().map(q -> q.query(network)).collect(Collectors.toList());

      queryResults.forEach(System.out::println);
  }
}