package domain.usuario;

import domain.TestCase;
import domain.guardarropa.Guardarropa;
import domain.prenda.Propuesta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static domain.prenda.CategoriaPrenda.*;
import static domain.prenda.EstadoPropuesta.*;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest extends TestCase {
  Usuario usuario;
  Usuario usuaria;
  Propuesta propuestaAccesorio;
  Propuesta propuestaCalzado;

  @BeforeEach
  public void setup() {
    usuario = new Usuario("PepeElUser", "PepeContrasenia");
    usuaria = new Usuario("PepaLaUser", "PepaContrasenia");
    propuestaAccesorio = new Propuesta(generarPrenda(ACCESORIOS));
    propuestaCalzado = new Propuesta(generarPrenda(CALZADO));
    cargarGuardarropa();
  }

  @Test
  void puedoAgregarGuardarropas() {
    usuario.agregarGuardarropas(guardarropa);

    assertNotNull(usuario.getGuardarropas());
    assertTrue(usuario.estaEnGuardarropas(guardarropa));
  }

  @Test
  void puedoEliminarGuardarropas() {
    usuario.agregarGuardarropas(guardarropa);
    usuario.agregarGuardarropas(new Guardarropa());

    assertEquals(2, usuario.getGuardarropas().size());

    usuario.eliminarGuardarropas(guardarropa);

    assertEquals(1, usuario.getGuardarropas().size());
  }

  @Test
  void puedoProponerAUsuario() {
    usuario.proponerUsuario(usuaria, propuestaAccesorio);

    assertEquals(propuestaAccesorio, usuaria.getPropuestas().get(0));
  }

  @Test
  void puedoAceptarPropuesta() {
    usuaria.proponerUsuario(usuario, propuestaAccesorio);
    usuario.aceptarPropuesta(propuestaAccesorio);

    assertEquals(1, usuario.getPropuestas().size());
    assertEquals(propuestaAccesorio.getEstadoPropuesta(), usuario.getPropuestas().get(0).getEstadoPropuesta());
    assertEquals(ACEPTADA, usuario.getDecisiones().get(0).getPropuesta().getEstadoPropuesta());
  }

  @Test
  void puedoRechazarPropuesta() {
    usuario.proponerUsuario(usuaria, propuestaCalzado);
    usuario.proponerUsuario(usuaria, propuestaAccesorio);
    usuaria.rechazarPropuesta(propuestaCalzado);

    assertEquals(2, usuaria.getPropuestas().size());
    assertEquals(propuestaCalzado.getEstadoPropuesta(), usuaria.getPropuestas().get(0).getEstadoPropuesta());
    assertEquals(RECHAZADA, usuaria.getDecisiones().get(0).getPropuesta().getEstadoPropuesta());
  }
  @Test
  void puedoDeshacerPropuestaAceptada() {
    usuario.proponerUsuario(usuaria, propuestaCalzado);
    usuaria.aceptarPropuesta(propuestaCalzado);

    assertEquals(ACEPTADA, usuaria.getDecisiones().get(0).getPropuesta().getEstadoPropuesta());

    usuaria.getDecisiones().get(0).deshacerDecision();

    assertEquals(SIN_DECIDIR, usuaria.getPropuestas().get(0).getEstadoPropuesta());
  }
  @Test
  void puedoDeshacerPropuestaRechazada() {
    usuario.proponerUsuario(usuaria, propuestaCalzado);
    usuaria.rechazarPropuesta(propuestaCalzado);

    assertEquals(RECHAZADA, usuaria.getDecisiones().get(0).getPropuesta().getEstadoPropuesta());

    usuaria.getDecisiones().get(0).deshacerDecision();

    assertEquals(SIN_DECIDIR, usuaria.getPropuestas().get(0).getEstadoPropuesta());
  }
}
