package org.richardinnocent.polysight.core.client;

import static org.junit.Assert.*;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class MajorOnlyServiceVersionTest {

  @Test
  public void testSettingVersionFromConstructor() {
    int version = 3;
    assertEquals(version, new MajorOnlyServiceVersion(version).getVersion());
  }

  @Test
  public void testGetUriForm() {
    assertEquals("v3", new MajorOnlyServiceVersion(3).getUriForm());
  }

  @Test
  public void testToString() {
    assertEquals("v3", new MajorOnlyServiceVersion(3).toString());
  }

  @Test
  public void testEqualsAndHashCode() {
    EqualsVerifier.forClass(MajorOnlyServiceVersion.class).verify();
  }

}