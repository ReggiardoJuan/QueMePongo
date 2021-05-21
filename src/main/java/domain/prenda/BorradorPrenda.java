package domain.prenda;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

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
  public Prenda crearPrenda() throws Exception {
    if(hayCampoNulo()){
      throw new Exception("La prenda no puede ser creada por campos obligatorios nulos");
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