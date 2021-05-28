package domain.prenda;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import static domain.prenda.EstadoPropuesta.*;

@Getter
public class Propuesta {
  @Getter
  private Prenda prenda;
  @Getter
  @Setter
  private EstadoPropuesta estadoPropuesta;

  public Propuesta(Prenda prenda) {
    this.prenda = Objects.requireNonNull(prenda, "La prenda no puede ser nula");
    this.estadoPropuesta = SIN_DECIDIR;
  }
}
