package com.github.toastshaman.pitest.resources;

import com.github.toastshaman.pitest.model.TodoItem;
import com.github.toastshaman.pitest.persistence.TodoStore;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
public class TodoResource {

    private final TodoStore store;

    public TodoResource(TodoStore store) {
        this.store = store;
    }

    @POST
    public Response createTodo(Map data) {
        return Response.ok(store.put(ImmutableMap.copyOf(data))).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id) {
        Optional<TodoItem> item = store.get(id);
        if (item.isPresent()) {
            return Response.ok(item).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
