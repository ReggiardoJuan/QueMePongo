package domain.prenda;

import lombok.Getter;

public abstract class DecisionPropuesta {
  @Getter
  protected Propuesta propuesta;

  public DecisionPropuesta(Propuesta propuesta) {
    this.propuesta = propuesta;
  }

  public abstract void deshacerDecision();
}
