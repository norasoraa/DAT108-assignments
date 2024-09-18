package oblig2.task3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * A class that represents a shared hamburger tray where cooks can add
 * hamburgers and waiters can take hamburgers from.
 */
public class HamburgerBrett {

  private final BlockingQueue<Hamburger> hamburgerBrett;
  private int hamburgerNummer;

  /**
   * Constructs a new {@link HamburgerBrett} with the specified capacity.
   * The {@link HamburgerBrett} is represented as a {@link BlockingQueue} of
   * {@link Hamburger}s.
   * 
   * @param kapasitet the maximum number of hamburgers the tray can hold
   */
  public HamburgerBrett(int kapasitet) {
    this.hamburgerBrett = new ArrayBlockingQueue<Hamburger>(kapasitet);
    this.hamburgerNummer = 1;
  }

  /**
   * Adds a {@link Hamburger} to the tray. If the tray is full, the calling thread
   * is put in a waiting state until space is available.
   * 
   * @param kokk the name of the cook adding the hamburger to the tray
   */
  public void leggePaHamburger(String kokk) {
    try {
      Hamburger hamburger = new Hamburger(hamburgerNummer);
      hamburgerBrett.put(hamburger);
      System.out.println(kokk + " (kokk) legger på hamburger " + hamburger + ". "
          + this);
      hamburgerNummer++;
    } catch (Exception e) {
    }
  }

  /**
   * Removes a {@link Hamburger} from the tray. If the tray is empty, the calling
   * thread is put in a waiting state until a hamburger is available.
   * 
   * @param servitor the name of the waiter taking the hamburger from the tray
   */
  public void taAvHamburger(String servitor) {
    try {
      Hamburger hamburger = hamburgerBrett.take();
      System.out.println(servitor + " (servitør) tar av hamburger " + hamburger + ". " + this);
    } catch (Exception e) {
    }
  }

  @Override
  public String toString() {
    return "Brett: " + hamburgerBrett;
  }

}
