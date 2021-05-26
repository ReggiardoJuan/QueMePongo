package domain.prenda;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import static domain.prenda.Trama.LISA;

public class PrendaTest {
  private static final Random RANDOM = new Random();

  @Test
  public void puedoCrearUnaPrenda() {
    TipoPrenda tipoPrenda = Arrays.asList(TipoPrenda.values()).get(RANDOM.nextInt(TipoPrenda.values().length));
    Material materialPrenda = tipoPrenda.getMaterialesPermitidos().get(0);
    Color colorPrenda = new Color(0, 0, 0);
    Prenda prenda = new Prenda(tipoPrenda, materialPrenda, LISA, colorPrenda, null);

    assertNotNull(prenda);

    assertEquals(tipoPrenda, prenda.getTipoPrenda());
    assertEquals(materialPrenda, prenda.getMaterial());
    assertEquals(LISA, prenda.getTrama());
    assertEquals(colorPrenda, prenda.getColorPrincipal());
  }
}
