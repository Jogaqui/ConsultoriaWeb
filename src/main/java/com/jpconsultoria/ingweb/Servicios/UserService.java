package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.UserEntity;
import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long id);
    UserEntity createUser(UserEntity user);
    UserEntity updateUser(Long id, UserEntity user);
    void deleteUser(Long id);
}
