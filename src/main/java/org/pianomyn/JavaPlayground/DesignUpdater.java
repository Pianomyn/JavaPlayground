package org.pianomyn.JavaPlayground;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world");
  }
}
*/

public record Design(int width, int height, List<Page> pages) {
}

public record Page(String id, List<Element> elements) {
}

public record Element(String id, int width, int height, String font) {
}

public interface DesignUpdater {
  /**
   * Replaces the entire design with the provided design.
   *
   * @return true if successful, false if the design was not replaced.
   */
  boolean replaceWith(Design newDesign);

  /**
   * Adds the provided page to the existing design
   *
   * @return true if successful, false if the design was not updated.
   */
  boolean addPage(Page newPage);
}




    /*
    current design

     */

public class DesignUpdaterImpl implements DesignUpdater {
  Set<String> currentDesignElementIds = new HashSet<>();
  public Design currentDesign = new Design(1000, 1000, List.of());

  private boolean hasValidDimensions(Design newDesign) {
    for (Page p : newDesign.pages) {
      for (Element e : p.elements) {
        if (e.height > newDesign.height || e.width > newDesign.width) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean hasValidDimensions(Page newPage) {
    for (Element e : newPage.elements) {
      if (e.height > currentDesign.height || e.width > currentDesign.width) {
        return false;
      }
    }
    return true;
  }


  private boolean hasUniqueElementIds(Design newDesign) {
    Set<String> seenElementIds = new HashSet<>();
    for (Page p : newDesign.pages) {
      for (Element e : p.elements) {
        if (!seenElementIds.contains(e.id)) {
          return false;
        }
        seenElementIds.add(e.id);
      }
    }
    return true;
  }

  @Override
  public boolean replaceWith(Design newDesign) {
    // Height/width validation
    if (!hasValidDimensions(newDesign)) {
      return false;
    }

    // Unique element id validation
    if (!hasUniqueElementIds(newDesign)) {
      return false;
    }


    currentDesign = newDesign;
    return true;
  }

  @Override
  public boolean addPage(Page newPage) {
    // dimensions validation
    if (!hasValidDimensions(newPage)) {
      return false;
    }

    // element id validaiton


    var currentPages = new ArrayList<>(currentDesign.pages());
    currentPages.add(newPage);
    currentDesign = new Design(currentDesign.width(), currentDesign.height(), currentPages);

    return true;
  }
}
