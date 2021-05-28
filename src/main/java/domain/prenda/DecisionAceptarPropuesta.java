package domain.prenda;

import static domain.prenda.EstadoPropuesta.SIN_DECIDIR;

public class DecisionAceptarPropuesta extends DecisionPropuesta {

  public DecisionAceptarPropuesta(Propuesta propuesta) {
    super(propuesta);
  }
  @Override
  public void deshacerDecision() {
    this.propuesta.setEstadoPropuesta(SIN_DECIDIR);
  }
}
