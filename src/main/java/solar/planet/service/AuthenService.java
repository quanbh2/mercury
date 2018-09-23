package solar.planet.service;

import java.util.Map;

public interface AuthenService {

    Map<String, Object> verify(String token);
}
