package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.UserEntity;
import java.util.List;

public interface UserService {
  
  public List<UserEntity> listarClientes();
  public UserEntity crearCliente(UserEntity cliente);
  public int save(UserEntity c);
  public UserEntity obtenerCliente(Long id);
  public UserEntity actualizarCliente(UserEntity cliente);
  public void eliminarCliente(Long id);

