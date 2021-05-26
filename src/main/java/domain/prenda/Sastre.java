package domain.prenda;

public abstract class Sastre {

  public Uniforme confeccionarUniforme() {
    return new Uniforme(this.confeccionarParteSuperior(), this.confeccionarParteInferior(), this.confeccionarCalzado());
  }
  protected abstract Prenda confeccionarParteSuperior();
  protected abstract Prenda confeccionarParteInferior();
  protected abstract Prenda confeccionarCalzado();
}
