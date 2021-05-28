package domain.guardarropa;

import domain.guardarropa.Guardarropa;
import domain.prenda.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static domain.prenda.CategoriaPrenda.*;
import static domain.prenda.CategoriaPrenda.CALZADO;
import static domain.prenda.Trama.LISA;

public class GuardarropasTest {
  private static final Random RANDOM = new Random();
  Guardarropa guardarropa;

  @Test
  public void puedoObtenerPrendasAptas() {
    cargarGuardarropa();
    Double temperatura = (double) RANDOM.nextInt(40);
    List<Prenda> prendasAptas = guardarropa.conseguirPrendaApta(PARTE_SUPERIOR, temperatura);

    assertTrue(prendasAptas
        .stream()
        .allMatch(prenda -> prenda.getTipoPrenda().getTemperaturaMaxima() <= temperatura));
  }

  private Prenda generarPrenda(CategoriaPrenda categoriaPrenda) {
    List<TipoPrenda> prendas = Arrays.asList(TipoPrenda.values())
        .stream()
        .filter(tipoPrenda -> tipoPrenda.getCategoriaPrenda().equals(categoriaPrenda))
        .collect(Collectors.toList());
    TipoPrenda tipoPrenda = prendas.get(RANDOM.nextInt(prendas.size()));
    Material materialPrenda = tipoPrenda.getMaterialesPermitidos().get(0);
    Color colorPrenda = new Color(0, 0, 0);
    return new Prenda(tipoPrenda, materialPrenda, LISA, colorPrenda, null);
  }
  private void cargarGuardarropa() {
    guardarropa = new Guardarropa();
    guardarropa.addPrenda(generarPrenda(PARTE_SUPERIOR));
    guardarropa.addPrenda(generarPrenda(PARTE_SUPERIOR));
    guardarropa.addPrenda(generarPrenda(PARTE_SUPERIOR));
    guardarropa.addPrenda(generarPrenda(PARTE_SUPERIOR));
    guardarropa.addPrenda(generarPrenda(PARTE_SUPERIOR));

    guardarropa.addPrenda(generarPrenda(PARTE_INFERIOR));
    guardarropa.addPrenda(generarPrenda(PARTE_INFERIOR));
    guardarropa.addPrenda(generarPrenda(PARTE_INFERIOR));
    guardarropa.addPrenda(generarPrenda(PARTE_INFERIOR));
    guardarropa.addPrenda(generarPrenda(PARTE_INFERIOR));

    guardarropa.addPrenda(generarPrenda(CALZADO));
    guardarropa.addPrenda(generarPrenda(CALZADO));
    guardarropa.addPrenda(generarPrenda(CALZADO));
    guardarropa.addPrenda(generarPrenda(CALZADO));
    guardarropa.addPrenda(generarPrenda(CALZADO));
  }
}
