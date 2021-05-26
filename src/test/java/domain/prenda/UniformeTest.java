package domain.prenda;

import org.junit.jupiter.api.Test;

import static domain.prenda.CategoriaPrenda.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import static domain.prenda.Trama.LISA;

public class UniformeTest {
  @Test
  public void puedoConfeccionarUniforme() {
    Prenda parteSuperior = generarPrenda(PARTE_SUPERIOR);
    Prenda parteInferior = generarPrenda(CategoriaPrenda.PARTE_INFERIOR);
    Prenda calzado = generarPrenda(CategoriaPrenda.CALZADO);
    Uniforme uniforme = new Uniforme(parteSuperior, parteInferior, calzado);

    assertNotNull(uniforme);
    assertEquals(parteSuperior, uniforme.getParteSuperior());
    assertEquals(parteInferior, uniforme.getParteInferior());
    assertEquals(calzado, uniforme.getCalzado());
  }

  private Prenda generarPrenda(CategoriaPrenda categoriaPrenda) {
    TipoPrenda tipoPrenda = Arrays.asList(TipoPrenda.values())
        .stream()
        .filter(prenda -> prenda.getCategoriaPrenda().equals(categoriaPrenda))
        .findAny()
        .get();

    Material materialPrenda = tipoPrenda.getMaterialesPermitidos().get(0);
    Color colorPrenda = new Color(0, 0, 0);
    return new Prenda(tipoPrenda, materialPrenda, LISA, colorPrenda, null);
  }
}
