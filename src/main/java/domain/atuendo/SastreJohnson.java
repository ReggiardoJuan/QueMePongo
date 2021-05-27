package domain.atuendo;

import domain.prenda.BorradorPrenda;
import domain.prenda.Color;
import domain.prenda.Prenda;

import static domain.prenda.Material.*;
import static domain.prenda.TipoPrenda.*;

public class SastreJohnson extends Sastre{

  @Override
  protected Prenda confeccionarParteSuperior() {
    BorradorPrenda borrador = new BorradorPrenda(CAMISA);
    borrador.agregarMaterial(ALGODON);
    borrador.agregarTrama(null);
    borrador.agregarColorPrincipal(new Color(255, 255, 255));
    return borrador.crearPrenda();
  }

  @Override
  protected Prenda confeccionarParteInferior() {
    BorradorPrenda borrador = new BorradorPrenda(PANTALON_VESTIR);
    borrador.agregarMaterial(ALGODON);
    borrador.agregarTrama(null);
    borrador.agregarColorPrincipal(new Color(0, 0, 0));
    return borrador.crearPrenda();  }

  @Override
  protected Prenda confeccionarCalzado() {
    BorradorPrenda borrador = new BorradorPrenda(ZAPATOS);
    borrador.agregarMaterial(CUERO);
    borrador.agregarTrama(null);
    borrador.agregarColorPrincipal(new Color(0, 0, 0));
    return borrador.crearPrenda();  }
}
