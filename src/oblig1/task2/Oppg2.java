package oblig1.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {

  public static void main(String[] args) {
    taskI(ansatte());
    taskII(ansatte());
    taskIII(ansatte());
    taskIV(ansatte());
  }

  private static List<Ansatt> ansatte() {
    List<Ansatt> ansatte = new ArrayList<>();
    ansatte.add(new Ansatt("Kari", "Olsen", Kjonn.KVINNE, "Sekretær", 550000));
    ansatte.add(new Ansatt("Ole", "Pedersen", Kjonn.MANN, "Konsulent", 630000));
    ansatte.add(new Ansatt("Helene", "Berg", Kjonn.KVINNE, "Konsulent", 650000));
    ansatte.add(new Ansatt("Per", "Steffensen", Kjonn.MANN, "Sjef", 800000));
    ansatte.add(new Ansatt("Fredrik", "Johnsen", Kjonn.MANN, "Assistent", 700000));
    return ansatte;
  }

  private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> function) {
    for (Ansatt ansatt : ansatte) {
      ansatt.setAarslonn(function.apply(ansatt));
    }
    skrivUtAlle(ansatte);
  }

  private static void skrivUtAlle(List<Ansatt> ansatte) {
    for (Ansatt ansatt : ansatte) {
      System.out.println(ansatt.toString());
    }
  }

  /** i. Et fast kronetillegg */
  private static void taskI(List<Ansatt> ansatte) {
    System.out.println("\ni. \nEt fast kronetillegg:");
    lonnsoppgjor(ansatte, a -> a.getAarslonn() + 10000);
  }

  /** ii. Et fast prosenttillegg */
  private static void taskII(List<Ansatt> ansatte) {
    System.out.println("\nii. \nEt fast prosenttillegg:");
    lonnsoppgjor(ansatte, a -> (int) (a.getAarslonn() * 1.08));

  }

  /** iii. Et fast kronetillegg hvis du har lav lønn */
  private static void taskIII(List<Ansatt> ansatte) {
    System.out.println("\niii. \nEt fast kronetillegg hvis du har lav lønn:");
    lonnsoppgjor(ansatte, a -> {
      if (a.getAarslonn() < 700000) {
        return a.getAarslonn() + 50000;
      }
      return a.getAarslonn();
    });
  }

  /** iv. Et fast prosenttillegg hvis du er mann */
  private static void taskIV(List<Ansatt> ansatte) {
    System.out.println("\niv. \nEt fast prosenttillegg hvis du er mann:");
    lonnsoppgjor(ansatte, a -> {
      if (a.getKjonn() == Kjonn.MANN) {
        return (int) (a.getAarslonn() * 1.2);
      }
      return a.getAarslonn();
    });
  }
}
