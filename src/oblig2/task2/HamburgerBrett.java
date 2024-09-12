package oblig2.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a shared hamburger tray where cooks can add
 * hamburgers and waiters can take hamburgers from. It manages the
 * synchronization between these actions to ensure thread safety.
 */
public class HamburgerBrett {

  private int kapasitet;
  private List<Hamburger> hamburgerBrett;
  private int hamburgerNummer;

  /**
   * Constructs a new {@link HamburgerBrett} with the specified capacity.
   * The {@link HamburgerBrett} is represented as a {@link List} of
   * {@link Hamburger}s.
   * 
   * @param kapasitet the maximum number of hamburgers the tray can hold
   */
  public HamburgerBrett(int kapasitet) {
    this.kapasitet = kapasitet;
    this.hamburgerBrett = new ArrayList<>(kapasitet);
    this.hamburgerNummer = 1;
  }

  /**
   * Checks if the tray is full.
   * 
   * @return {@code true} if the tray is full, {@code false} otherwise
   */
  public boolean fulltBrett() {
    return hamburgerBrett.size() == kapasitet;
  }

  /**
   * Adds a {@link Hamburger} to the tray. If the tray is full, the calling thread
   * is put in a waiting state until space is available.
   * 
   * @param kokk the name of the cook adding the hamburger to the tray
   */
  public void leggePaHamburger(String kokk) {
    synchronized (this) {
      while (fulltBrett()) {
        System.out.println(kokk + " (kokk) klar med hamburger, men brett fullt. Venter!");
        try {
          wait();
        } catch (InterruptedException e) {
        }
      }
      Hamburger hamburger = new Hamburger(hamburgerNummer);
      hamburgerBrett.add(hamburger);
      System.out.println(kokk + " (kokk) legger på hamburger " + hamburger + ". "
          + this);
      hamburgerNummer++;
      notifyAll();
    }
  }

  /**
   * Removes a {@link Hamburger} from the tray. If the tray is empty, the calling
   * thread is put in a waiting state until a hamburger is available.
   * 
   * @param servitor the name of the waiter taking the hamburger from the tray
   */
  public void taAvHamburger(String servitor) {
    synchronized (this) {
      while (hamburgerBrett.isEmpty()) {
        System.out.println(servitor + " (servitør) ønsker å ta hamburger, men brett tomt. Venter!");
        try {
          wait();
        } catch (InterruptedException e) {
        }
      }
      Hamburger hamburger = hamburgerBrett.removeFirst();
      System.out.println(servitor + " (servitør) tar av hamburger " + hamburger + ". " + this);
      notifyAll();
    }
  }

  @Override
  public String toString() {
    return "Brett: " + hamburgerBrett;
  }

}
