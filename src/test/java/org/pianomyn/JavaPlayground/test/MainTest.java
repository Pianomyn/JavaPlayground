package org.pianomyn.JavaPlayground.test;
// package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/*
public class MainTest {
  @Test
  public void simpleAddTest() {
    assert (1 + 2 == 3);
    assertFalse(1 + 2 == 100);
  }
}
*/
import org.pianomyn.JavaPlayground.*;
//import org.pianomyn.JavaPlayGround.Main
import java.util.List;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void designUpdateShouldReplaceDesignIfSuccessful() {
        var updater = new DesignUpdaterImpl();
        var newDesign = new Design(50, 50, List.of(new Page("page-id", List.of())));
        var updated = updater.replaceWith(newDesign);
        // did replace design
        assertTrue(updated);
        assertEquals(newDesign, updater.currentDesign);
    }

@Test
    public void designUpdateShouldNotReplaceWhenNewDesignHasElementsLargerThanDesign() {
        var updater = new DesignUpdaterImpl();
        var element = new Element("element", 50, 50, "font");
        var elementLargerThanDesign = new Element("element-larger-than-design", 200, 100, "font");
        var newDesign = new Design(100, 100, List.of(new Page("page-id", List.of(
                element, elementLargerThanDesign
        ))));
        var updated = updater.replaceWith(newDesign);
        // did not replace design
        assertFalse(updated);
        assertNotEquals(newDesign, updater.currentDesign);
    }
}
