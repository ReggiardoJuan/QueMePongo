package domain.sugerencia;

import domain.TestCase;
import domain.atuendo.Atuendo;
import domain.clima.ProveedorAccuweather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static domain.prenda.CategoriaPrenda.*;
import static org.junit.jupiter.api.Assertions.*;

public class SugeridorTest extends TestCase {
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
}
