package br.com.bd2.item.resource;

import java.util.UUID;

import br.com.bd2.item.controller.ItemController;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {
    
    @Inject
    ItemController itemController;

    @GET
    @Path("{id}")
    public Response retrieveById(@PathParam("id") String uuid) {
        return Response.ok().entity(itemController.retrieve(UUID.fromString(uuid))).build();
    }

    @GET
    public Response retrieveAll() {
        return Response.ok().entity(itemController.retrieveAll()).build();
    }

}
