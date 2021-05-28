package domain.clima;

import java.util.Random;

public class ProveedorMock implements ProveedorClima {
  private static final Random RANDOM = new Random();

  @Override
  public Double getTemperatura(String ciudad) {
    return (double) RANDOM.nextInt(40);
  }

  @Override
  public Double getPrecipitaciones(String ciudad) {
    return Double.valueOf(String.format("%.2f", RANDOM.nextDouble()));
  }
}
