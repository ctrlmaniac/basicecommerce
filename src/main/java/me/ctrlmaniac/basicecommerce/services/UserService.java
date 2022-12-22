package me.ctrlmaniac.basicecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ctrlmaniac.basicecommerce.models.User;
import me.ctrlmaniac.basicecommerce.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User reservation) {
        return userRepository.save(reservation);
    }


    public User getById(String id) {
        Optional<User> productOpt = userRepository.findById(id);

        if (productOpt.isPresent()) {
            return productOpt.get();
        }

        return null;
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public User updateById(String id, User newUser) {

        Optional<User> oldUserType = userRepository.findById(newUser.getId());

        if (oldUserType.isPresent()) {
            User oldUser = oldUserType.get();

            oldUser.setEmail(newUser.getEmail());
            oldUser.setFirstName(newUser.getFirstName());
            oldUser.setLastName(newUser.getLastName());

            return userRepository.save(oldUser);
        }
        return null;
    }
}
