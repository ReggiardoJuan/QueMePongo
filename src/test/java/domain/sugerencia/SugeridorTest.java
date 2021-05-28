package domain.sugerencia;

import domain.guardarropa.Guardarropa;
import domain.atuendo.Atuendo;
import domain.clima.ProveedorAccuweather;
import domain.prenda.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static domain.prenda.CategoriaPrenda.*;
import static domain.prenda.Trama.LISA;
import static org.junit.jupiter.api.Assertions.*;

public class SugeridorTest {
  private static final Random RANDOM = new Random();
  Guardarropa guardarropa;
  Sugeridor sugeridor;

  @BeforeEach
  public void setup() {
    sugeridor = new Sugeridor(new ProveedorAccuweather(Duration.ofMinutes(60)));
    cargarGuardarropa();
  }

  @Test
  public void puedoSugerirAtuendos() {
    List<Atuendo> atuendosSugeridos = sugeridor.sugerirAtuendos(guardarropa, "Buenos Aires");
    ProveedorAccuweather proveedorAccuweather = new ProveedorAccuweather(Duration.ofMinutes(60));
    Double temperatura = proveedorAccuweather.getTemperatura("Buenos Aires");

    assertNotNull(atuendosSugeridos);
    assertSame(atuendosSugeridos.get(0).getCalzado().getCategoriaPrenda(), CALZADO);
    assertSame(atuendosSugeridos.get(0).getParteInferior().getCategoriaPrenda(), PARTE_INFERIOR);
    assertSame(atuendosSugeridos.get(0).getParteSuperior().getCategoriaPrenda(), PARTE_SUPERIOR);
    assertTrue(atuendosSugeridos
      .stream()
      .anyMatch(atuendo -> atuendo.getParteSuperior()
          .equals(guardarropa.conseguirPrendaApta(PARTE_SUPERIOR, temperatura).get(0))));
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
