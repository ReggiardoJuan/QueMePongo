package domain;

import domain.guardarropa.Guardarropa;
import domain.prenda.*;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static domain.prenda.CategoriaPrenda.*;
import static domain.prenda.CategoriaPrenda.CALZADO;
import static domain.prenda.Trama.LISA;

public class TestCase {
  protected static final Random RANDOM = new Random();
  protected Guardarropa guardarropa;

  public Prenda generarPrenda(CategoriaPrenda categoriaPrenda) {
    List<TipoPrenda> prendas = Arrays.stream(TipoPrenda.values())
        .filter(tipoPrenda -> tipoPrenda.getCategoriaPrenda().equals(categoriaPrenda))
        .collect(Collectors.toList());
    TipoPrenda tipoPrenda = prendas.get(RANDOM.nextInt(prendas.size()));
    Material materialPrenda = tipoPrenda.getMaterialesPermitidos().get(0);
    Color colorPrenda = new Color(0, 0, 0);
    return new Prenda(tipoPrenda, materialPrenda, LISA, colorPrenda, null);
  }
  public void cargarGuardarropa() {
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
