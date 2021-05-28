package domain.atuendo;

import domain.atuendo.Atuendo;
import domain.atuendo.Sastre;
import domain.atuendo.SastreJohnson;
import domain.atuendo.SastreSanJuan;
import org.junit.jupiter.api.Test;

import static domain.prenda.Material.*;
import static domain.prenda.TipoPrenda.*;
import static org.junit.jupiter.api.Assertions.*;

public class SastreTest {
  @Test
  public void puedoConfeccionarUniformeSanJuan() {
    Sastre sastreSanJuan = new SastreSanJuan();
    Atuendo atuendo = sastreSanJuan.confeccionarUniforme();

    assertEquals(CHOMBA, atuendo.getParteSuperior().getTipoPrenda());
    assertEquals(PIQUE, atuendo.getParteSuperior().getMaterial());
    assertEquals(PANTALON, atuendo.getParteInferior().getTipoPrenda());
    assertEquals(ACETATO, atuendo.getParteInferior().getMaterial());
    assertEquals(ZAPATILLAS, atuendo.getCalzado().getTipoPrenda());
    assertEquals(ALGODON, atuendo.getCalzado().getMaterial());
  }
  @Test
  public void puedoConfeccionarUniformeJhonson() {
    Sastre sastreJohnson = new SastreJohnson();
    Atuendo atuendo = sastreJohnson.confeccionarUniforme();

    assertEquals(CAMISA, atuendo.getParteSuperior().getTipoPrenda());
    assertEquals(ALGODON, atuendo.getParteSuperior().getMaterial());
    assertEquals(PANTALON_VESTIR, atuendo.getParteInferior().getTipoPrenda());
    assertEquals(ALGODON, atuendo.getParteInferior().getMaterial());
    assertEquals(ZAPATOS, atuendo.getCalzado().getTipoPrenda());
    assertEquals(CUERO, atuendo.getCalzado().getMaterial());
  }
}
