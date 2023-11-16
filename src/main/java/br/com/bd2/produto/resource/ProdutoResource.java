package br.com.bd2.produto.resource;

import java.util.UUID;

import br.com.bd2.produto.controller.ProdutoController;
import br.com.bd2.produto.dto.ProdutoDto;
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

@Path("/produto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoController produtoController;

    @POST
    public Response create(ProdutoDto produtoDto) {
        return Response.ok().entity(produtoController.create(produtoDto)).build();
    }

    @GET
    @Path("{id}")
    public Response retrieveById(@PathParam("id") String uuid) {
        return Response.ok().entity(produtoController.retrieve(UUID.fromString(uuid))).build();
    }

    @GET
    public Response retrieveAll() {
        return Response.ok().entity(produtoController.retrieveAll()).build();
    }

    @PUT
    public Response update(ProdutoDto produtoDto) {
        return Response.ok().entity(produtoController.update(produtoDto)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String uuid) {
        if (produtoController.delete(UUID.fromString(uuid))) {
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }
    }
}
