package domain.atuendo;

import domain.prenda.Prenda;

public abstract class Sastre {
  public Atuendo confeccionarUniforme() {
    return new Atuendo(this.confeccionarParteSuperior(), this.confeccionarParteInferior(), this.confeccionarCalzado());
  }
  protected abstract Prenda confeccionarParteSuperior();
  protected abstract Prenda confeccionarParteInferior();
  protected abstract Prenda confeccionarCalzado();
}
