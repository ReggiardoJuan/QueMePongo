package domain.atuendo;

import domain.TestCase;
import domain.prenda.*;
import org.junit.jupiter.api.Test;

import static domain.prenda.CategoriaPrenda.*;
import static org.junit.jupiter.api.Assertions.*;

public class AtuendoTest extends TestCase {
  @Test
  public void puedoConfeccionarAtuendo() {
    Prenda parteSuperior = generarPrenda(PARTE_SUPERIOR);
    Prenda parteInferior = generarPrenda(CategoriaPrenda.PARTE_INFERIOR);
    Prenda calzado = generarPrenda(CategoriaPrenda.CALZADO);
    Atuendo atuendo = new Atuendo(parteSuperior, parteInferior, calzado);

    assertNotNull(atuendo);
    assertEquals(parteSuperior, atuendo.getParteSuperior());
    assertEquals(parteInferior, atuendo.getParteInferior());
    assertEquals(calzado, atuendo.getCalzado());
  }
}
