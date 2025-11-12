package com.sistemalp.facturacion.Security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sistemalp.facturacion.Entidades.TipoUsuario;
import com.sistemalp.facturacion.Entidades.Usuario;
import com.sistemalp.facturacion.Repositorios.TipoUsuarioRepositorio;
import com.sistemalp.facturacion.Servicios.UsuarioServicio;


@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initData(TipoUsuarioRepositorio tipoUsuarioRepositorio, UsuarioServicio usuarioServicio){
        return args ->{
            if(!tipoUsuarioRepositorio.findAll().iterator().hasNext()){
                TipoUsuario tipoUsuario=new TipoUsuario();
                tipoUsuario.setDescripcion("administrador");
                tipoUsuario.setRol("administrador");
                tipoUsuarioRepositorio.save(tipoUsuario);
                TipoUsuario tipoUsuario1=new TipoUsuario();
                tipoUsuario1.setDescripcion("gerente");
                tipoUsuario1.setRol("gerente");
                tipoUsuarioRepositorio.save(tipoUsuario1);
                Usuario usuario =new Usuario();
                usuario.setNombre("admin");
                usuario.setCorreo("admin@ucacue.edu.ec");
                usuario.setUsername("admin");
                usuario.setPassword("admin");
                usuario.setTipoUsuario(tipoUsuario);
                usuarioServicio.guardar(usuario);
            }
        };
    }
}
