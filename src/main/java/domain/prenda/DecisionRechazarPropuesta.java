package domain.prenda;

import static domain.prenda.EstadoPropuesta.SIN_DECIDIR;

public class DecisionRechazarPropuesta extends DecisionPropuesta {

  public DecisionRechazarPropuesta(Propuesta propuesta) {
    super(propuesta);
  }
  @Override
  public void deshacerDecision() {
    this.propuesta.setEstadoPropuesta(SIN_DECIDIR);
  }
}
