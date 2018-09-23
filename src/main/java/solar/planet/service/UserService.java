package solar.planet.service;

import solar.planet.entity.User;

public interface UserService {

    User save(User user);

    User findById(Integer id);

    User findByEmail(String email);
}
