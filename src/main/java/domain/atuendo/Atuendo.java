package domain.atuendo;

import domain.prenda.Prenda;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Atuendo {
  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;

  public Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado){
    this.parteSuperior = parteSuperior;
    this.parteInferior = parteInferior;
    this.calzado = calzado;
  }
}
