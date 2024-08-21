package com.jpconsultoria.ingweb.Repositorios;



import com.jpconsultoria.ingweb.Entidades.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
