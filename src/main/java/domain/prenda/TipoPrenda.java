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
  CAMISA(PARTE_SUPERIOR, Arrays.asList(ALGODON, JEAN, SEDA, PIQUE), 30D),
  CAMISOLA(PARTE_SUPERIOR, Arrays.asList(ALGODON, JEAN, SEDA, PIQUE), 40D),
  REMERA(PARTE_SUPERIOR, Arrays.asList(ALGODON, JEAN, SEDA, PIQUE), 40D),
  REMERA_MANGA_LARGA(PARTE_SUPERIOR, Arrays.asList(ALGODON, JEAN, SEDA, PIQUE), 20D),
  CHOMBA(PARTE_SUPERIOR, Arrays.asList(ALGODON, JEAN, SEDA, PIQUE), 35D),
  SACO(PARTE_SUPERIOR, Arrays.asList(ALGODON), 20D),
  CAMPERA(PARTE_SUPERIOR, Arrays.asList(ALGODON, JEAN, CUERO), 20D),
  ZAPATILLAS(CALZADO, Arrays.asList(ALGODON, JEAN, CUERO), 40D),
  ZAPATOS(CALZADO, Arrays.asList(CUERO), 30D),
  SANDALIA(CALZADO, Arrays.asList(ALGODON, CUERO), 45D),
  TACOS(CALZADO, Arrays.asList(ALGODON, CUERO), 40D),
  OJOTAS(CALZADO, Arrays.asList(CAUCHO, PLASTICO), 50D),
  PANTALON(PARTE_INFERIOR, Arrays.asList(ALGODON, JEAN, ACETATO), 25D),
  PANTALON_VESTIR(PARTE_INFERIOR, Arrays.asList(ALGODON), 25D),
  SHORT(PARTE_INFERIOR, Arrays.asList(ALGODON, JEAN, PIQUE), 45D),
  POLLERA(PARTE_INFERIOR, Arrays.asList(ALGODON, JEAN, PIQUE, CUERO), 35D),
  ROPA_INTERIOR(PARTE_INFERIOR, Arrays.asList(ALGODON, SEDA), 40D),
  CALZA(PARTE_INFERIOR, Arrays.asList(ALGODON), 20D),
  GORRA(ACCESORIOS, Arrays.asList(ALGODON), 30D),
  GORRO(ACCESORIOS, Arrays.asList(ALGODON, LANA), 15D),
  BUFANDA(ACCESORIOS, Arrays.asList(ALGODON, LANA), 15D),
  SOMBRERO(ACCESORIOS, Arrays.asList(ALGODON), 25D);

  @Getter private CategoriaPrenda categoriaPrenda;
  @Getter private List<Material> materialesPermitidos;
  @Getter private Double temperaturaMaxima;
}
