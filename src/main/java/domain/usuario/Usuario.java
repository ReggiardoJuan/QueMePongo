package domain.usuario;

import domain.guardarropa.Guardarropa;
import domain.prenda.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static domain.prenda.EstadoPropuesta.*;

public class Usuario {
  @Getter
  private String nombreUsuario;
  @Setter
  private String contrasenia;
  @Getter
  private List<Guardarropa> guardarropas;
  @Getter
  private List<Propuesta> propuestas;
  @Getter
  private List<DecisionPropuesta> decisiones;


  public Usuario(String nombreUsuario, String contrasenia) {
    this.nombreUsuario = Objects.requireNonNull(nombreUsuario, "El nombreUsuario no puede ser nulo");
    this.contrasenia = Objects.requireNonNull(contrasenia, "La contrasenia no puede ser nulo");
    this.guardarropas = new ArrayList<>();
    this.propuestas = new ArrayList<>();
  }

  public void agregarGuardarropas(Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }
  public void eliminarGuardarropas(Guardarropa guardarropa) {
    this.guardarropas.remove(guardarropa);
  }
  public Boolean estaEnGuardarropas(Guardarropa guardarropa) {
    return guardarropa.estaUsuario(this);
  }
  public void agregarPropuesta(Propuesta propuesta) {
    this.propuestas.add(propuesta);
  }
  public void proponerUsuario(Usuario usuario, Propuesta propuesta) {
    usuario.agregarPropuesta(propuesta);
  }
  public void aceptarPropuesta(Propuesta propuesta) {
    propuesta.setEstadoPropuesta(ACEPTADA);
    decisiones.add(new DecisionAceptarPropuesta(propuesta));
  }
  public void rechazarPropuesta(Propuesta propuesta) {
    propuesta.setEstadoPropuesta(RECHAZADA);
    decisiones.add(new DecisionRechazarPropuesta(propuesta));
  }
}
