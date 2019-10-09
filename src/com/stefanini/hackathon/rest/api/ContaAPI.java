package com.stefanini.hackathon.rest.api;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackathon.rest.entity.Conta;
import com.stefanini.hackathon.rest.persistence.Repositorio;

@Path("/conta")
@Produces(MediaType.APPLICATION_JSON)
public class ContaAPI {
	@Inject Repositorio repositorio;
	
	@GET
	public Response consultar() {
		return Response.ok(repositorio.getMapConta()).build();
	}
	
	@GET
	@Path("/{id}")
	public Response consultar(@PathParam("id") Integer id) {
		return Response.ok(repositorio.getMapConta().get(id)).build();
	}
	
	@POST
	public Response inserir(Conta conta) {
		repositorio.getMapConta().put(conta.getId(), conta);
		return Response.ok(repositorio.getMapConta()).build();
	}
	
	@PUT
	@Path("/{id}")
	public Response alterar(Conta conta, @PathParam("id") Integer id) {
		repositorio.getMapConta().put(id, conta);
		return Response.ok(repositorio.getMapConta().get(id)).build();
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response excluir(@PathParam("id") Integer id) {
		repositorio.getMapConta().remove(id);
		return Response.ok(repositorio.getMapConta()).build();
	}
	
}
