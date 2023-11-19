package br.com.bd2.venda.resource;

import java.util.UUID;

import br.com.bd2.venda.controller.VendaController;
import br.com.bd2.venda.dto.VendaDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/venda")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VendaResource {
    
    @Inject
    VendaController vendaController;

    @POST
    public Response create(VendaDto vendaDto) {
        return Response.ok().entity(vendaController.create(vendaDto)).build();
    }

    @GET
    @Path("{id}")
    public Response retrieveById(@PathParam("id") String uuid) {
        return Response.ok().entity(vendaController.retrieve(UUID.fromString(uuid))).build();
    }

    @GET
    public Response retrieveAll() {
        return Response.ok().entity(vendaController.retrieveAll()).build();
    }

}
