package domain.apis;

import domain.clima.ProveedorAccuweather;
import domain.services.AccuWeatherAPI;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class AccuWeatherAPITest {
  @Test
  public void puedoObtenerElclima() {
    AccuWeatherAPI weather = new AccuWeatherAPI();
    System.out.println(weather.getWeather("Buenos Aires, Argentina").get(0).get("Temperature"));

    ProveedorAccuweather proveedor = new ProveedorAccuweather(Duration.ofMinutes(60));
  }
}