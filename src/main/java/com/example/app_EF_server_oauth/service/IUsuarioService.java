package com.example.app_EF_server_oauth.service;


import com.example.app_EF_server_oauth.model.Usuario;

public interface IUsuarioService {

    Usuario obtenerUsuarioXnombre(String nomUsuario);
}
