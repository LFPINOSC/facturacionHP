package com.sistemalp.facturacion.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemalp.facturacion.Entidades.TipoUsuario;

public interface TipoUsuarioRepositorio extends JpaRepository<TipoUsuario,Long>{
    
}
