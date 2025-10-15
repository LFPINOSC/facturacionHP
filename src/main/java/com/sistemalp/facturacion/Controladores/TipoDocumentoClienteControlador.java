package com.sistemalp.facturacion.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemalp.facturacion.Entidades.TipoDocumentoCliente;
import com.sistemalp.facturacion.Servicios.TipoDocumentoClienteServicio;

@RestController
@RequestMapping("/api/tipodocumentocliente")
public class TipoDocumentoClienteControlador {
    @Autowired 
    private TipoDocumentoClienteServicio tipoDocumentoClienteServicio;

    @PostMapping
    public TipoDocumentoCliente guardar(@RequestBody TipoDocumentoCliente tipoDocumentoCliente){
        return tipoDocumentoClienteServicio.guardar(tipoDocumentoCliente);
    }
    @GetMapping
    public List<TipoDocumentoCliente> listarAll(){
        return tipoDocumentoClienteServicio.listarAll();
    }
}
