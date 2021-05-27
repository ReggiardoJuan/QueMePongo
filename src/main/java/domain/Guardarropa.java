package domain;

import domain.prenda.CategoriaPrenda;
import domain.prenda.Prenda;
import domain.usuario.Usuario;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Guardarropa {
  private List<Prenda> prendas;
  private List<Usuario> usuariosUsando;

  public Guardarropa() {
    this.prendas = new ArrayList<>();
    this.usuariosUsando = new ArrayList<>();
  }

  public void addPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void removePrenda(Prenda prenda) {
    this.prendas.remove(prenda);
  }

  public void addUsuario(Usuario usuario) {
    this.usuariosUsando.add(usuario);
  }

  public void removeUsuario(Usuario usuario) {
    this.usuariosUsando.remove(usuario);
  }

  public Boolean estaUsuario(Usuario usuario) {
    return usuariosUsando
        .stream()
        .anyMatch(usuarioUsando -> usuarioUsando.equals(usuario));
  }

  public List<Prenda> conseguirPrendaApta(CategoriaPrenda categoriaPrenda, Double temperatura) {
    return prendas
        .stream()
        .filter(prenda -> prenda.getCategoriaPrenda() == categoriaPrenda)
        .filter(prenda -> prenda.getTipoPrenda().getTemperaturaMaxima() <= temperatura)
        .collect(Collectors.toList());
  }
}
