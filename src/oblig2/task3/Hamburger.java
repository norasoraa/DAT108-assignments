package oblig2.task3;

/**
 * A record that represents a hamburger with a unique number.
 * <p>
 * The record has a custom {@link #toString()} method for representing the
 * hamburger when it's printed.
 */
public record Hamburger(int nummer) {

  @Override
  public String toString() {
    return "◖" + nummer + "◗";
  }

}
