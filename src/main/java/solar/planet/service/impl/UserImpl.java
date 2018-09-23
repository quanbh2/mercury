package solar.planet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solar.planet.common.message.Text;
import solar.planet.entity.User;
import solar.planet.repository.UserRepository;
import solar.planet.service.UserService;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {

        return userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NullPointerException(Text.NOT_FOUND));
    }

    @Override
    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }
}
