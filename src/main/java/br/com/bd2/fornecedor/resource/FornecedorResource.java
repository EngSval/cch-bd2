package br.com.bd2.fornecedor.resource;

import java.util.UUID;

import br.com.bd2.fornecedor.controller.FornecedorController;
import br.com.bd2.fornecedor.dto.FornecedorDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/fornecedor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FornecedorResource {

    @Inject
    FornecedorController fornecedorController;

    @POST
    public Response create(FornecedorDto fornecedorDto) {
        return Response.ok().entity(fornecedorController.create(fornecedorDto)).build();
    }

    @GET
    @Path("{id}")
    public Response retrieveById(@PathParam("id") String uuid) {
        return Response.ok().entity(fornecedorController.retrieve(UUID.fromString(uuid))).build();
    }

    @GET
    public Response retrieveAll() {
        return Response.ok().entity(fornecedorController.retrieveAll()).build();
    }

    @PUT
    public Response update(FornecedorDto fornecedorDto) {
        return Response.ok().entity(fornecedorController.update(fornecedorDto)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String uuid) {
        if (fornecedorController.delete(UUID.fromString(uuid))) {
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }
    }
}
