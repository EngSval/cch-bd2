package br.com.bd2.usuario.resource;

import br.com.bd2.usuario.controller.UsuarioController;
import br.com.bd2.usuario.dto.UsuarioDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/change-database-user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject
    UsuarioController usuarioController;

    @POST
    public Response changeDatabaseUser(UsuarioDto usuarioDto) {
        return Response.ok().entity(usuarioController.changeDatabaseUser(usuarioDto)).build();
    }

}
