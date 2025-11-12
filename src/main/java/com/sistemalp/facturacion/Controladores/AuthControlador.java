package com.sistemalp.facturacion.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemalp.facturacion.Dto.JwtResponse;
import com.sistemalp.facturacion.Dto.LoginRequest;
import com.sistemalp.facturacion.Entidades.Usuario;
import com.sistemalp.facturacion.Servicios.JwtService;
import com.sistemalp.facturacion.Servicios.UsuarioServicio;





@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:9090")
public class AuthControlador {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired 
    private JwtService jwtService;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        System.err.println(request+"datos que llegan");
        System.out.println("el clave es:"+request.getPassword());
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        System.out.println("el usuario es:"+request.getUsername());
        System.out.println("el clave es:"+request.getPassword());
        Usuario usuario = usuarioServicio.findByUsername(user.getUsername());
        String token = jwtService.generateToken(usuario.getUsername(),usuario.getTipoUsuario().getRol());
        return new JwtResponse(token,  usuario.getUsername());
    }

}
