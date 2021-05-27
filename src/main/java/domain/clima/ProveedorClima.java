package domain.clima;

public interface ProveedorClima {
  Double getTemperatura(String ciudad);
  Double getPrecipitaciones(String ciudad);
}
