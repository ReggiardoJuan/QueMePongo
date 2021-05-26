package domain.prenda;

import static domain.prenda.Material.*;
import static domain.prenda.TipoPrenda.*;

public class SastreSanJuan extends Sastre {

  @Override
  protected Prenda confeccionarParteSuperior() {
    BorradorPrenda borrador = new BorradorPrenda(CHOMBA);
    borrador.agregarMaterial(PIQUE);
    borrador.agregarTrama(null);
    borrador.agregarColorPrincipal(new Color(0, 255, 0));
    return borrador.crearPrenda();
  }

  @Override
  protected Prenda confeccionarParteInferior() {
    BorradorPrenda borrador = new BorradorPrenda(PANTALON);
    borrador.agregarMaterial(ACETATO);
    borrador.agregarTrama(null);
    borrador.agregarColorPrincipal(new Color(96, 96, 96));
    return borrador.crearPrenda();  }

  @Override
  protected Prenda confeccionarCalzado() {
    BorradorPrenda borrador = new BorradorPrenda(ZAPATILLAS);
    borrador.agregarMaterial(ALGODON);
    borrador.agregarTrama(null);
    borrador.agregarColorPrincipal(new Color(255, 255, 255));
    return borrador.crearPrenda();  }
}
