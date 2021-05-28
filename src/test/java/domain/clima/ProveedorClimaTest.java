package domain.clima;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ProveedorClimaTest {
  ProveedorAccuweather proveedorAccuweather;
  ProveedorAccuweather proveedorTest;
  ProveedorClima proveedorMock;

  @Test
  public void puedoObtenerElClimaConAccuweather() {
    proveedorAccuweather = new ProveedorAccuweather(Duration.ofMinutes(60));

    assertEquals(Double.class, proveedorAccuweather.getTemperatura("Buenos Aires, Argentina").getClass());
    assertEquals(Double.class, proveedorAccuweather.getPrecipitaciones("Buenos Aires, Argentina").getClass());
  }

  @Test
  public void puedoRenovarElClimaAccuweather() {
    proveedorTest = mock (ProveedorAccuweather.class);
    proveedorAccuweather = new ProveedorAccuweather(Duration.ofMinutes(60));
    LocalDateTime expiracionInicial = proveedorAccuweather.getProximaExpiracion();

    when(proveedorTest.climaExpirado()).thenReturn(true);
    when(proveedorTest.getPeriodoExpiracion()).thenReturn(Duration.ofMinutes(60));
    when(proveedorTest.getProximaExpiracion()).thenReturn(LocalDateTime.now().plus(Duration.ofMinutes(120)));

    LocalDateTime expiracionFinal = proveedorTest.getProximaExpiracion();

    assertNotSame(expiracionFinal, expiracionInicial);
    assertEquals(expiracionFinal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
        expiracionInicial.plus(proveedorTest.getPeriodoExpiracion()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
  }

  @Test
  public void puedoObtenerElClimaConMock() {
    proveedorMock = new ProveedorMock();

    assertEquals(Double.class, proveedorMock.getTemperatura("Buenos Aires, Argentina").getClass());
    assertEquals(Double.class, proveedorMock.getPrecipitaciones("Buenos Aires, Argentina").getClass());
  }

}