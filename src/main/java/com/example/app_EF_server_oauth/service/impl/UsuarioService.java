package com.example.app_EF_server_oauth.service.impl;


import com.example.app_EF_server_oauth.model.Usuario;
import com.example.app_EF_server_oauth.repository.UsuarioRepository;
import com.example.app_EF_server_oauth.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerUsuarioXnombre(String nomUsuario) {
        return usuarioRepository.findByNomusuario(nomUsuario);
    }
}
