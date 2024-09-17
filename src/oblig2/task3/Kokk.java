package oblig2.task3;

import java.util.Random;

/**
 * This is a {@link Thread} class that represents a cook thread that
 * continuously attempts to place hamburgers on a shared {@link HamburgerBrett}
 * at specified intervals.
 */
public class Kokk extends Thread {

  private final HamburgerBrett hamburgerBrett;
  private String navn;
  private Random random;

  /**
   * Constructs a new {@link Kokk} with the given name and {@link HamburgerBrett}.
   * 
   * @param hamburgerBrett the shared tray where the cook places hamburgers
   * @param name           the name of the cook
   */
  public Kokk(HamburgerBrett hamburgerBrett, String navn) {
    this.hamburgerBrett = hamburgerBrett;
    this.navn = navn;
    this.random = new Random();
  }

  /**
   * The run method contains the main execution logic for the cook.
   * <p>
   * The thread runs an infinite loop where it sleeps for a random
   * number of seconds between 2 and 6, and then attempts to place a
   * hamburger on the shared tray.
   */
  @Override
  public void run() {
    while (true) {
      try {
        sleep(random.nextInt(2, 7) * 1000);
      } catch (InterruptedException e) {
      }
      hamburgerBrett.leggePaHamburger(navn);
    }
  }

}
