package oblig1.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Oppg3 {

  public static void main(String[] args) {
    System.out.println("\na)");
    taskA(ansatte());
    System.out.println("\nb");
    taskB(ansatte());
    System.out.println("\nc)");
    taskC(ansatte());
    System.out.println("\nd)");
    taskD(ansatte());
    System.out.println("\ne)");
    taskE(ansatte());
    System.out.println("\nf)");
    taskF(ansatte());
    System.out.println("\ng)");
    taskG(ansatte());
    System.out.println("\nh)");
    taskH(ansatte());
  }

  private static List<Ansatt> ansatte() {
    List<Ansatt> ansatte = new ArrayList<>();
    ansatte.add(new Ansatt("Kari", "Olsen", Kjonn.KVINNE, "Sekretær", 550000));
    ansatte.add(new Ansatt("Ole", "Pedersen", Kjonn.MANN, "Konsulent", 630000));
    ansatte.add(new Ansatt("Helene", "Berg", Kjonn.KVINNE, "Konsulent", 650000));
    ansatte.add(new Ansatt("Per", "Steffensen", Kjonn.MANN, "Sjef", 820000));
    ansatte.add(new Ansatt("Fredrik", "Johnsen", Kjonn.MANN, "Assistent", 700000));
    return ansatte;
  }

  private static void taskA(List<Ansatt> ansatte) {
    // Lag en ny liste som kun inneholder etternavnene til de ansatte
    List<String> etternavn = ansatte.stream()
        .map(Ansatt::getEtternavn)
        .toList();
    System.out.println("Liste med etternavn til de ansatte: " + etternavn);
  }

  private static void taskB(List<Ansatt> ansatte) {
    // Finn ut antall kvinner blant de ansatte
    long antallKvinner = ansatte.stream()
        .filter(a -> a.getKjonn() == Kjonn.KVINNE)
        .count();
    System.out.println("Antall kvinner blant de ansatte: " + antallKvinner);
  }

  private static void taskC(List<Ansatt> ansatte) {
    // Regn ut gjennomsnittslønnen til kvinnene
    double snittlønnKvinner = ansatte.stream()
        .filter(a -> a.getKjonn() == Kjonn.KVINNE)
        .mapToDouble(a -> a.getAarslonn()).average().getAsDouble();
    System.out.println("Gjennomsnittslønnen til kvinnene: " + snittlønnKvinner);
  }

  private static void taskD(List<Ansatt> ansatte) {
    // Gi alle sjefer en lønnsøkning på 7%
    ansatte.stream()
        .filter(a -> a.getStilling().toLowerCase().contains("sjef"))
        .forEach(a -> a.setAarslonn((int) (a.getAarslonn() * 1.07)));
    System.out.println("Lønnsøkning på 7% for alle sjefer: ");
    ansatte.forEach(System.out::println);
  }

  private static void taskE(List<Ansatt> ansatte) {
    // Finn ut (true|false) om det er noen ansatte som tjener mer enn 800.000,-
    boolean høyLønn = ansatte.stream()
        .anyMatch(a -> a.getAarslonn() > 800000);
    System.out.println("Er det noen ansatte som tjener mer enn 800.000kr?: " + høyLønn);
  }

  private static void taskF(List<Ansatt> ansatte) {
    // Skriv ut alle de ansatte med System.out.println() uten å bruke løkke
    System.out.println("Alle ansatte: ");
    ansatte.forEach(System.out::println);
  }

  private static void taskG(List<Ansatt> ansatte) {
    // Finn den/de ansatte som har lavest lønn
    int lavestLønn = ansatte.stream()
        .map(Ansatt::getAarslonn)
        .min(Integer::compareTo).get();

    List<Ansatt> lavestLønnAnsatte = ansatte.stream()
        .filter(a -> a.getAarslonn() == lavestLønn)
        .toList();
    System.out.println("Ansatte med lavest lønn: ");
    lavestLønnAnsatte.forEach(System.out::println);
  }

  private static void taskH(List<Ansatt> ansatte) {
    // Finn ut summen av alle heltall i [1, 1000> som er delelig med 3 eller 5
    int sum = IntStream.range(1, 1000)
        .filter(i -> (i % 3 == 0 || i % 5 == 0))
        .sum();
    System.out.println("Summen av alle heltall i [1, 1000> som er delelig med 3 eller 5: " + sum);
  }

}
