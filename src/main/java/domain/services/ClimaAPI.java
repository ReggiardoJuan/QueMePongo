package domain.services;

import java.util.List;
import java.util.Map;

public interface ClimaAPI {
  List<Map<String, Object>> getWeather(String ciudad);
}
