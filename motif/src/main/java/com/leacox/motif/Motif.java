package com.leacox.motif;

/**
 * @author John Leacox
 */
public class Motif {
  private Motif() {
  }

  public static <T> Of<T> match(T value) {
    return new Of<>(value);
  }
}
