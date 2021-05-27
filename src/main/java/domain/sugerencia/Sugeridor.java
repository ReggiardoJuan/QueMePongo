package domain.sugerencia;

import com.google.common.collect.Sets;
import domain.Guardarropa;
import domain.atuendo.Atuendo;
import domain.clima.ProveedorClima;
import domain.prenda.Prenda;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static domain.prenda.CategoriaPrenda.*;
import static java.util.stream.Collectors.toList;

public class Sugeridor {
  @Setter
  private ProveedorClima proveedorClima;

  public Sugeridor(ProveedorClima proveedorClima) {
    this.proveedorClima = Objects.requireNonNull(proveedorClima, "proveedorClima no puede ser nulo");
  }

  public List<Atuendo> sugerirAtuendos(Guardarropa guardarropa, String ciudad) {
    Double temperatura = proveedorClima.getTemperatura(ciudad);
    List<Prenda> prendasSuperiores = guardarropa.conseguirPrendaApta(PARTE_SUPERIOR, temperatura);
    List<Prenda> prendasInferiores = guardarropa.conseguirPrendaApta(PARTE_INFERIOR, temperatura);
    List<Prenda> calzados = guardarropa.conseguirPrendaApta(CALZADO, temperatura);

    return Sets
        .cartesianProduct(new HashSet<>(prendasSuperiores), new HashSet<>(prendasInferiores), new HashSet<>(calzados))
        .stream()
        .map((list) -> new Atuendo(list.get(0), list.get(1), list.get(2)))
        .collect(toList());
  }
}
