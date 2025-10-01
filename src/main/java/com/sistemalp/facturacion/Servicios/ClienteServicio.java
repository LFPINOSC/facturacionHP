package com.sistemalp.facturacion.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemalp.facturacion.Entidades.Cliente;
import com.sistemalp.facturacion.Repositorios.ClienteRepositorio;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    public Cliente guardar(Cliente cliente){
        return clienteRepositorio.save(cliente);
    }
    public List<Cliente> listarAll(){
        return clienteRepositorio.findAll();
    }
    public Cliente buscarId(Long id){
        return clienteRepositorio.findById(id).orElse(null);
    }
    public void eliminar(Long id){
        clienteRepositorio.deleteById(id);
    }
}
