package com.shuhler.teleport;

import com.shuhler.teleport.input.Portal;
import com.shuhler.teleport.input.TeleportInputReader;
import com.shuhler.teleport.model.TeleportNet;
import com.shuhler.teleport.query.TeleportQuery;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Application {


  public static void main(String[] args) {

      if (args.length != 1) {
        System.out.println("missing input file name");
      }

      Path pathToInputFile = Paths.get(args[0]);

      TeleportInputReader teleportInputReader = new TeleportInputReader(pathToInputFile);

      List<Portal> portals = teleportInputReader.getPortals();

      TeleportNet network = new TeleportNet(portals);

      List<TeleportQuery> queries = teleportInputReader.getQueries();

      List<String> queryResults = queries.stream().map(q -> q.query(network)).collect(Collectors.toList());

      for (String result : queryResults) {
          System.out.println(result);
      }
  }


}
