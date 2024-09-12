package oblig2.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String... blablabla) {
    final String[] kokker = { "Anne", "Erik", "Knut" };
    final String[] servitorer = { "Mia", "Per" };
    final int KAPASITET = 4;
    skrivUtHeader(kokker, servitorer, KAPASITET);
    HamburgerBrett brett = new HamburgerBrett(KAPASITET);
    for (String navn : kokker) {
      new Kokk(brett, navn).start();
    }
    for (String navn : servitorer) {
      new Servitor(brett, navn).start();
    }
  }

  private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
    System.out.println("I denne simuleringen har vi:");
    System.out.println("\t" + kokker.length + " kokker " + printPersoner(kokker));
    System.out.println("\t" + servitorer.length + " servitører " + printPersoner(servitorer));
    System.out.println("\tKapasiteten til brettet er " + kapasitet + " hamburgere.\n" +
        "Vi starter ...");
  }

  private static String printPersoner(String[] personer) {
    List<String> utskrift = new ArrayList<>();
    for (String person : personer) {
      utskrift.add(person);
    }
    return utskrift.toString();
  }
}
