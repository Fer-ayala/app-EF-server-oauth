package com.example.app_EF_server_oauth.service.impl;


import com.example.app_EF_server_oauth.model.Rol;
import com.example.app_EF_server_oauth.model.Usuario;
import com.example.app_EF_server_oauth.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {

    private final IUsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Usuario usuario = usuarioService.obtenerUsuarioXnombre(username);
        return crearUserDetail(usuario,
                obtenerRolesUsuario(usuario.getRoles()));
    }

    public List<GrantedAuthority> obtenerRolesUsuario(Set<Rol> rolesList){
        List<GrantedAuthority> rolesAuth = new ArrayList<>();
        for (Rol rol : rolesList){
            rolesAuth.add(new SimpleGrantedAuthority(
                    "ROLE_"+rol.getNomrol()));
        }
        return rolesAuth;
    }
    private UserDetails crearUserDetail(
            Usuario usuario, List<GrantedAuthority> authorityList
    ){
        return new User(
                usuario.getNomusuario(),
                usuario.getPassword(),
                usuario.getActivo(),
                true,
                true,
                true,
                authorityList);
    }


}
