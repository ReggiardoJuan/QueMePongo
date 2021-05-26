package domain.prenda;

import domain.exceptions.MaterialNoPermitidoParaPrendaException;
import domain.exceptions.ParametroNuloException;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
public class BorradorPrenda {
  private TipoPrenda tipoPrenda;
  private Material material;
  private Trama trama;
  private Color colorPrincipal;
  private Color colorSecundario;

  public BorradorPrenda(TipoPrenda tipoPrenda){
    this.tipoPrenda = Objects.requireNonNull(tipoPrenda, "El tipo de prenda no puede ser nulo");
  }
  public void agregarMaterial(Material material){
    if(getTipoPrenda() == null) {
      throw new ParametroNuloException("Se debe definir el tipo de prenda primero");
    }
    if(!getTipoPrenda().getMaterialesPermitidos().contains(material) && material != null) {
      throw new MaterialNoPermitidoParaPrendaException();
    }
    this.material = Objects.requireNonNull(material, "El material no puede ser nulo");
  }
  public void agregarTrama(Trama trama){
    this.trama = trama != null ? trama : Trama.LISA;
  }
  public void agregarColorPrincipal(Color colorPrincipal){
    this.colorPrincipal = Objects.requireNonNull(colorPrincipal, "El color Principal no puede ser nulo");
  }
  public void agregarColorSecundario(Color colorSecundario){
    this.colorSecundario = colorSecundario;
  }
  public Prenda crearPrenda() {
    if(hayCampoNulo()){
      throw new ParametroNuloException("La prenda no puede ser creada con campos obligatorios nulos");
    }
    return new Prenda(tipoPrenda, material, trama, colorPrincipal, colorSecundario);
  }

  private Boolean hayCampoNulo() {
    return Arrays.stream(BorradorPrenda.class.getDeclaredFields())
        .anyMatch(parametroPrenda -> {
          try {
            return parametroPrenda.get(this) == null && !parametroPrenda.getName().equals("colorSecundario");
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          }
          return false;
        });
  }
}