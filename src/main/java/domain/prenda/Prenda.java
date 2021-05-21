package domain.prenda;

import lombok.Getter;

@Getter
public class Prenda {
  private TipoPrenda tipoPrenda;
  private Material material;
  private Trama trama;
  private Color colorPrincipal;
  private Color colorSecundario;

  public Prenda(TipoPrenda tipoPrenda, Material material, Trama trama, Color colorPrincipal, Color colorSecundario) {
    this.tipoPrenda = tipoPrenda;
    this.material = material;
    this.trama = trama;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  public CategoriaPrenda getCategoriaPrenda(){
      return tipoPrenda.getCategoriaPrenda();
  }
}

