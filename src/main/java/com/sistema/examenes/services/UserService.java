package com.sistema.examenes.services;

import com.sistema.examenes.entitys.UserRol;
import com.sistema.examenes.entitys.User;

import java.util.Set;

public interface UserService {

    public User saveUser(User user, Set<UserRol> userRols) throws Exception;
}
