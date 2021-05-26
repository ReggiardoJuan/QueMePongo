package domain.prenda;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static domain.prenda.CategoriaPrenda.*;
import static domain.prenda.Material.*;

@AllArgsConstructor
public enum TipoPrenda {
  CAMISA(PARTE_SUPERIOR, Arrays.asList(ALGODON, JEAN, SEDA, PIQUE)),
  CAMISOLA(PARTE_SUPERIOR, Arrays.asList(ALGODON, JEAN, SEDA, PIQUE)),
  REMERA(PARTE_SUPERIOR, Arrays.asList(ALGODON, JEAN, SEDA, PIQUE)),
  CHOMBA(PARTE_SUPERIOR, Arrays.asList(ALGODON, JEAN, SEDA, PIQUE)),
  SACO(PARTE_SUPERIOR, Arrays.asList(ALGODON)),
  CAMPERA(PARTE_SUPERIOR, Arrays.asList(ALGODON, JEAN, CUERO)),
  ZAPATILLAS(CALZADO, Arrays.asList(ALGODON, JEAN, CUERO)),
  ZAPATOS(CALZADO, Arrays.asList(CUERO)),
  SANDALIA(CALZADO, Arrays.asList(ALGODON, CUERO)),
  TACOS(CALZADO, Arrays.asList(ALGODON, CUERO)),
  OJOTAS(CALZADO, Arrays.asList(CAUCHO, PLASTICO)),
  PANTALON(PARTE_INFERIOR, Arrays.asList(ALGODON, JEAN, ACETATO)),
  PANTALON_VESTIR(PARTE_INFERIOR, Arrays.asList(ALGODON)),
  SHORT(PARTE_INFERIOR, Arrays.asList(ALGODON, JEAN, PIQUE)),
  POLLERA(PARTE_INFERIOR, Arrays.asList(ALGODON, JEAN, PIQUE, CUERO)),
  ROPA_INTERIOR(PARTE_INFERIOR, Arrays.asList(ALGODON, SEDA)),
  CALZA(PARTE_INFERIOR, Arrays.asList(ALGODON)),
  GORRA(ACCESORIOS, Arrays.asList(ALGODON)),
  GORRO(ACCESORIOS, Arrays.asList(ALGODON, LANA)),
  BUFANDA(ACCESORIOS, Arrays.asList(ALGODON, LANA)),
  SOMBRERO(ACCESORIOS, Arrays.asList(ALGODON));

  @Getter private CategoriaPrenda categoriaPrenda;
  @Getter private List<Material> materialesPermitidos;
}
