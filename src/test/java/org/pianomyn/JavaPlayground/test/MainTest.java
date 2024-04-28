package org.pianomyn.JavaPlayground.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.pianomyn.JavaPlayground.Main;

public class MainTest {
  @Test
  public void simpleAddTest() {
    assert (1+2 == 3);
    assertFalse(1+2 == 100);
  }
}
