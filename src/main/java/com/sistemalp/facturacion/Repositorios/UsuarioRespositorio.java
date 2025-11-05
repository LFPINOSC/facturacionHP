package com.sistemalp.facturacion.Repositorios;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemalp.facturacion.Entidades.Usuario;

public interface UsuarioRespositorio extends JpaRepository<Usuario,Long>{
    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);
}
