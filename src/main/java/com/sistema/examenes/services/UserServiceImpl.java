package com.sistema.examenes.services;

import com.sistema.examenes.entitys.User;
import com.sistema.examenes.entitys.UserRol;
import com.sistema.examenes.repository.RolRepository;
import com.sistema.examenes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public User saveUser(User user, Set<UserRol> userRols) throws Exception {
        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null) {
            System.out.println("User already exist ");
            throw new Exception("User is already present");
        } else {
            for (UserRol userRol:userRols) {
                rolRepository.save(userRol.getRol());
            }
            user.getUserRols().addAll(userRols);
            localUser = userRepository.save(user);
        }
        return localUser;
    }
}
