package domain.guardarropa;

import domain.TestCase;
import domain.prenda.*;
import domain.usuario.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static domain.prenda.CategoriaPrenda.*;

public class GuardarropasTest extends TestCase {
  @BeforeEach
  public void setup() {
    cargarGuardarropa();
  }

  @Test
  public void puedoCargarPrendaEnGuardarropa() {
   Prenda prenda = generarPrenda(ACCESORIOS);
   guardarropa.addPrenda(prenda);

   assertTrue(guardarropa.getPrendas()
       .stream()
       .anyMatch(prendaEnGuardarropa -> prendaEnGuardarropa.equals(prenda)));
  }
  @Test
  public void puedoEliminarPrendaDeGuardarropa() {
    Prenda prenda = guardarropa.getPrendas().get(0);
    guardarropa.removePrenda(prenda);

    assertFalse(guardarropa.getPrendas()
        .stream()
        .anyMatch(prendaEnGuardarropa -> prendaEnGuardarropa.equals(prenda)));
  }
  @Test
  public void puedoObtenerPrendasAptas() {
    Double temperatura = (double) RANDOM.nextInt(40);
    List<Prenda> prendasAptas = guardarropa.conseguirPrendaApta(PARTE_SUPERIOR, temperatura);

    assertTrue(prendasAptas
        .stream()
        .allMatch(prenda -> prenda.getTipoPrenda().getTemperaturaMaxima() <= temperatura));
  }
  @Test
  public void puedoObtenerUsuariosDelGuardarropa() {
    Usuario usuario = new Usuario("PepeElUser", "PepeContrasenia");
    guardarropa.addUsuario(usuario);

    assertTrue(guardarropa.estaUsuario(usuario));
    assertEquals("PepeElUser", guardarropa.getUsuariosUsando().get(0).getNombreUsuario());
    assertEquals("PepeContrasenia", guardarropa.getUsuariosUsando().get(0).getContrasenia());
  }
  @Test
  public void puedoBorrarUsuariosDelGuardarropa() {
    Usuario usuario = new Usuario("PepeElUser", "PepeContrasenia");
    Usuario usuaria = new Usuario("PepaLaUser", "PepaContrasenia");
    guardarropa.addUsuario(usuario);
    guardarropa.addUsuario(usuaria);

    assertTrue(guardarropa.estaUsuario(usuario));
    assertTrue(guardarropa.estaUsuario(usuaria));

    guardarropa.removeUsuario(usuario);

    assertFalse(guardarropa.estaUsuario(usuario));
  }
}
