package oblig2.task2;

import java.util.Random;

/**
 * This is a {@link Thread} class that represents a waiter thread that
 * continuously attempts to take hamburgers from a shared {@link HamburgerBrett}
 * at specified intervals.
 */
public class Servitor extends Thread {

  private final HamburgerBrett hamburgerBrett;
  private String navn;
  private Random random;

  /**
   * Constructs a new {@link Servitor} with the given name and
   * {@link HamburgerBrett}.
   * 
   * @param hamburgerBrett the shared tray from which the waiter takes hamburgers
   * @param name           the name of the waiter
   */
  public Servitor(HamburgerBrett hamburgerBrett, String navn) {
    this.hamburgerBrett = hamburgerBrett;
    this.navn = navn;
    this.random = new Random();
  }

  /**
   * The run method contains the main execution logic for the waiter.
   * <p>
   * The thread runs an infinite loop where it sleeps for a random
   * number of seconds between 2 and 6, and then attempts to take a
   * hamburger from the shared tray.
   */
  @Override
  public void run() {
    while (true) {
      try {
        sleep(random.nextInt(2, 7) * 1000);
      } catch (InterruptedException e) {
      }
      hamburgerBrett.taAvHamburger(navn);
    }
  }

}
