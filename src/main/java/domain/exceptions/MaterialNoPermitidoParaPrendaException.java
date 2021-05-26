package domain.exceptions;

public class MaterialNoPermitidoParaPrendaException extends RuntimeException {
  public MaterialNoPermitidoParaPrendaException() {
    super("El material cargado no se puede asociar a la prenda que se quiere crear");
  }
}
