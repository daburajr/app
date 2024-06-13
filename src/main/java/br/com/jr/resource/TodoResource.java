package br.com.jr.resource;

import br.com.jr.infra.Page;
import br.com.jr.infra.Pageable;
import br.com.jr.mapper.TodoMapper;
import br.com.jr.model.Todo;
import br.com.jr.service.TodoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.List;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {


    @Inject
    TodoService todoService;

    @GET
    @Path("/{id}")
    public Todo findById(@PathParam("id") int id) {
        return todoService.findById(id);
    }

    @GET
    public Page<Todo> findAll(@QueryParam("page") int page,
                              @QueryParam("size") int size) {
        Pageable pageable = new Pageable(page, size);
        return todoService.findAll(pageable);
    }

    @POST
    public Response save(Todo todo) {
        todoService.save(todo);
        URI location = UriBuilder.fromResource(TodoResource.class)
                .path("{id}")
                .resolveTemplate("id", todo.getId())
                .build();
        return Response.created(location).entity(todo).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, Todo todo) {
        todoService.update(id, todo);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        todoService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
