package com.shuhler.teleport;

import com.shuhler.teleport.model.TeleportationNetwork;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Application {


  public static void main(String[] args) {

      if (args.length != 1) {
        System.out.println("missing input file name");
      }

      Path pathToInputFile = Paths.get(args[0]);

      TeleportationInputReader teleportationInputReader = new TeleportationInputReader(pathToInputFile);

      List<Portal> portals = teleportationInputReader.getPortals();

      TeleportationNetwork network = new TeleportationNetwork(portals);

      List<TeleportQuery> queries = teleportationInputReader.getQueries();



  }


}
