package domain.prenda;

import org.junit.jupiter.api.Test;

import static domain.prenda.Material.*;
import static domain.prenda.TipoPrenda.*;
import static org.junit.jupiter.api.Assertions.*;

public class SastreTest {
  @Test
  public void puedoConfeccionarUniformeSanJuan() {
    Sastre sastreSanJuan = new SastreSanJuan();
    Uniforme uniforme = sastreSanJuan.confeccionarUniforme();

    assertEquals(CHOMBA, uniforme.getParteSuperior().getTipoPrenda());
    assertEquals(PIQUE, uniforme.getParteSuperior().getMaterial());
    assertEquals(PANTALON, uniforme.getParteInferior().getTipoPrenda());
    assertEquals(ACETATO, uniforme.getParteInferior().getMaterial());
    assertEquals(ZAPATILLAS, uniforme.getCalzado().getTipoPrenda());
    assertEquals(ALGODON, uniforme.getCalzado().getMaterial());
  }
  @Test
  public void puedoConfeccionarUniformeJhonson() {
    Sastre sastreJohnson = new SastreJohnson();
    Uniforme uniforme = sastreJohnson.confeccionarUniforme();

    assertEquals(CAMISA, uniforme.getParteSuperior().getTipoPrenda());
    assertEquals(ALGODON, uniforme.getParteSuperior().getMaterial());
    assertEquals(PANTALON_VESTIR, uniforme.getParteInferior().getTipoPrenda());
    assertEquals(ALGODON, uniforme.getParteInferior().getMaterial());
    assertEquals(ZAPATOS, uniforme.getCalzado().getTipoPrenda());
    assertEquals(CUERO, uniforme.getCalzado().getMaterial());
  }
}
