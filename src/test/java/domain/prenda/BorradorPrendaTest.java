package domain.prenda;

import exceptions.MaterialNoPermitidoParaPrendaException;
import exceptions.ParametroNuloException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static domain.prenda.Trama.LISA;
import static domain.prenda.Trama.LUNARES;
import static org.junit.jupiter.api.Assertions.*;

class BorradorPrendaTest {
  private static final Random RANDOM = new Random();
  TipoPrenda tipoPrenda;
  Material materialPrenda;
  Trama tramaPrenda;
  Color colorPrenda;
  Color colorSecundario;
  BorradorPrenda borradorPrenda;

  @BeforeEach
  public void setup() {
    tipoPrenda = Arrays.asList(TipoPrenda.values()).get(RANDOM.nextInt(TipoPrenda.values().length));
    materialPrenda = tipoPrenda.getMaterialesPermitidos().get(RANDOM.nextInt(tipoPrenda.getMaterialesPermitidos().size()));
    tramaPrenda = Arrays.asList(Trama.values()).get(RANDOM.nextInt(Trama.values().length));
    colorPrenda = new Color(0, 0, 0);
    colorSecundario = new Color(255, 255, 255);
    borradorPrenda = new BorradorPrenda(tipoPrenda);
  }
  @Test
  void puedoCrearUnaPrendaSiTodosLosParametrosSonValidos() {
    borradorPrenda.agregarMaterial(materialPrenda);
    borradorPrenda.agregarTrama(tramaPrenda);
    borradorPrenda.agregarColorPrincipal(colorPrenda);
    borradorPrenda.agregarColorSecundario(colorSecundario);
    Prenda prenda = borradorPrenda.crearPrenda();

    assertEquals(tipoPrenda, prenda.getTipoPrenda());
    assertEquals(materialPrenda, prenda.getMaterial());
    assertEquals(tramaPrenda, prenda.getTrama());
    assertEquals(colorPrenda, prenda.getColorPrincipal());
    assertEquals(colorSecundario, prenda.getColorSecundario());
  }
  @Test
  void puedoCrearUnaPrendaConColorSecundarioNulo() {
    borradorPrenda.agregarMaterial(materialPrenda);
    borradorPrenda.agregarTrama(tramaPrenda);
    borradorPrenda.agregarColorPrincipal(colorPrenda);
    borradorPrenda.agregarColorSecundario(null);
    Prenda prenda = borradorPrenda.crearPrenda();

    assertEquals(tipoPrenda, prenda.getTipoPrenda());
    assertEquals(materialPrenda, prenda.getMaterial());
    assertEquals(tramaPrenda, prenda.getTrama());
    assertEquals(colorPrenda, prenda.getColorPrincipal());
    assertNull(prenda.getColorSecundario());
  }
  @Test
  void puedoAgregarTramaPorDefaultEnPrenda() {
    borradorPrenda.agregarTrama(null);

    assertEquals(LISA, borradorPrenda.getTrama());
  }
  @Test
  void puedoAgregarTramaEspecificaEnPrenda() {
    borradorPrenda.agregarTrama(LUNARES);

    assertEquals(LUNARES, borradorPrenda.getTrama());
  }
  @Test
  void noPuedoCrearBorradorSinTipoPrenda() {
    String mensaje = assertThrows(NullPointerException.class, () -> new BorradorPrenda(null)).getMessage();
    assertEquals("El tipo de prenda no puede ser nulo", mensaje);
  }
  @Test
  void noPuedoAgregarCamposNulosCuandoSonMandatory() {
    assertThrows(NullPointerException.class, () -> borradorPrenda.agregarMaterial(null));
    assertThrows(NullPointerException.class, () -> borradorPrenda.agregarColorPrincipal(null));
  }
  @Test
  void noPuedoCrearUnaPrendaConUnCampoNulo() {
    borradorPrenda.agregarTrama(tramaPrenda);
    borradorPrenda.agregarColorPrincipal(colorPrenda);
    borradorPrenda.agregarColorSecundario(null);
    assertThrows(ParametroNuloException.class, () -> borradorPrenda.crearPrenda());
  }
  @Test
  void noPuedoAgregarUnMaterialNoPermitidoParaElTipoDePrenda() {
    List<Material> materialesPermitidosParaPrenda = tipoPrenda.getMaterialesPermitidos();
    List<Material> materiales = new ArrayList<>(Arrays.asList(Material.values()));
    materiales.removeAll(materialesPermitidosParaPrenda);

    assertThrows(MaterialNoPermitidoParaPrendaException.class, () -> borradorPrenda.agregarMaterial(materiales.get(0)));
  }
}