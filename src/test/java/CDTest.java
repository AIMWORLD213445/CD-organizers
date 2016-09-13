import org.junit.*;
import static org.junit.Assert.*;

public class CDTest {

  @Test
  public void CD_instantiatesCorrectly_true() {
    CD myCD = new CD("Mow the lawn");
    assertEquals(true, myCD instanceof CD);
  }
  @Test
  public void CD_instantiatesWithAlbumName_String() {
    CD myCD = new CD("Mow the lawn");
    assertEquals("Mow the lawn", myCD.getAlbumName());
  }

}
