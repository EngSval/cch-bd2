package br.com.bd2.usuario.controller;

import br.com.bd2.usuario.dto.UsuarioDto;
import io.quarkus.runtime.configuration.ProfileManager;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UsuarioController {

    public UsuarioDto changeDatabaseUser(UsuarioDto usuarioDto) {
        ProfileManager.setRuntimeDefaultProfile(usuarioDto.getProfileName());
        return usuarioDto;
    }

}
