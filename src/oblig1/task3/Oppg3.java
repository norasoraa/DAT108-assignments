package oblig1.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Oppg3 {

  public static void main(String[] args) {
    taskA(ansatte());
    taskB(ansatte());
    taskC(ansatte());
    taskD(ansatte());
    taskE(ansatte());
    taskF(ansatte());
    taskG(ansatte());
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

  /** Lag en ny liste som kun inneholder etternavnene til de ansatte */
  private static void taskA(List<Ansatt> ansatte) {
    List<String> etternavn = ansatte.stream()
        .map(Ansatt::getEtternavn)
        .toList();
    System.out.println("\na) \nListe med etternavn til de ansatte: " + etternavn);
  }

  /** Finn ut antall kvinner blant de ansatte */
  private static void taskB(List<Ansatt> ansatte) {
    long antallKvinner = ansatte.stream()
        .filter(a -> a.getKjonn() == Kjonn.KVINNE)
        .count();
    System.out.println("\nb) \nAntall kvinner blant de ansatte: " + antallKvinner);
  }

  /** Regn ut gjennomsnittslønnen til kvinnene */
  private static void taskC(List<Ansatt> ansatte) {
    double snittlønnKvinner = ansatte.stream()
        .filter(a -> a.getKjonn() == Kjonn.KVINNE)
        .mapToDouble(a -> a.getAarslonn()).average().getAsDouble();
    System.out.println("\nc) \nGjennomsnittslønnen til kvinnene: " + snittlønnKvinner);
  }

  /** Gi alle sjefer en lønnsøkning på 7% */
  private static void taskD(List<Ansatt> ansatte) {
    ansatte.stream()
        .filter(a -> a.getStilling().toLowerCase().contains("sjef"))
        .forEach(a -> a.setAarslonn((int) (a.getAarslonn() * 1.07)));
    System.out.println("\nd) \nLønnsøkning på 7% for alle sjefer: ");
    ansatte.forEach(System.out::println);
  }

  /** Finn ut (true|false) om det er noen ansatte som tjener mer enn 800.000,- */
  private static void taskE(List<Ansatt> ansatte) {
    boolean høyLønn = ansatte.stream()
        .anyMatch(a -> a.getAarslonn() > 800000);
    System.out.println("\ne) \nEr det noen ansatte som tjener mer enn 800.000kr?: " + høyLønn);
  }

  /** Skriv ut alle de ansatte med System.out.println() uten å bruke løkke */
  private static void taskF(List<Ansatt> ansatte) {
    System.out.println("\nf) \nAlle ansatte: ");
    ansatte.forEach(System.out::println);
  }

  /** Finn den/de ansatte som har lavest lønn */
  private static void taskG(List<Ansatt> ansatte) {
    int lavestLønn = ansatte.stream()
        .map(Ansatt::getAarslonn)
        .min(Integer::compareTo).get();

    List<Ansatt> lavestLønnAnsatte = ansatte.stream()
        .filter(a -> a.getAarslonn() == lavestLønn)
        .toList();
    System.out.println("\ng) \nAnsatte med lavest lønn: ");
    lavestLønnAnsatte.forEach(System.out::println);
  }

  /** Finn ut summen av alle heltall i [1, 1000> som er delelig med 3 eller 5 */
  private static void taskH(List<Ansatt> ansatte) {
    int sum = IntStream.range(1, 1000)
        .filter(i -> (i % 3 == 0 || i % 5 == 0))
        .sum();
    System.out.println("\nh) \nSummen av alle heltall i [1, 1000> som er delelig med 3 eller 5: " + sum);
  }

}
