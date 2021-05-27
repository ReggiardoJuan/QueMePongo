package domain.clima;

import domain.services.AccuWeatherAPI;
import domain.services.ClimaAPI;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProveedorAccuweather implements ProveedorClima{
  private ClimaAPI climaAPI;
  private Map<String, Object> ultimaRespuesta;
  private Duration periodoExpiracion;
  private LocalDateTime proximaExpiracion;

  public ProveedorAccuweather(Duration tiempoExpiracion) {
    this.climaAPI = new AccuWeatherAPI();
    this.ultimaRespuesta = new HashMap<>();
    this.periodoExpiracion =  Objects.requireNonNull(tiempoExpiracion, "El tiempoExpiracion no puede ser nulo");
    this.proximaExpiracion = LocalDateTime.now().plus(tiempoExpiracion);
  }

  @Override
  public Double getTemperatura(String ciudad) {
    return new Double((Integer) ((Map)getDatosCLimaticos(ciudad).get("Temperature")).get("Value"));
  }

  @Override
  public Double getPrecipitaciones(String ciudad) {
    return new Double((Integer) getDatosCLimaticos(ciudad).get("PrecipitationProbability"));
  }

  public Map<String, Object> getDatosCLimaticos(String ciudad) {
    if(ultimaRespuesta.isEmpty() || climaExpirado()) {
      ultimaRespuesta = climaAPI.getWeather(ciudad).get(0);
      renovarClima();
    }
    return ultimaRespuesta;
  }

  private Boolean climaExpirado() {
    return proximaExpiracion.isAfter(LocalDateTime.now());
  }
  private void renovarClima() {
    proximaExpiracion = LocalDateTime.now().plus(periodoExpiracion);
  }
}
